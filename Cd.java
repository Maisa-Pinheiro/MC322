package classesObras;

/*classe dedicada apenas CDs e DVDs*/
public class Cd {
	private String tipo; // se é CD ou DVD
	private int registro;
	public String nome; // nome do CD ou DVD
	public String autor; // diretor do filme ou compositor/cantor/banda do cd
	private int ano; // ano de publicação
	public boolean disponivel; // verdadeiro ou falso para a disponibilidade do cd para empréstimo

	/* construtor dedicado apenas aos CDs e DVDs */
	public Cd(String tipo, int registro, String nome, String autor, int ano, boolean disponivel) {
		this.tipo = tipo;
		this.registro = registro;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		this.disponivel = disponivel;
	}

	/*
	 * A classe não possui setters por que os atributos privados não serão
	 * mudados(se mudassem não seria mais o mesmo livro), os unicos atributos que
	 * podem ser alterados já estão publicos
	 */

	/* getters para os atributos privados */
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
}