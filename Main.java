
//package begin;

/*classe dedicada apenas aos livros*/
class Livro {
	public String titulo;
	public String autor;
	private int registro; // registro do livro para a bibliotéca
	private String editora;
	private int edicao;
	private String categoria; // biografia, fantasia, infantil, etc
	public int copias;// quantas cópias do livro a biblioteca possui
	public int disponivel; // quantas cópias estão disponpiveis para empréstimo

	// construtor dedicado apenas aos livros
	public Livro(String titulo, String autor, int registro, String editora, int edicao, String categoria,int copias,  int disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.registro = registro;
		this.editora = editora;
		this.edicao = edicao;
		this.categoria = categoria;
		this.copias = copias;
		this.disponivel = disponivel;
	}
	
	//setters
	public void setttitulo(String titulo){
	    this.titulo=titulo;
	}
	public void setautor(String autor){
	    this.autor = autor;
	}
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void seteditora(String editora){
	    this.editora = editora;
	}
	public void setedicao(int edicao){
	    	this.edicao = edicao;
	}
	public void setcategoria(String categoria){
	    this.categoria = categoria;
	}
	public void setcopias(int copias){
	    this.copias = copias;
	}
	public void setdisponivel(int disponivel){
	    this.disponivel = disponivel;
	}

    //getters 
	public String gettitulo() {
		return titulo;
	}
	public String getautor() {
		return autor;
	}
	public int getregistro() {
		return registro;
	}
	public String geteditora() {
		return editora;
	}
	public int getedicao() {
		return edicao;
	}
	public String getcategoria() {
		return categoria;
	}
	public int getcopias(){
	    return copias;
	}
	public int getdisponivel() {
		return disponivel;
	}
}

/* classe dedicada apenas aos usuarios */
class Usuario {
	public String nome;
	private int cpf;
	private int registro;
	private int emprestimo; // quantos livros o usuario tem emprestado
    private Livro[] livros_empres;// vetor que guarda os livros emprestados pelo usuário
	private String prazo; // prazo de devolucao
	private int atraso; // o numero de atraso em dias
	private int idade; // idade do usuario
	private String endereco;

// construtor dedicado apenas aos usuarios
	public Usuario(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.emprestimo = emprestimo;
		this.prazo = prazo;
		this.atraso = atraso;
		this.idade = idade;
		this.endereco = endereco;
		this.livros_empres = new Livro[5];
	}
	
	//setters
	public void setnome(String nome){
	    this.nome = nome;
	}
	public void setcpf(int cpf){
	    this.cpf = cpf;
	}
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void setemprestimo(int emprestimo){
	    this.emprestimo = emprestimo;
	}
	public void setprazo(String prazo){
	    	this.prazo = prazo;
	}
	public void setatraso(int atraso){
	    this.atraso = atraso;
	}
	public void setidade(int idade){
	    this.idade = idade;
	}
	public void setendereco(String endereco){
	    this.endereco = endereco;
	}
	
	//metodo para emprestar livros a um usuario(pode ser considerado um setter?)
	public void emprestarLivro(Livro livro) {
    for (int i = 0; i < 5; i++) {
        if (livros_empres[i] == null) {
            livros_empres[i] = livro;
            return;
        }
    }
    System.out.println("O usuário " + nome +" atingiu o limite de empréstimos.");
    }
	
	// método para mostrar quais livros a pessoa emprestou
	public void livrosEmprestados() {
        System.out.println("Livros emprestados para o usuário " + nome + ":");
        for (Livro livro : livros_empres) {
            if (livro != null) {
                System.out.println("- " + livro.gettitulo());
            }
        }
    }

    //getters para imprimir as informacoes
	public String getnome() {
		return nome;
	}
	public int getcpf() {
		return cpf;
	}
	public int getregistro() {
		return registro;
	}
	public int getemprestimo() {
		return emprestimo;
	}
	public String getprazo() {
		return prazo;
	}
	public int getatraso() {
		return atraso;
	}
	public int getidade() {
		return idade;
	}
	public String getendereco() {
		return endereco;
	}
}

