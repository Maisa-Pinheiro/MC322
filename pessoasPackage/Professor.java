package pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import emprestimoPackage.Emprestimo;
import renovacaoReservaPackage.Renovacao;

// Classe Professor que herda de Pessoa
public class Professor extends Pessoa {
    private String instituto;
    private List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Professor(é privado pois só funcionarios tem acesso)
    private Professor(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, String instituto) {
        super(nome, data, registro, contato, idade, endereco);
        this.instituto = instituto;
        this.emprestimos= new ArrayList<>();
        this.renovacoes = new ArrayList<>();
    }

    // getters e setters do professor
    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
    
    public void getemprestimos(){
         System.out.println("empréstimos do aluno:");
         for (Emprestimo emprestimo : emprestimos) {
            System.out.println( emprestimo.getregistro());
         }
         System.out.println("\n");
    }
    
    public void getrenovacoes(){
         System.out.println("renovações do aluno:");
         for (Renovacao renovacao : renovacoes) {
            System.out.println( renovacao.getregistro());
         }
         System.out.println("\n");
    }
    
    //adicionar renovações
        public void adicionarRenovacao(Renovacao renovacao) {
        renovacoes.add(renovacao);
    }

    
    //adicionar empréstimo
    public void novoEmprestimo(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	public static Professor criarProfessorAprovacao(String nome, LocalDate data, int registro,  String contato, int idade,
	String endereco, String instituto, FuncionarioBiblioteca funcionario) {
	     String acesso=funcionario.getacesso();
        if ( "Administrador".equals(acesso))
        {
            return new Professor(nome, data, registro, contato, idade, endereco, instituto);
        } else {
            System.out.println("Funcionário não autorizado a criar um professor.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
	}
}
