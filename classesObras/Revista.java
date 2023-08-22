package classesObras;

/*classe dedicada apenas a revistas*/
public class Revista {
	public String categoria; // nicho da revista(esporte, maternidade, artesanato, automóveis)
	private int registro;
	public String nome;
	private String editora;
	private String edicao; // publicação
	public boolean disponivel; // verdadeiro ou falso para a disponibilidade

	/* construtor dedicado apenas às revistas */
	public Revista(String categoria, int registro, String nome, String editora, String edicao, boolean disponivel) {
		this.categoria = categoria;
		this.registro = registro;
		this.nome = nome;
		this.editora = editora;
		this.edicao = edicao;
		this.disponivel = disponivel;
	}

	/* A classe não possui setters pois os atributos privados não devem mudar */

	/* getters para os atributos privados */
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

	public String getcategoria() {
		return categoria;
	}
}