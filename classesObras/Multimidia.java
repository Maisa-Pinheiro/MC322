/*pacote que contem apenas as classes de obras (objetos de emprestimo no geral), como: Livros, CDs e DVDs,*/

package classesObras;

/*classe dedicada apenas aos itens multimidia*/
public class Multimidia {
	private String titulo; // titulo da obra
	private String autor;// autor do livro/ cantor ou banda do cd/ diretor do filme(dvd)
	private int registro; // registro do item para a bibliotéca
	private String editora; // editora ou gravadora/estúdio
	private int ano;// ano de publicação do cd/dvd ou edição do livro
	private String categoria; // biografia, fantasia, infantil, rock, samba, etc
	public int copias;// quantas cópias do item a biblioteca possui, para digitais,1
	public int disponivel; // quantas cópias estão disponpiveis para empréstimo, para digitais "não se aplica"
	private String tipo; // livro fisico, livro digital, cd, dvd

	/* construtor */
	public Multimidia(String titulo, String autor, int registro, String editora, int ano, String categoria, int copias,
			int disponivel, String tipo) {
		this.titulo = titulo;
		this.autor = autor;
		this.registro = registro;
		this.editora = editora;
		this.ano = ano;
		this.categoria = categoria;
		this.copias = copias;
		this.disponivel = disponivel;
		this.tipo= tipo;
	}

	/*
	 * A classe não possui setters por que os atributos privados não serão
	 * mudados(se mudassem não seria mais o mesmo item), os unicos atributos que
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

	public int getano() {
		return ano;
	}

	public String getcategoria() {
		return categoria;
	}
	public String gettipo() {
		return tipo;
	}
}
