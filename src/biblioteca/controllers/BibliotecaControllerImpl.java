package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.emprestimoPackage.ListaEmprestimos;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.renovacaoReservaPackage.Renovacao;
import biblioteca.models.reservaSalaPackage.ReservaSala;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.renovacaoReservaPackage.ListaReserva;
import biblioteca.models.equipamentosPackage.Equipamentos;

public class BibliotecaControllerImpl implements BibliotecaController {

    private List<Multimidia> itens;
    private List<Emprestimo> emprestimos;
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
    public void emprestarItem(Pessoa membro, Multimidia item) {

        Boolean liberado = membro.getpodeemprestar();
        if (liberado == false) {
            System.out.println("O membro está bloqueado e não pode fazer empréstimos, favor requisitar liberação");
            return;
        }
        if (item.disponibilidade == true) {
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), item, membro);
            item.numCopiasDisponiveis--;
            item.disponibilidade = false;
            membro.novoEmprestimo(emprestimo);
            emprestimo.SetemprestimosSemRepeticao(emprestimo); // set para garantir que um item não seja emprestado para
                                                               // dois membros ao mesmo tempo.
            addemprestimo(emprestimo);
            /* adicionando o emprestimo a classe generica */
            ListaEmprestimos<Multimidia> listaDeEmprestimos = new ListaEmprestimos<>();
            listaDeEmprestimos.addemprestimo(item);

            System.out.println("O item foi emprestado com sucesso.");
        } else {
            Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            item.addreserva(reserva);
            System.out.println("o item foi reservado com sucesso");

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

    @Override
    /* Reservar uma Sala - Classe generica */
    public void reservarSala(ReservaSala sala) {
        /* precisa se implementada a logica que analisa a necessidade de emprestimo */
        ListaReserva<ReservaSala> listaDeItens = new ListaReserva<>();
        listaDeItens.addreserva(sala);
    }

    public void renovaremprestimo(Pessoa membro, Emprestimo emprestimo) {

        Renovacao renovacao = new Renovacao(true, membro);
        renovacao.renovar(emprestimo);

    }

    @Override
    public void devolverItem(Pessoa membro, Multimidia item) {
        for (Emprestimo emprestimo : membro.getemprestimos()) {
            if (emprestimo.getMultimidia().equals(item)) {
                LocalDate prazo = emprestimo.getdataDevolucao();
                LocalDate today = LocalDate.now();
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
                    break;
                } else {
                    emprestimos.remove(emprestimo);
                    membro.removeremprestimo(emprestimo);
                    if (item.getsize() == 0) {
                        item.numCopiasDisponiveis++;
                        item.disponibilidade = true;

                        System.out.println("O item foi devolvido com sucesso ");
                    } else {
                        emprestarItem(item.getreservas().get(0).getpessoa(), item);
                        item.remove(0);
                    }
                    System.out.println("O item foi devolvido com sucesso e emprestado ao membro "
                            + item.getreservas().get(0).getpessoa().getnome());
                    break;
                }
            }
        }

    }

    @Override
    public Set<Multimidia.Categoria> getCategoriasUsadas() {
        return categoriasusadas;
    }
}
