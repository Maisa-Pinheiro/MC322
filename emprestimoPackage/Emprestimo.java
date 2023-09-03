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
    
    //    mudar o tipo ↓↓↓↓  de acordo com as classes que você criar
    	public static Emprestimo criarEmprestimoComAprovacao(LocalDate prazo, int registro, FuncionarioBiblioteca funcionario) {//colocar atributos, deixar esse ultimo no final->, FuncionarioBiblioteca funcionario
    	
    	//- essa parte do código faz com que só seja possivel chamar um objeto dessa classe se tiver um funcionário com o tipo de acesso certo, coloca em todas as classes que você criar
        //- só tire ||"Atendente".equals(acess) de multimidia e relatórios, essas classes são só para Administradores
        //- se tiver duvida de como criar o objeto exemplo na main é só olhar o exemplo "joão"
        //-apaga esses comentários depois
        
        String acess = funcionario.getacesso();
        if ( "Administrador".equals(acess)||"Atendente".equals(acess)) {
            return new Emprestimo(prazo, registro);//atributos, na mesma ordem, sem o funcionario
            //- mudar o tipo ⬆⬆⬆ aqui tbm
        } else {
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
        }
        
}