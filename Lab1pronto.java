/* - Classes primárias definidas para a bibliotéca no primeiro laboratório: Livros, CDs e DVDs, Usuários, Funcionários
   - Os objetos criados são apenas exemplos de aplicação, onde há um exemplo de livro da bibliotéca, um exemplo de CD ou DVD 
  que também pertence a biblióteca, um exemplo de usuário que pode fazer a retirada de um livro ou CD/DVD e um exemplo de 
  funcionário que trabalha na bibliotéca.
*/

/*classe dedicada apenas aos livros*/
class Livro {
	private String titulo;
	private String autor;
	private int registro; // registro do livro para a bibliotéca
	private String editora;
	private int edicao;
	private String categoria; // biografia, fantasia, infantil, etc
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade do livro para empréstimo

	// construtor dedicado apenas aos livros
	public Livro(String titulo, String autor, int registro, String editora, int edicao, String categoria,
			boolean disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.registro = registro;
		this.editora = editora;
		this.edicao = edicao;
		this.categoria = categoria;
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

	public String geteditora() {
		return editora;
	}

	public int getedicao() {
		return edicao;
	}

	public String getcategoria() {
		return categoria;
	}

	public boolean getdisponivel() {
		return disponivel;
	}
}

/* classe dedicada apenas aos usuarios */
class Usuarios {
	private String nome;
	private int cpf;
	private int registro;
	private int emprestimo; // quantos livros o usuario tem emprestado

	// bloco de programa que pode ser usado no futuro como um vetor de strings
	// (nomes dos livros emprestados, o maximo de empréstimos é 5)
	// String[] emprestimos = new String[5];
	// emprestimos[0] = "Alice";

