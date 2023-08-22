package classesPessoas;

/*classe dedicada apenas a visitantes - o visitante não pode fazer emprestimo de livros*/
public class Visitante {
	private String endereco;
	private int idade;
	private String nome;
	private int cpf;

	/* construtor dedicado apenas aos visitantes */
	public Visitante(String endereco, int idade, String nome, int cpf) {
		this.endereco = endereco;
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
	}

	/*
	 * A classe não tem setters pois os atributos privados não mudam(se um visitante
	 * voltar, ele se torna usuário)
	 */

	/* getters para os atributos privados */
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