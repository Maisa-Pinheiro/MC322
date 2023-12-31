package biblioteca.models.emprestimoPackage;

import java.util.ArrayList;
import java.util.List;

// classe genérica com a lista de emprestimos, declarar objeto do tipo emprestimo na main
public class ListaEmprestimos<T> {

    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int id; // identificação das reservas
    private List<T> listaEmprestimos = new ArrayList<>(); // lista de emprestimos

    public ListaEmprestimos() {
        this.id = proximoId++;
    }

    public int getid() {
        return id;
    }

    /* metodo para adicionar um emprestimo a lista generica de emprestimos */
    public void addemprestimo(T emprestimo) {
        listaEmprestimos.add(emprestimo);
    }

    /* metodo para remover um emprestimo a lista generica de emprestimos */
    public void removereserva(T emprestimo) {
        listaEmprestimos.remove(emprestimo);
    }

    /* metodo para retornar a lista generica de emprestimos */
    public List<T> getlistaemprestimo() {
        return listaEmprestimos;
    }

}