//classe dedicada apenas aos funcionarios
class Funcionario {
	public String nome;
	private int cpf;
	private int registro;
	private String horario; // horário de entrada e de saída do funcionário
	private String cargo; // cargo do Funcionarios
	private int salario;
	private int idade; // idade do funcionario
	private String endereco;

	// construtor dedicado apenas aos funcionários
	public Funcionario(String nome, int cpf, int registro, String horario, String cargo, int salario, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.horario = horario;
		this.cargo = cargo;
		this.salario = salario;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//setters
	public void setnome(String nome){
	    this.nome = nome;
	}
	public void setcpf(int cpf){
	    this.cpf = cpf;
	}
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void sethorario(String horario){
	    this.horario = horario;
	}
	public void setcargo(String cargo){
	    this.cargo = cargo;
	}
	public void setsalario(int salario){
	    this.salario = salario;
	}
	public void setidade(int idade){
	    this.idade = idade;
	}
	public void setendereco(String endereco){
	    this.endereco = endereco;
	}

//getters para imprimir as informacoes
	public String getnome() {
		return nome;
	}
	public int getcpf() {
		return cpf;
	}
	public int getregistro() {
		return registro;
	}
	public String gethorario() {
		return horario;
	}
	public String getcargo() {
		return cargo;
	}
	public int getsalario() {
		return salario;
	}
	public int getidade() {
		return idade;
	}
	public String getendereco() {
		return endereco;
	}
}

//classe dedicada apenas CDs e DVDs
class Cd {
	private String tipo; // se é CD ou DVD
	private int registro;
	public String nome; // nome do CD ou DVD
	public String autor; // diretor do filme ou compositor/cantor/banda do cd
	private int ano; // ano de publicação
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade do cd para empréstimo

	// construtor dedicado apenas aos CDs e DVDs
	public Cd(String tipo, int registro, String nome, String autor, int ano, boolean disponivel) {
		this.tipo = tipo;
		this.registro = registro;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		this.disponivel = disponivel;
	}
	
    //setters
	public void setnome(String nome){
	    this.nome = nome;
	}
	
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void setautor(String autor){
	    this.autor = autor;
	}
	
	public void setano(int ano){
	    this.ano = ano;
	}
	public void setdisponivel(boolean disponivel){
	    this.disponivel = disponivel;
	}
	
    //getters para imprimir as informacoes
	public String getnome() {
		return nome;
	}
	public String gettipo() {
		return tipo;
	}
	public int getregistro() {
		return registro;
	}
	public String getautor() {
		return autor;
	}
	public int getano() {
		return ano;
	}
	public boolean getdisponivel() {
		return disponivel;
	}
}

//classe dedicada apenas a computadores
class Computador {
	public String local; // onde está o computador(andar, seção)
	private int registro;
	private String login; // nome dde usuário
	private String senha; 
	private int tempo; // quanto tempo ele pode ser utilizado por pessoa
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade do computador para uso

	// construtor dedicado apenas aos Computadores
	public Computador(String local, int registro, String login, String senha, int tempo, boolean disponivel) {
		this.local = local;
		this.registro = registro;
		this.login = login;
		this.senha = senha;
		this.tempo = tempo;
		this.disponivel = disponivel;
	}
	
    //setters
	public void setlocal(String local){
	    this.local = local;
	}
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void setlogin(String login){
	   this.login = login;
	}
	public void setsenha(String senha){
	   this.senha = senha;
	}
	public void settempo(int tempo){
	    this.tempo = tempo;
	}
	public void setdisponivel(boolean disponivel){
	    this.disponivel = disponivel;
	}
	
    //getters para imprimir as informacoes
	public String getlocal() {
		return local;
	}
	public String getlogin() {
		return login;
	}
	public int getregistro() {
		return registro;
	}
	public String getsenha() {
		return senha;
	}
	public int gettempo() {
		return tempo;
	}
	public boolean getdisponivel() {
		return disponivel;
	}
}

//classe dedicada apenas a revistas
class Revista {
	public String categoria; // nicho da revista(esporte, maternidade, artesanato, automóveis)
	private int registro;
	public String nome; 
	private String editora; 
	private String edicao; //  publicação
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade

