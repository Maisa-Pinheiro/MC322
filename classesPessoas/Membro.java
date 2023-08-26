/*pacote que contem apenas as classes de pessoas: aluno, porfessor e funcionario */

package classesPessoas;

import classesObras.Multimidia;

/*
 * classe dedicada apenas aos membros, considerando que tanto alunos e professores como funcionários podem
 * emprestar livrod, os atributos publicos são os que mudam
 * com frequência e podem ser acessados por outras classes sem necessidade de
 * getters e setters
 */
public class Membros {
	private String nome;
	private int cpf;
	private int registro;
	public int emprestimo; // quantos livros o usuario tem emprestado
	private String categoria; // aluno grad, aluno pos, funcionário(especificar cargo) ou professor
	public Multimidia[] itens_empres;// vetor que guarda os itens emprestados pelo usuário
	public String prazo; // prazo de devolucao
	public int atraso; // o numero de atraso em dias
	public int idade; // idade do usuario
	private String endereco; 
	private int salario;// para funcionário da biblioteca, aluno e professor, "não se aplica"

	/* construtor dedicado apenas aos usuarios */
	public Usuario(String nome, int cpf, int registro, int emprestimo, String categoria, String prazo, int atraso, int idade,
			String endereco, int salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.emprestimo = emprestimo;
		this.categoria = categoria;
		this.prazo = prazo;
		this.atraso = atraso;
		this.idade = idade;
		this.endereco = endereco;
		this.livros_empres = new Livro[5];
		this.salario =salario;
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
	public String getcategoria() {
		return categoria;
	}
	public String getsalario() {
		return salario;
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
	public void setsalario(String salario) {
		this.salario = salario;
	}

	/*
	 * implementação de um metodo para emprestar livros a um usuario(pode ser
	 * considerado um setter?)
	 */
	public void emprestarItem(Multimidia livro) {
		for (int i = 0; i < 5; i++) {
			if (itens_empres[i] == null) {
				itens_empres[i] = livro;
				return;
			}
		}
		System.out.println("O usuário " + nome + " atingiu o limite de empréstimos.");
	}

	/* método para mostrar quais livros a pessoa emprestou */
	public void ItensEmprestados() {
		System.out.println("Itens emprestados para o usuário " + nome + ":");
		for (Multimidia livro : itens_empres) {
			if (livro != null) {
				System.out.println("- " + livro.gettitulo());
			}
		}
	}
	public void qtsItens() {
	    int a=0;
		for (int i = 0; i < 5; i++) {
			if (itens_empres[i] != null) {
				a= a + 1;
			}
			
		}
		System.out.println("O usuário " + nome + " emprestou " + a + " itens.");
	}
}
