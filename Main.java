
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Emprestimo{
    private int registro;
    public LocalDate prazo;// prazo de devolução
    
    private Emprestimo(LocalDate prazo, int registro){// deixar o construtor privado pos só Administradores e Atendentes podem criar
        this.prazo= prazo;
        this.registro=registro;
    }
    
    public void setregistro(int registro){
        this.registro = registro;
    }
    
    public LocalDate getprazo(){
        return prazo;
    }
    
    public int getregistro(){
        return registro;
    }
    //    mudar o tipo ↓↓↓↓  de acordo com as classes que você criar
    	public static Emprestimo criarEmprestimoComAprovacao(LocalDate prazo, int registro, FuncionarioBiblioteca funcionario) {//colocar atributos, deixar esse ultimo no final->, FuncionarioBiblioteca funcionario
    	
    	//- essa parte do código faz com que só seja possivel chamar um objeto dessa classe se tiver um funcionário com o tipo de acesso certo, coloca em todas as classes que você criar
        //- só tire ||"Atendente".equals(acess) de multimidia e relatórios, essas classes são só para Administradores
        //- se tiver duvida de como criar o objeto exemplo na main é só olhar o exemplo "joão"
        //-apaga esses comentários depois
        
        String acess=funcionario.getacesso();
        if ( "Administrador".equals(acess)||"Atendente".equals(acess)) {
            return new Emprestimo(prazo, registro);//atributos, na mesma ordem, sem o funcionario
            //- mudar o tipo ⬆⬆⬆ aqui tbm
        } else {
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
        }
        
}

class Multimidia{
    private String nome;// título
    private int numeroCopias;// quantidade de cópias
    public int disponivel;// qtd de cópias disponíveis, muda com frequência
    private int copia;//numero da cópia do objeto
    public boolean copiadisponivel;// true se a cópia em questão está disponível, false se não está
    
    public Multimidia(String nome, int numeroCopias, int copia, int disponivel, boolean copiadisponivel){
        this.nome =nome;
        this.numeroCopias = numeroCopias;
        this.copia= copia;
        this.disponivel= disponivel;
        this.copiadisponivel=copiadisponivel;
    }
    
    public int getnumero(){
        return numeroCopias;
    }
    public int getcopia(){
        return copia;
    }
    public String getnome(){
        return nome;
    }
   
    
    
}
class Renovacao{ // classe dedicada a renovações e reservas inteligentes
    private boolean tipo; // true - renovação, false- reserva
	private int registro; // registro de identificação renovação ou reserva
	private Pessoa pessoa; // pessoa que está fazendo a renovação ou reserva

	/* construtor dedicado apenas às usuarios */
	private Renovacao(boolean tipo, int registro, Pessoa pessoa) {
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.registro = registro;

	}

	/* getters para os atributos privados */
	public String getpessoa() {
		return pessoa.getnome();
	}

	public boolean gettipo() {
		return tipo;
	}

	public int getregistro() {
		return registro;
	}

	/*
	 * a classe não tem setters pois os atributos não podem ser mudados
	 */

	// renovação

	public void renovar(Emprestimo emprestimo) {
	    LocalDate dataHoje = LocalDate.now();
	    if (pessoa instanceof AlunoGraduacao) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(15);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof AlunoPosGraduacao) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(20);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof Professor) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(30);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof FuncionarioBiblioteca) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(30);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else {
            System.out.println(pessoa.getnome() + " não é um membro da biblioteca, logo, não pode  fazer renovações, favor fazer cadastro");
        }
	    
		
	}

	// reserva
	
	public void reservar(Multimidia item) {
	    if(item.copiadisponivel==true){
	        System.out.println("A cópia desejada do livro está disponivel para empréstimo, não é permitido reservá-la");
	    }else{
            if (item.disponivel > 0) {
			System.out.println("Outras cópias do livro estão disponiveis para empréstimo, não é permitido reservar uma cópia em específico");
		    } else {
			item.disponivel = item.disponivel - 1;
			System.out.println("O livro está reservado para " + pessoa.getnome() + ", o usuário será avisado quando o mesmo puder ser retirado");
		    }
	    }
	}
	
		public static Renovacao criarRenovacaoAprovacao(boolean tipo, int registro, Pessoa pessoa, FuncionarioBiblioteca funcionario) {
        String acess=funcionario.getacesso();
        if ( "Administrador".equals(acess)||"Atendente".equals(acess)) {
            return new Renovacao(tipo, registro, pessoa);
        } else {
            System.out.println("Funcionário não autorizado a criar uma renovação/reserva.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
        }
}

class Pessoa { // pessoa não será uma classe abstrata, pois uma pessoa pode não ser nem, aluno, nem professor, nem funcionário, mas ainda estar na biblioteca(um visitante, por exemplo)
    private String nome;
    private LocalDate data;// Data de Registro
    private int registro;// Número de Identificação da Universidade
    private String contato; // e-mail ou telefone
    private int idade; 
    private String endereco;

    /* construtor dedicado apenas aos usuarios */
    public Pessoa(String nome, LocalDate data, int registro,  String contato, int idade,String endereco) {
        this.nome = nome;
        this.data = data;
        this.registro = registro;
        this.contato = contato;
        this.idade = idade;
        this.endereco = endereco;
    }

    /* getters para os atributos privados */
    public String getnome() {
        return nome;
    }

    public LocalDate getdata() {
        return data;
    }

    public int getregistro() {
        return registro;
    }

    public String getcontato() {
        return contato;
    }


    public int getidade() {
        return idade;
    }

    public String getendereco() {
        return endereco;
    }

    /*
     * setters dos atributos que não mudam com frequência(atributos que não serão
     * mudados não tem setter)
     */
    public void setnome(String nome) {
        this.nome = nome;
    }



    public void setendereco(String endereco) {
        this.endereco = endereco;
    }
}

// Classe Funcionário da Biblioteca que herda de Pessoa
 class FuncionarioBiblioteca extends Pessoa {
    private String cargo;
    private float salario;
    private String horario;// horário de trabalho (ex: das 9h30 às 18h30)
    private List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações
    private String acesso;// tipo de acesso, será verificado nas operações de classes que exigem certo nível de acesso

    // Construtor da classe Funcionário da Biblioteca(é publico pois precisa-se de pelo menos um funcionário criado sem permissão para criar os outros)
    public FuncionarioBiblioteca(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, 
    String cargo, float salario, String horario, String acesso) {
        super(nome, data, registro, contato, idade, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.horario = horario;
        this.emprestimos= new ArrayList<>();
        this.renovacoes = new ArrayList<>();
        this.acesso = acesso;// gerente, atendente, administrador
    }

    // Método específico para Funcionário da Biblioteca
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
        
    }
    
    public String getacesso() {
        return acesso;
    }

    public void setacesso(String acesso) {
        this.acesso = acesso;
        
    }
    
    public float getsalario() {
        return salario;
    }

    public void setsalario(float salario) {
        this.salario = salario;
        
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
	
	public static FuncionarioBiblioteca criarFuncionarioAprovacao(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, 
    String cargo, float salario, String horario, String acesso, FuncionarioBiblioteca funcionario) {
        String acess=funcionario.getacesso();
        if ( "Administrador".equals(acess)) {
            return new FuncionarioBiblioteca(nome, data, registro, contato, idade, endereco, cargo, salario, horario, acesso);
        } else {
            System.out.println("Funcionário não autorizado a criar um Funcionário.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
        }
}

 class AlunoGraduacao extends Pessoa {
    private int ra;
    private String curso;
   private List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
   private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Aluno de Graduação(é privado pois só funcionarios tem acesso)
    private AlunoGraduacao(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, int ra,
    String curso) {
        super(nome, data, registro, contato, idade, endereco);
        this.ra = ra;
        this.emprestimos= new ArrayList<>();
         this.renovacoes = new ArrayList<>();
    }

    // Método específico para Aluno de Graduação
     public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public int getra() {
        return ra;
    }

    public void setra(int ra) {
        this.ra = ra;
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
	
	//autorização do funcionário
	public static AlunoGraduacao criarAlunoGraduacaoComAprovacao(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, int ra,
    String curso, FuncionarioBiblioteca funcionario) {
         String acesso=funcionario.getacesso();
        if ( "Administrador".equals(acesso)) {
            return new AlunoGraduacao(nome, data, registro, contato, idade, endereco, ra, curso);
        } else {
            System.out.println("Funcionário não autorizado a criar um aluno de graduação.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
    }
}

// Classe Aluno de Pós-Graduação que herda de Pessoa
 class AlunoPosGraduacao extends Pessoa {
    private int ra;
    private String curso;
    private List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Aluno de Pós-Graduação (é privado pois só funcionarios tem acesso)
    private AlunoPosGraduacao(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, int ra, String curso) {
        super(nome, data, registro, contato, idade, endereco);
        this.curso = curso;
        this.ra = ra;
        this.emprestimos= new ArrayList<>();
        this.renovacoes = new ArrayList<>();
    }

    // setters e getters
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public int getra() {
        return ra;
    }

    public void setra(int ra) {
        this.ra = ra;
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
	
	public static AlunoPosGraduacao criarAlunoPosAprovacao(String nome, LocalDate data, int registro,  String contato, int idade,String endereco, int ra, String curso
	, FuncionarioBiblioteca funcionario) {
	     String acesso=funcionario.getacesso();
        if ( "Administrador".equals(acesso)) {
            return new AlunoPosGraduacao(nome,data, registro, contato, idade, endereco, ra, curso);
        } else {
            System.out.println("Funcionário não autorizado a criar um aluno de pós graduação.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
	}
	
}

// Classe Professor que herda de Pessoa
 class Professor extends Pessoa {
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





public class Main {
    public static void main(String[] args) {

        // Criando um usuário (Membro)
        
        FuncionarioBiblioteca funcionario = new FuncionarioBiblioteca("Maria", LocalDate.now(), 5430, "funcionario@biblioteca.com",55 ,
        "Rua BC, 22", "Supervisora geral", 10000.00f, "das 8h às 18h", "Administrador");
        
        AlunoGraduacao aluno = AlunoGraduacao.criarAlunoGraduacaoComAprovacao("João", LocalDate.now(), 52420,"joao@dac.unucamp.com.br", 20,  "Rua A 12345", 244006, "engenharia", funcionario);
    System.out.println("Nome do aluno: " + aluno.getnome() +" RA do aluno: " + aluno.getra()+"; " + aluno.getdata());
        
        Multimidia livro = new Multimidia("livro1", 10,3,0, false);
        
        Emprestimo emprestimo =Emprestimo.criarEmprestimoComAprovacao(LocalDate.of(2023, 9, 15), 124, funcionario);
        aluno.novoEmprestimo(emprestimo);
        
        System.out.println("emprestimo de joão" + emprestimo.getprazo());
      
        Renovacao renovacao2= Renovacao.criarRenovacaoAprovacao(true, 1234, aluno,funcionario);
        System.out.println("copias disponíveis " + livro.disponivel);
        aluno.adicionarRenovacao(renovacao2);
        aluno.getemprestimos();
        aluno.getrenovacoes();
        
        renovacao2.renovar(emprestimo);
        
        renovacao2.reservar(livro);
        System.out.println("empréstimo de joão" + emprestimo.getprazo());
         System.out.println("copias disponíveis " + livro.disponivel);
    }
}