	// construtor dedicado apenas às revistas
	public Revista(String categoria, int registro, String nome, String editora, String edicao, boolean disponivel) {
		this.categoria = categoria;
		this.registro = registro;
		this.nome = nome;
		this.editora = editora;
		this.edicao = edicao;
		this.disponivel = disponivel;
	}
	
    //setters
	public void setnome(String nome){
	    this.nome = nome;
	}
	public void setcategoria(String categoria){
	    this.categoria = categoria;
	}
	
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void seteditora(String editora){
	    this.editora = editora;
	}
	
	public void setedicao(String edicao){
	    this.edicao = edicao;
	}
	public void setdisponivel(boolean disponivel){
	    this.disponivel = disponivel;
	}
	
    //getters para imprimir as informacoes
	public String getnome() {
		return nome;
	}
	
	public int getregistro() {
		return registro;
	}
	public String geteditora() {
		return editora;
	}
	public String getedicao() {
		return edicao;
	}
	public boolean getdisponivel() {
		return disponivel;
	}
	public String getcategoria() {
		return categoria;
	}
}

//classe dedicada apenas a artigos acadêmicos, dissertações, teses, etc
class Academico {
	public String titulo; 
	private int registro;
	public String autor; 
	private String instituicao; 
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade

	// construtor dedicado apenas aos acadêmicos
	public Academico(String titulo, int registro, String autor, String instituicao, boolean disponivel) {
		this.titulo = titulo;
		this.registro = registro;
		this.autor = autor;
		this.instituicao = instituicao;
		this.disponivel = disponivel;
	}
	
    //setters
	public void settitulo(String titulo){
	    this.titulo = titulo;
	}
	public void setregistro(int registro){
	    this.registro = registro;
	}
	public void setautor(String autor){
	    this.autor = autor;
	}
	
	public void setinstituicao(String instituicao){
	    this.instituicao = instituicao;
	}
	public void setdisponivel(boolean disponivel){
	    this.disponivel = disponivel;
	}
	
    //getters para imprimir as informacoes
	public String gettitulo() {
		return titulo;
	}
	public String getautor() {
		return autor;
	}
	public int getregistro() {
		return registro;
	}
	public String getinstituicao() {
		return instituicao;
	}
	public boolean getdisponivel() {
		return disponivel;
	}
}

//classe dedicada apenas a visitantes
class Visitante {
	private String endereco; 
	private int idade;
	public String nome; 
	private int cpf; 

	// construtor dedicado apenas aos visitantes
	public Visitante(String endereco, int idade, String nome, int cpf) {
		this.endereco = endereco;
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
	}
	
    //setters
	public void setnome(String nome){
	    this.nome = nome;
	}
	
	public void idade(int idade){
	    this.idade = idade;
	}
	public void setendereco(String endereco){
	    this.endereco = endereco;
	}
	
