/*pacote que contem apenas as classes de obras (objetos de emprestimo no geral), como: Livros, CDs e DVDs, Revistas, Academicos*/

package classesObras;

/*classe dedicada apenas aos livros*/
public class Livro {
	private String titulo; // titulo da obra
	private String autor;
	private int registro; // registro do livro para a bibliotéca
	private String editora;
	private int edicao;
	private String categoria; // biografia, fantasia, infantil, etc
	public int copias;// quantas cópias do livro a biblioteca possui
	public int disponivel; // quantas cópias estão disponpiveis para empréstimo

	/* construtor */
	public Livro(String titulo, String autor, int registro, String editora, int edicao, String categoria, int copias,
			int disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.registro = registro;
		this.editora = editora;
		this.edicao = edicao;
		this.categoria = categoria;
		this.copias = copias;
		this.disponivel = disponivel;
	}

	/*
	 * A classe não possui setters por que os atributos privados não serão
	 * mudados(se mudassem não seria mais o mesmo livro), os unicos atributos que
	 * podem ser alterados já estão publicos
	 */

	/* getters para os atributos privados */
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
}