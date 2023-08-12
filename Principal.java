/* - Classes primárias definidas para a bibliotéca no primeiro laboratório: Livros, CDs e DVDs, Usuários, Funcionários
   - Os objetos criados são apenas exemplos de aplicação, onde há um exemplo de livro da bibliotéca, um exemplo de CD ou DVD 
  que também pertence a biblióteca, um exemplo de usuário que pode fazer a retirada de um livro ou CD/DVD e um exemplo de 
  funcionário que trabalha na bibliotéca.
*/

package begin;

/*classe dedicada apenas aos livros*/
class Livro {
	private String titulo;
	private String autor;
	private int registro; // registro do livro para a bibliotéca
	private String editora;
	private int edicao;
	private String categoria; // biografia, fantasia, infantil, etc
	private boolean disponivel; // verdadeiro ou falso para a disponibilidade do livro

	// construtor dedicado apenas aos livros
	Livro(String titulo, String autor, int registro, String editora, int edicao, String categoria, boolean disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.registro = registro;
		this.editora = editora;
		this.edicao = edicao;
		this.categoria = categoria;
		this.disponivel = disponivel;
	}

	// imprimir informacoes
	void Informacoes() {
		System.out.println("Titulo: " + titulo + "\n");
		System.out.println("Autor: " + autor + "\n");
		System.out.println("Registro: " + registro + "\n");
		System.out.println("Editora: " + editora + "\n");
		System.out.println("Edicao: " + edicao + "\n");
		System.out.println("Categoria: " + categoria + "\n");
		System.out.println("Disponivel: " + disponivel + "\n");
	}
}

/* classe dedicada apenas aos usuarios */
class Usuarios {
	private String nome;
	private int cpf;
	private int registro;
	private int emprestimo; // quantos livros o usuario tem emprestado

	// bloco de programa que pode ser usado no futuro como um vetor de strings
	// contendo o nome dos livros que o usuario tem emprestado
	// String[] nomes = new String[5];
	// nomes[0] = "Alice";

	private String prazo; // prazo de devolucao
	private int atraso; // o numero de atraso em dias
	private int idade; // idade do usuario
	private String endereco;

// construtor dedicado apenas aos livros
	Usuarios(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.emprestimo = emprestimo;
		this.prazo = prazo;
		this.atraso = atraso;
		this.idade = idade;
		this.endereco = endereco;
		// this.livros_empres = livros_empres;
	}

//imprimir informacoes
	void Informacoes() {
		System.out.println("Nome: " + nome + "\n");
		System.out.println("CPF: " + cpf + "\n");
		System.out.println("Registro: " + registro + "\n");
		System.out.println("Emprestimo: " + emprestimo + "\n");
		System.out.println("Prazo: " + prazo + "\n");
		System.out.println("Atraso: " + atraso + "\n");
		System.out.println("Idade: " + idade + "\n");
		System.out.println("Endereco: " + endereco + "\n");
		// System.out.println("Livros Emprestados: " + livros_empres + "\n");
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
	Funcionarios(String nome, int cpf, int registro, String horario, String cargo, int salario, int idade,
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

	// imprimir informacoes
	void Informacoes() {
		System.out.println("Nome: " + nome + "\n");
		System.out.println("CPF: " + cpf + "\n");
		System.out.println("Registro: " + registro + "\n");
		System.out.println("Horario: " + horario + "\n");
		System.out.println("Cargo: " + cargo + "\n");
		System.out.println("Salario: " + salario + "\n");
		System.out.println("Idade: " + idade + "\n");
		System.out.println("Endereco: " + endereco + "\n");
	}
}

//classe dedicada apenas CDs e DVDs
class Cd {
	private String tipo; // se é CD ou DVD
	private int registro;
	private String nome; // nome do CD ou DVD
	private String autor; // "autor" do CD ou DVD
	private int ano;

	// construtor dedicado apenas aos CDs e DVDs
	Cd(String tipo, int registro, String nome, String autor, int ano) {
		this.tipo = tipo;
		this.registro = registro;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
	}

	// imprimir informacoes
	void Informacoes() {
		System.out.println("Nome: " + nome + "\n");
		System.out.println("Tipo: " + tipo + "\n");
		System.out.println("Registro: " + registro + "\n");
		System.out.println("Autor: " + autor + "\n");
		System.out.println("Ano: " + ano + "\n");
	}
}

public class Principal {
	public static void main(String[] args) {
		/* criando o objeto exemplo de livro e imprimindo */
		Livro livro1 = new Livro("Harry Potter", "JK Rowling", 1234, "Rocco", 1, "fantasia", true);
		System.out.println("Informacoes do livro:\n");
		livro1.Informacoes();
		/* criando o objeto exemplo de usuário e imprimindo */
		Usuarios pessoa = new Usuarios("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
		System.out.println("Informacoes do usuario:\n");
		pessoa.Informacoes();
		/* criando o objeto exemplo de funcionarios e imprimindo */
        Funcionarios trabalhador = new Funcionarios("Karl", 895456789, 7898, "7h30 às 17h15", "Bibliotecario", 2000, 27, "Avenida Marechal Rondon, 13");
        System.out.println("Informacoes do funcionario:\n");
        trabalhador.Informacoes();
        /* criando o objeto exemplo de CDs/DVDs e imprimindo */
        Cd dvd = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010);
        System.out.println("Informacoes do CD ou DVD:\n");
        dvd.Informacoes();
	}
}