	private String prazo; // prazo de devolucao
	private int atraso; // o numero de atraso em dias
	private int idade; // idade do usuario
	private String endereco;

// construtor dedicado apenas aos usuarios
	public Usuarios(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade,
			String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.emprestimo = emprestimo;
		this.prazo = prazo;
		this.atraso = atraso;
		this.idade = idade;
		this.endereco = endereco;
		// this.emprestimos = livros_empres;
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
class Funcionarios {
	private String nome;
	private int cpf;
	private int registro;
	private String horario; // horário de entrada e de saída do funcionário
	private String cargo; // cargo do Funcionarios
	private int salario;
	private int idade; // idade do funcionario
	private String endereco;

	// construtor dedicado apenas aos livros
	public Funcionarios(String nome, int cpf, int registro, String horario, String cargo, int salario, int idade,
			String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.horario = horario;
		this.cargo = cargo;
		this.salario = salario;
		this.idade = idade;
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
	private String nome; // nome do CD ou DVD
	private String autor; // diretor do filme ou compositor/cantor/banda do cd
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

public class Lab1pronto {
	public static void main(String[] args) {

		// criando os objetos exemplo de livros e imprimindo
		Livro livro1 = new Livro("Harry Potter", "JK Rowling", 1234, "Rocco", 1, "fantasia", true);
		System.out.println("Informacoes do livro:\n");
		System.out.println(
				livro1.gettitulo() + "; " + livro1.getautor() + "; " + livro1.getregistro() + "; " + livro1.geteditora()
						+ "; " + livro1.getedicao() + "; " + livro1.getcategoria() + "; " + livro1.getdisponivel());
		System.out.println("\n");
		Livro livro2 = new Livro("Picos e vales", "Spencer Jhonson", 8654, "BS", 3, "autoajuda", false);
		System.out.println("Informacoes do livro:\n");
		System.out.println(
				livro2.gettitulo() + "; " + livro2.getautor() + "; " + livro2.getregistro() + "; " + livro2.geteditora()
						+ "; " + livro2.getedicao() + "; " + livro2.getcategoria() + "; " + livro2.getdisponivel());
		System.out.println("\n");
		Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1255, "FDT", 2, "fantasia", true);
		System.out.println("Informacoes do livro:\n");
		System.out.println(
				livro3.gettitulo() + "; " + livro3.getautor() + "; " + livro3.getregistro() + "; " + livro3.geteditora()
						+ "; " + livro3.getedicao() + "; " + livro3.getcategoria() + "; " + livro3.getdisponivel());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de usuários e imprimindo */
		Usuarios pessoa = new Usuarios("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
		System.out.println("Informacoes do usuario:\n");
		System.out.println(pessoa.getnome() + "; " + pessoa.getcpf() + "; " + pessoa.getregistro() + "; "
				+ pessoa.getemprestimo() + "; " + pessoa.getprazo() + "; " + pessoa.getatraso() + "; "
				+ pessoa.getidade() + "; " + pessoa.getendereco());
		System.out.println("\n");
		Usuarios pessoa2 = new Usuarios("João", 896556787, 6549, 0, "sem emprestimos", 0, 33, "Rua Rosa da Silva, 55");
		System.out.println("Informacoes do usuario:\n");
		System.out.println(pessoa2.getnome() + "; " + pessoa2.getcpf() + "; " + pessoa2.getregistro() + "; "
				+ pessoa2.getemprestimo() + "; " + pessoa2.getprazo() + "; " + pessoa2.getatraso() + "; "
				+ pessoa2.getidade() + "; " + pessoa2.getendereco());
		System.out.println("\n");
		Usuarios pessoa3 = new Usuarios("Bernardo", 999584506, 7893, 2, "22/03/2024", 5, 18, "Av Pascal, 606");
		System.out.println("Informacoes do usuario:\n");
		System.out.println(pessoa3.getnome() + "; " + pessoa3.getcpf() + "; " + pessoa3.getregistro() + "; "
				+ pessoa3.getemprestimo() + "; " + pessoa3.getprazo() + "; " + pessoa3.getatraso() + "; "
				+ pessoa3.getidade() + "; " + pessoa3.getendereco());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de funcionarios e imprimindo */
		Funcionarios trabalhador1 = new Funcionarios("Karl", 895456789, 7898, "7h30 as 17h15", "Bibliotecario", 3000,
				27, "Avenida Marechal Rondon, 13");
		System.out.println("Informacoes do funcionario:\n");
		System.out.println(trabalhador1.getnome() + "; " + trabalhador1.getcpf() + "; " + trabalhador1.getregistro()
				+ "; " + trabalhador1.gethorario() + "; " + trabalhador1.getcargo() + "; " + trabalhador1.getsalario()
				+ "; " + trabalhador1.getidade() + "; " + trabalhador1.getendereco());
		System.out.println("\n");
		Funcionarios trabalhador2 = new Funcionarios("Felicia", 987654321, 5823, "7h30 as 17h15", "Auxiliar de limpeza",
				2000, 27, "Avenida Faria lima, 500");
		System.out.println("Informacoes do funcionario:\n");
		System.out.println(trabalhador2.getnome() + "; " + trabalhador2.getcpf() + "; " + trabalhador2.getregistro()
				+ "; " + trabalhador2.gethorario() + "; " + trabalhador2.getcargo() + "; " + trabalhador2.getsalario()
				+ "; " + trabalhador2.getidade() + "; " + trabalhador2.getendereco());
		System.out.println("\n");
		Funcionarios trabalhador3 = new Funcionarios("Marco", 775456546, 4758, "7h30 as 14h15", "Estagiario", 1500, 27,
				"Rua Joaquim Silva, 43");
		System.out.println("Informacoes do funcionario:\n");
		System.out.println(trabalhador3.getnome() + "; " + trabalhador3.getcpf() + "; " + trabalhador3.getregistro()
				+ "; " + trabalhador3.gethorario() + "; " + trabalhador3.getcargo() + "; " + trabalhador3.getsalario()
				+ "; " + trabalhador3.getidade() + "; " + trabalhador3.getendereco());
		System.out.println("\n");
		System.out.println("\n");

		/* criando os objetos exemplo de CDs/DVDs e imprimindo */
		Cd dvd1 = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010, true);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(dvd1.getnome() + "; " + dvd1.gettipo() + "; " + dvd1.getregistro() + "; " + dvd1.getautor()
				+ "; " + dvd1.getano() + "; " + dvd1.getdisponivel());
		System.out.println("\n");
		Cd dvd2 = new Cd("DVD", 1455, "Barbie", "Greta Gerwig", 2023, false);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(dvd2.getnome() + "; " + dvd2.gettipo() + "; " + dvd2.getregistro() + "; " + dvd2.getautor()
				+ "; " + dvd2.getano() + "; " + dvd2.getdisponivel());
		System.out.println("\n");
		Cd dvd3 = new Cd("CD", 8888, "Fine Line", "Harry Styles", 2019, false);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(dvd3.getnome() + "; " + dvd3.gettipo() + "; " + dvd3.getregistro() + "; " + dvd3.getautor()
				+ "; " + dvd3.getano() + "; " + dvd3.getdisponivel());

	}
}
