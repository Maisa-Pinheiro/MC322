package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.renovacaoReservaPackage.Renovacao;
import biblioteca.models.reservaSalaPackage.ReservaSala;
import biblioteca.models.reservaSalaPackage.ReservaSalaException;
import biblioteca.models.manutencaoPackage.Manutencao;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.renovacaoReservaPackage.ListaReserva;
import biblioteca.models.equipamentosPackage.Equipamentos;

public class BibliotecaControllerImpl implements BibliotecaController {

    private List<Multimidia> itens;
    private List<Emprestimo> emprestimos;
    private List<Manutencao> itensmanutencao;
    private Set<Multimidia.Categoria> categoriasusadas; /*
                                                         * categorias de itens presentes na biblioteca, o enum categoria
                                                         * possui todas as categorias possíveis, mas este atributo reúne
                                                         * as categorias de livros que estão na biblioteca
                                                         * pode não ter nenhum item de certa categoria do enum, por
                                                         * exempo
                                                         */

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
        emprestimos = new ArrayList<>();
        this.categoriasusadas = new HashSet<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        for (Multimidia item : itens) {
            categoriasusadas.add(item.getcategoria());
        }
    }

    @Override
    public void addmanutencao(Manutencao manutencao) {
        itensmanutencao.add(manutencao);
    }

    @Override
    public List<Multimidia> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public void addemprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    @Override
    public void addItemDisponivel(Multimidia item) {
        itens.add(item);
    }

    @Override
    public void removerItemDispoinvel(int id) {
        for (Multimidia item : itens) {
            if (id == item.getid()) {
                item = null;
                itens.remove(item);
            }
        }
    }

    @Override
    public void removeremprestimo(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (id == emprestimo.getregistro()) {
                emprestimo = null;
                emprestimos.remove(emprestimo);
            }
        }
    }

    @Override
    public Multimidia retornaritem(int id) {
        for (Multimidia item : itens) {
            if (id == item.getid()) {
                return item;

            }
        }
        return null;
    }

    @Override
    public Emprestimo retornaremprestimo(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (id == emprestimo.getregistro()) {
                return emprestimo;

            }
        }
        return null;
    }

    @Override
    public void emprestarItem(Pessoa membro, Multimidia item) throws BloqueioMembroException {

        Boolean liberado = membro.getpodeemprestar();

        if (!liberado) {
            throw new BloqueioMembroException(
                    "O membro está bloqueado e não pode fazer empréstimos, favor requisitar liberação");
        }
        if (item.disponibilidade == true) {
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), item, membro);
            item.numCopiasDisponiveis--;
            item.disponibilidade = false;
            membro.novoEmprestimo(emprestimo);
            emprestimo.SetemprestimosSemRepeticao(emprestimo); // set para garantir que um item não seja emprestado para
                                                               // dois membros ao mesmo tempo.
            addemprestimo(emprestimo);
            System.out.println("O item foi emprestado com sucesso.");
        } else {
            throw new IllegalArgumentException("o item não está disponível no momento");
        }
    }

    @Override
    public void liberacao(Pessoa pessoa) {
        // implementar lógica
    }

    @Override
    /* Reservar um item de multimidia */
    public void reservaritem(Pessoa membro, Multimidia item) {
        if (item.disponibilidade == true) {
            System.out.println("o item está disponível para empréstimo");
        } else {
            Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            item.addreserva(reserva);
            /* classe generica */
            ListaReserva<Multimidia> listaDeItens = new ListaReserva<>();
            listaDeItens.addreserva(item);
            System.out.println("o item foi reservado com sucesso");

        }
    }

    @Override
    /* Reservar um Equipamento - Classe generica */
    public void reservarEquipamento(Equipamentos equipamento) {
        /* precisa se implementada a logica que analisa a necessidade de emprestimo */
        ListaReserva<Equipamentos> listaDeItens = new ListaReserva<>();
        listaDeItens.addreserva(equipamento);
    }

    /*
     * Logica para verificar se a sala está disponivel ou não na data e horário da
     * solicitação de reserva
     */
    @Override
    public boolean salaReservada(int id, LocalDate data, LocalTime hora, int duracao) {

        /* percorrendo todas as reservas existentes na lista */
        if (ReservaSala.getlistaDReservaSalas() != null) {
            for (ReservaSala reserva : ReservaSala.getlistaDReservaSalas()) {
                if (reserva.getid() == id && reserva.getdata().equals(data)) {
                    LocalTime horaReservada = reserva.gethoraInicio();
                    int duracaoReservada = reserva.getduracao();
                    /* verificando conflito de horario */
                    if ((hora.isAfter(horaReservada) || hora.equals(horaReservada))
                            && hora.isBefore(horaReservada.plusHours(duracaoReservada))) {
                        return true; // A sala está reservada neste horário
                    }
                }
            }
        }
        return false;
    }

    @Override
    /* Reservar uma Sala */
    public void reservarSala(int id, LocalDate data, LocalTime hora, int duracao, int pessoas, int capaciadade) {
        try {
            /*
             * chamando a função que verifica se a sala está reservada no horário especifico
             */
            if (salaReservada(id, data, hora, duracao) == true) {
                System.out.println("\n");
                throw new ReservaSalaException("A sala já está reservada neste horário, tente outra data/horário.\n");
            }
            /* se a sala não estiver reservada no horário solicitado é criado uma reserva */
            else {
                /* se a capacidade maxima de pessoas para a sala for atingida */
                if (pessoas >= capaciadade) {
                    System.out.println("\n");
                    throw new ReservaSalaException("O número de pessoas está acima da capacidade máxima da sala, tente outra sala.\n");
                } else {
                    ReservaSala reserva = new ReservaSala(id, data, hora, duracao);

                    /*
                     * adicionando a classe generica de todas as reservas e a lista de reserva de
                     * salas respectivamente
                     */
                    ListaReserva<ReservaSala> listaDeItens = new ListaReserva<>();
                    listaDeItens.addreserva(reserva);
                    ReservaSala.addReservaDeSala(reserva);
                    System.out.println("\nSala reservada com sucesso!\n");
                }
            }
            /* tratando o catch */
        } catch (ReservaSalaException e) {
            System.out.println("Erro ao reservar a sala: " + e.getMessage());
        }
    }

    public void renovaremprestimo(Pessoa membro, Emprestimo emprestimo) {

        Renovacao renovacao = new Renovacao(true, membro);
        renovacao.renovar(emprestimo);

    }

    @Override
    public void devolverItem(Pessoa membro, Multimidia item, boolean dano) throws BloqueioMembroException {
        boolean emprestado = false;

        // Verifique se o item está na lista de empréstimos da pessoa
        for (Emprestimo emprestimo : membro.getemprestimos()) {
            if (emprestimo.getMultimidia().equals(item)) {
                emprestado = true;

                LocalDate prazo = emprestimo.getdataDevolucao();
                LocalDate today = LocalDate.now();

                // Verifique se o item está danificado
                if (item.isDanificado()) {
                    // Lança a exceção ItemDanificadoException
                    LocalDate prazo2 = today.plusDays(7);
                    Manutencao manutencao = new Manutencao(item, today, prazo2, "leve", "cola");
                    addmanutencao(manutencao);
                    throw new ItemDanificadoException("O item está danificado e deve ir para manutenção.");
                }

                if (prazo.isBefore(today)) {
                    long atraso2 = ChronoUnit.DAYS.between(today, prazo);
                    int atraso = (int) atraso2;
                    emprestimos.remove(emprestimo);
                    membro.setpodeemprestar(false);
                    emprestimo.setmulta(atraso, membro);
                    System.out.println(
                            "O membro devolveu o empréstimo com atraso, logo, não pode fazer empréstimos pelos próximos 20 dias, devendo pedir a liberação ao final desse prazo, junto ao pagamento da multa, de R$ "
                                    + emprestimo.getmulta());
                    membro.removeremprestimo(emprestimo);
                } else {
                    emprestimos.remove(emprestimo);
                    membro.removeremprestimo(emprestimo);

                    if (item.getsize() == 0) {
                        item.numCopiasDisponiveis++;
                        item.disponibilidade = true;
                        System.out.println("O item foi devolvido com sucesso ");
                    } else {
                        try {
                            if (dano) {
                                // Verifique se o item está danificado
                                if (item.isDanificado()) {
                                    // Lança a exceção ItemDanificadoException
                                    throw new ItemDanificadoException(
                                            "O item está danificado e não pode ser emprestado.");
                                } else {
                                    emprestarItem(item.getreservas().get(0).getpessoa(), item);
                                }
                            } else {
                                emprestarItem(item.getreservas().get(0).getpessoa(), item);
                            }
                        } catch (BloqueioMembroException e) {
                            System.out.println("Erro ao emprestar o item: " + e.getMessage());
                        }
                        item.remove(0);
                        System.out.println("O item foi devolvido com sucesso e emprestado ao membro "
                                + item.getreservas().get(0).getpessoa().getnome());
                    }
                }
                break;
            }
        }

        // Se o item não estiver na lista de empréstimos, lance uma exceção
        // personalizada
        if (!emprestado) {
            throw new ItemNaoEmprestadoException("O item não foi emprestado por este membro.");
        }
    }

    @Override
    public Set<Multimidia.Categoria> getCategoriasUsadas() {
        return categoriasusadas;
    }
}
