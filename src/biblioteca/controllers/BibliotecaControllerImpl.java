package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.renovacaoReservaPackage.Renovacao;
import biblioteca.models.manutencaoPackage.Manutencao;
import biblioteca.models.pessoasPackage.Pessoa;


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
        itensmanutencao = new ArrayList<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        for (Multimidia item : itens) {
            categoriasusadas.add(item.getcategoria());
        }
    }

    @Override
    public List<Multimidia> getitensDisponiveis(){
        return itens;
    }

    @Override
    public void addmanutencao(Manutencao manutencao){
        itensmanutencao.add(manutencao);
    }

    @Override
    public List<Multimidia> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public void addemprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    @Override
    public void addItemDisponivel(Multimidia item){
        itens.add(item);
    }

    @Override
    public void removerItemDispoinvel(int id){
        for (Multimidia item : itens) {
            if(id == item.getid()){
                item=null;
                itens.remove(item);
            }
        }
    }

     @Override
    public void removeremprestimo(int id){
        for (Emprestimo emprestimo : emprestimos) {
            if(id == emprestimo.getregistro()){
                emprestimo=null;
                emprestimos.remove(emprestimo);
            }
        }
    }

    @Override
    public Multimidia retornaritem(int id){
        for (Multimidia item : itens) {
            if(id == item.getid()){
               return item;
               
            }
        }
        return null;
    }

    @Override
    public Emprestimo retornaremprestimo(int id){
        for (Emprestimo emprestimo : emprestimos) {
            if(id == emprestimo.getregistro()){
               return emprestimo;
               
            }
        }
        return null;
    }

    @Override
    public void emprestarItem(Pessoa membro, Multimidia item)throws BloqueioMembroException {
       
        Boolean liberado = membro.getpodeemprestar();
        
    
        if (!liberado) {
            throw new BloqueioMembroException("O membro está bloqueado e não pode fazer empréstimos, favor requisitar liberação");
        }
        if (item.disponibilidade == true) {
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), item, membro);
            item.numCopiasDisponiveis--;
            item.disponibilidade = false;
            membro.novoEmprestimo(emprestimo);
            emprestimo.SetemprestimosSemRepeticao(emprestimo); // set para garantir que um item não seja emprestado para dois membros ao mesmo tempo.
            addemprestimo(emprestimo);
            System.out.println("O item foi emprestado com sucesso.");
        } else {
             throw new IllegalArgumentException("o item não está disponível no momento");
            /*Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            item.addreserva(reserva);
            System.out.println("o item foi reservado com sucesso");
            */
        }
    }

    @Override
    public void liberacao(Pessoa pessoa) {
        // implementar lógica
    }

    @Override
    public void reservaritem(Pessoa membro, Multimidia item){
        if (item.disponibilidade == true) {
            System.out.println("o item está disponível para empréstimo");
        }else{
            Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            item.addreserva(reserva);
            System.out.println("o item foi reservado com sucesso");

        }
            
    }

    public void renovaremprestimo(Pessoa membro,Emprestimo emprestimo){
        
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
                LocalDate prazo2= today.plusDays(7);
                Manutencao manutencao= new Manutencao(item, today, prazo2,  "leve", "cola");
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
                                throw new ItemDanificadoException("O item está danificado e não pode ser emprestado.");
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

    // Se o item não estiver na lista de empréstimos, lance uma exceção personalizada
    if (!emprestado) {
        throw new ItemNaoEmprestadoException("O item não foi emprestado por este membro.");
    }
}


    @Override
    public Set<Multimidia.Categoria> getCategoriasUsadas() {
        return categoriasusadas;
    }
}