	public void setcpf(int cpf){
	    this.cpf = cpf;
	}
	
	
    //getters para imprimir as informacoes
	public String getnome() {
		return nome;
	}
	public int getidade() {
		return idade;
	}
	public int getcpf() {
		return cpf;
	}
	public String getendereco() {
		return endereco;
	}
	
}
public class Main {
	public static void main(String[] args) {
    //teste construtores    
		// criando os objetos exemplo de livros e imprimindo
		Livro livro1 = new Livro("Harry Potter", "JK Rowling", 1234, "Rocco", 1, "fantasia",3, 3);
		System.out.println("Informacoes do livro:\n");
		System.out.println(
				livro1.gettitulo() + "; " + livro1.getautor() + "; " + livro1.getregistro() + "; " + livro1.geteditora()
						+ "; " + livro1.getedicao() + "; " + livro1.getcategoria() + "; "+ livro1.getcopias() + "; " + livro1.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de usuários e imprimindo */
		Usuario pessoa = new Usuario("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
		System.out.println("Informacoes do usuario:\n");
		System.out.println(pessoa.getnome() + "; " + pessoa.getcpf() + "; " + pessoa.getregistro() + "; "
				+ pessoa.getemprestimo() + "; " + pessoa.getprazo() + "; " + pessoa.getatraso() + "; "
				+ pessoa.getidade() + "; " + pessoa.getendereco());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de funcionarios e imprimindo */
		Funcionario trabalhador1 = new Funcionario("Karl", 895456789, 7898, "7h30 as 17h15", "Bibliotecario", 3000,
				27, "Avenida Marechal Rondon, 13");
		System.out.println("Informacoes do funcionario:\n");
		System.out.println(trabalhador1.getnome() + "; " + trabalhador1.getcpf() + "; " + trabalhador1.getregistro()
				+ "; " + trabalhador1.gethorario() + "; " + trabalhador1.getcargo() + "; " + trabalhador1.getsalario()
				+ "; " + trabalhador1.getidade() + "; " + trabalhador1.getendereco());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de CDs/DVDs e imprimindo */
		Cd dvd1 = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010, true);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(dvd1.getnome() + "; " + dvd1.gettipo() + "; " + dvd1.getregistro() + "; " + dvd1.getautor()
				+ "; " + dvd1.getano() + "; " + dvd1.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");
		
			/* criando os objetos exemplo de Computadores */
		Computador comp1 = new Computador("3AA", 9988, "biblioteca01", "comp9988", 1, true);
		System.out.println("Informacoes do Computador:\n");
		System.out.println(comp1.getlocal() + "; " + comp1.getregistro() + "; " + comp1.getlogin() + "; " + comp1.getsenha()
				+ "; " + comp1.gettempo() + "; " + comp1.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");
		
			/* criando os objetos exemplo de revistas */
		Revista revista1 = new Revista("automotivo", 5006, "Auto Esporte", "Globo", "janeiro de 2023", true);
		System.out.println("Informacoes da Revista:\n");
		System.out.println(revista1.getnome() + "; " + revista1.getcategoria() + "; " + revista1.getregistro() + "; " + revista1.geteditora()
				+ "; " + revista1.getedicao() + "; " + revista1.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");
		
			/* criando os objetos exemplo de Acadêmicos */
		Academico acad = new Academico("Ginástica Laboral: Um meio para a Promoção da Qualidade de Vida", 5336, "Poliana Carvalho", "universidade Estadual de Campinas", true);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(acad.gettitulo() + "; " + acad.getautor() + "; " + acad.getregistro() + "; " + acad.getinstituicao()+ "; "  + acad.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");
		
			/* criando os objetos exemplo de visitantes */
		Visitante vis1 = new Visitante("Av Bruxelas, 1", 22, "Marcos", 555889994);
		System.out.println("Informacoes do Visitante:\n");
		System.out.println(vis1.getnome() + "; " + vis1.getidade() + "; " + vis1.getendereco() + "; " + vis1.getcpf());
		System.out.println("\n");
		System.out.println("\n");
				
	// teste dos setters
	livro1.setdisponivel(1);
	System.out.println("Atualização de disponibilidade do livro:\n");
		System.out.println(
				livro1.gettitulo() + "; " + livro1.getautor() + "; " + livro1.getregistro() + "; " + livro1.geteditora()
						+ "; " + livro1.getedicao() + "; " + livro1.getcategoria() + "; "+ livro1.getcopias() + "; " + livro1.getdisponivel());
		System.out.println("\n");
	pessoa.setidade(26);
	System.out.println("Atualização de idade do usuario:\n");
	System.out.println(pessoa.getnome() + "; " + pessoa.getcpf() + "; " + pessoa.getregistro() + "; "+ pessoa.getemprestimo() + "; " + pessoa.getprazo() + "; " + pessoa.getatraso() + "; "
				+ pessoa.getidade() + "; " + pessoa.getendereco());
				System.out.println("\n");
	
	
	// empréstimo de livros ao usuário
	
	pessoa.emprestarLivro(livro1);
	pessoa.livrosEmprestados();
	
	
	}
}
