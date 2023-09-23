package biblioteca.models.emprestimoPackage;

import biblioteca.models.multimidiaPackage.*;
import biblioteca.models.reservaSalaPackage.*;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.pessoasPackage.*;

// classe genérica com a lista de emprestimos, declarar objeto do tipo emprestimo na main
public class ListaEmprestimos<T>
{

    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int id; // identificação das reservas
    private List<T> listaEmprestimos = new ArrayList<>(); // lista de emprestimos

    public ListaEmprestimos() {
        this.id = proximoId++;
    }

    public int getid() {
        return id;
    }

    public void addreserva(T emprestimo){
        listaEmprestimos.add(emprestimo);
    }

    public void removereserva(T emprestimo){
        listaEmprestimos.remove(emprestimo);
    }
    

    public List<T> getlistaemprestimo(){
        return listaEmprestimos;
    }
    
}
