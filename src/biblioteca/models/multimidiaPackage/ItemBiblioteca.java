package biblioteca.models.multimidiaPackage;
import biblioteca.models.pessoasPackage.*;
import biblioteca.models.emprestimoPackage.*;
import biblioteca.models.renovacaoReservaPackage.*;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class ItemBiblioteca<T extends Multimidia>{
    
    private List<T> itensReservados;
    private List<T> itensEmprestados;
    private int numeroDeItensEmprestados;
    private int numeroDeItensReservados;

    public ItemBiblioteca() {
        itensReservados = new ArrayList<>();
        itensEmprestados = new ArrayList<>();
        numeroDeItensEmprestados = 0;
        numeroDeItensReservados = 0;
    }

    public void reservarItem(T item) {
        if (!itensReservados.contains(item)) {

            itensReservados.add(item);
            numeroDeItensReservados++;
        }
    }

    public void emprestarItem(T item, Pessoa membro) {
        if ( !itensEmprestados.contains(item)) {
             if (!membro.getpodeemprestar()) {
            System.out.println("O membro está bloqueado e não pode fazer empréstimos, favor requisitar liberação.");
            return;
             }
        }

        if (item.disponibilidade) {
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), item, membro);
            item.SetnumCopiasDisponiveis(item.getnumCopiasDisponiveis() - 1);
            item.disponibilidade=false;
            membro.novoEmprestimo(emprestimo);
            emprestimo.SetemprestimosSemRepeticao(emprestimo);
            itensReservados.remove(item);
            itensEmprestados.add(item);
            numeroDeItensReservados--;
            numeroDeItensEmprestados++;

            System.out.println("O item foi emprestado com sucesso.");
        } else {
            Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            item.addreserva(reserva);
            itensReservados.add(item);
            numeroDeItensReservados++;
            System.out.println("O item foi reservado com sucesso.");
        }


    }  

    public void devolverItem(Pessoa membro, T item) {
        for (Emprestimo emprestimo : membro.getemprestimos()) {
            if (emprestimo.getMultimidia().equals(item) && itensEmprestados.contains(item)) {
                LocalDate prazo = emprestimo.getdataDevolucao();
                LocalDate today = LocalDate.now();
                if (prazo.isBefore(today)) {
                    long atraso2 = ChronoUnit.DAYS.between(today, prazo);
                    int atraso = (int) atraso2;

                    membro.setpodeemprestar(false);
                    emprestimo.setmulta(atraso, membro);
                    System.out.println(
                            "O membro devolveu o empréstimo com atraso, logo, não pode fazer empréstimos pelos próximos 20 dias, devendo pedir a liberação ao final desse prazo, junto ao pagamento da multa, de R$ "
                                    + emprestimo.getmulta());
                    membro.removeremprestimo(emprestimo);
                    itensEmprestados.remove(item);
                    numeroDeItensEmprestados--;
                    break;
                } else {
                    membro.removeremprestimo(emprestimo);
                    itensEmprestados.remove(item);
                    numeroDeItensEmprestados--;
                    if (item.getnumCopias() < item.getnumCopiasDisponiveis()) {
                        item.SetnumCopiasDisponiveis(item.getnumCopiasDisponiveis() + 1);
                        item.disponibilidade=true;
                        System.out.println("O item foi devolvido com sucesso ");
                    } else {
                        // Verificar se há reservas para o item e emprestar para o próximo membro na fila
                        if (!item.getreservas().isEmpty()) {
                            Pessoa proximoMembro = item.getreservas().get(0).getpessoa();
                            emprestarItem(item, proximoMembro);
                            item.getreservas().remove(0);
                            System.out.println("O item foi devolvido com sucesso e emprestado ao membro " + proximoMembro.getnome());
                        } else {
                            System.out.println("O item foi devolvido com sucesso ");
                        }
                    }
                    break;
                }
            
            }
        }
    }
    

    public int getNumeroDeItensEmprestados() {
        return numeroDeItensEmprestados;
    }

    public int getNumeroDeItensReservados() {
        return numeroDeItensReservados;
    } 

}
