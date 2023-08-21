/*pacote que contem apenas as classes de pessoas: usuário, funcionario e visitante*/

package classesPessoas;

import classesObras.Livro;

/*
 * classe dedicada apenas aos usuarios, os atributos publicos são os que mudam
 * com frequência e podem ser acessados por outras classes sem necessidade de
 * getters e setters
 */
public class Usuario {
	private String nome;
	private int cpf;
	private int registro;
	public int emprestimo; // quantos livros o usuario tem emprestado
	public Livro[] livros_empres;// vetor que guarda os livros emprestados pelo usuário
	public String prazo; // prazo de devolucao
	public int atraso; // o numero de atraso em dias
	public int idade; // idade do usuario
	private String endereco;

	/* construtor dedicado apenas aos usuarios */
	public Usuario(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade,
			String endereco) {
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

	/* getters para os atributos privados */
	public String getnome() {
		return nome;
	}

	public int getcpf() {
		return cpf;
	}

	public int getregistro() {
		return registro;
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

	public void setcpf(int cpf) {
		this.cpf = cpf;
	}

	public void setendereco(String endereco) {
		this.endereco = endereco;
	}

	/*
	 * implementação de um metodo para emprestar livros a um usuario(pode ser
	 * considerado um setter?)
	 */
	public void emprestarLivro(Livro livro) {
		for (int i = 0; i < 5; i++) {
			if (livros_empres[i] == null) {
				livros_empres[i] = livro;
				return;
			}
		}
		System.out.println("O usuário " + nome + " atingiu o limite de empréstimos.");
	}

	/* método para mostrar quais livros a pessoa emprestou */
	public void livrosEmprestados() {
		System.out.println("Livros emprestados para o usuário " + nome + ":");
		for (Livro livro : livros_empres) {
			if (livro != null) {
				System.out.println("- " + livro.gettitulo());
			}
		}
	}
	public void qtsLivros() {
	    int a=0;
		for (int i = 0; i < 5; i++) {
			if (livros_empres[i] != null) {
				a= a + 1;
			}
			
		}
		System.out.println("O usuário " + nome + " emprestou " + a + " livros.");
	}
}
