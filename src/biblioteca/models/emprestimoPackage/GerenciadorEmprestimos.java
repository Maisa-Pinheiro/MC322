package biblioteca.models.emprestimoPackage;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorEmprestimos {

    private static List<Emprestimo> todosEmprestimos = new ArrayList<>();

    public static void adicionarEmprestimo(Emprestimo emprestimo) {
        todosEmprestimos.add(emprestimo);
    }

    public static List<Emprestimo> obterTodosEmprestimos() {
        return todosEmprestimos;
    }
    
}
