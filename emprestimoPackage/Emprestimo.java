package emprestimoPackage;

import java.time.LocalDate;
import pessoasPackage.FuncionarioBiblioteca;

public class Emprestimo {
    private int registro;
    public LocalDate prazo; // prazo de devolução

    private Emprestimo(LocalDate prazo, int registro) {// deixar o construtor privado pois só Administradores e
                                                       // Atendentes podem criar
        this.prazo = prazo;
        this.registro = registro;
    }

    public int getregistro() {
        return registro;
    }

    public void setregistro(int registro) {
        this.registro = registro;
    }

    public LocalDate getprazo() {
        return prazo;
    }
    
    // mudar o tipo ↓↓↓↓ de acordo com as classes que você criar
    public static Emprestimo criarEmprestimoComAprovacao(LocalDate prazo, int registro,
            FuncionarioBiblioteca funcionario) {// colocar atributos, deixar esse ultimo no final->,
                                                // FuncionarioBiblioteca funcionario

        // - essa parte do código faz com que só seja possivel chamar um objeto dessa
        // classe se tiver um funcionário com o tipo de acesso certo, coloca em todas as
        // classes que você criar
        // - só tire ||"Atendente".equals(acess) de multimidia e relatórios, essas
        // classes são só para Administradores
        // - se tiver duvida de como criar o objeto exemplo na main é só olhar o exemplo
        // "joão"
        // -apaga esses comentários depois

        String acess = funcionario.getacesso();
        if ("Administrador".equals(acess) || "Atendente".equals(acess)) {
            // Se o valor da variável "acess" for igual a "Administrador" ou "Atendente",
            // execute o seguinte bloco de código.
            return new Emprestimo(prazo, registro); // Crie um objeto Emprestimo e retorne-o
        } else {
            // Caso contrário, execute o seguinte bloco de código.
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Retorne null (ou você pode lançar uma exceção se preferir)
        }
    }

        /*condições de acesso de acordo com o perfil de pessoa*/
        
}