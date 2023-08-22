package classesObras;
/*teste fernanda*/

/*classe dedicada apenas a artigos acadêmicos, dissertações, teses, etc*/
public class Academico {
	public String titulo;
	private int registro;
	public String autor;
	private String instituicao;
	public boolean disponivel; // verdadeiro ou falso para a disponibilidade

	/* construtor dedicado apenas aos acadêmicos */
	public Academico(String titulo, int registro, String autor, String instituicao, boolean disponivel) {
		this.titulo = titulo;
		this.registro = registro;
		this.autor = autor;
		this.instituicao = instituicao;
		this.disponivel = disponivel;
	}

	/*
	 * A classe não possui setters pois os atributos privados não devem ser mudados
	 */

	/* getters para atributos privados */
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
}
