package biblioteca.models.multimidiaPackage;

import java.util.Map;
import java.util.HashMap;
import biblioteca.models.comentariosPackage.Comentarios; 

/*classe principal "Multimidia" que ira conter subclasses - Abstrata, pois só há intanciação da suas subclasses*/
abstract public class Multimidia {

    public enum Categoria {
        POESIA, ROMANCE, ACAO, FICCAO, FANTASIA, HISTORIA, ARTE, ACADEMICO, TECNOLOGIA, LINGUAGENS,
        BIOGRAFIA, SUSPENSE, FISICA_AFINS, CALCULO_AFINS, SOCIOLOGIA, ECONOMIA, FILOSOFIA, BIOLOGIA,
        JORNALISTICO, INFORMATIVO, REVISTA, TTERROR, INFANTIL, LEGISLACAO, DIVERSOS
    }
    private String titulo; // título
    private int id; // número de registro do livro para biblioteca
    private String autor; // autor ou artista do item do acervo
    private String editora; // editora ou gravadora do item
    private int anoPublicacao; // o ano referente a publicação da obra
    private String sinopse; // resumo conciso e breve do objeto em questão
    private String capa; // no futuro uma classe será implementada no lugar desse atibuto
    private String historicoEmprestimo; // a ideia desse atributo é implementar algo para conter o historico de
                                        // emprestimo objeto multimidia do acervo
    public boolean disponibilidade; // true se a cópia em questão está disponível, false se não está
    private int numCopias; // número de cópias que tem esse item
    public static int numCopiasDisponiveis; // número de copias (ou licensas) desse titulo que estão disponiveis
    private Map<Integer, Multimidia> mapMultimidia;
    private List<Comentarios> comentarios; // comentários de usuários a respeito da obra
    private Categoria categoria;// ação, fantasia, romance, biografia, etc
    private Set<Categoria> categoriasDisponiveis;

    public Multimidia(String titulo, int id, String autor, String editora, int anoPublicacao, String sinopse,
            String capa, String historicoEmprestimo, boolean disponibilidade, int numCopias, int numCopiasDisponiveis, Categoria categoria) {
        this.titulo = titulo;
        this.id = id;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.sinopse = sinopse;
        this.capa = capa;
        this.historicoEmprestimo = historicoEmprestimo;
        this.disponibilidade = disponibilidade;
        this.numCopias = numCopias;
        Multimidia.numCopiasDisponiveis = numCopiasDisponiveis;
        this.mapMultimidia = new HashMap<>(); 
        this.comentarios = new ArrayList<>();
        this.categoria = categoria;
        inicializarCategoriasDisponiveis(); 
    }

     private void inicializarCategoriasDisponiveis() {
        for (Categoria categoria : Categoria.values()) {
            categoriasDisponiveis.add(categoria);
        }
    }

    public String gettitulo() {
        return titulo;
    }

    public int getid() {
        return id;
    }

    public String getautor() {
        return autor;
    }

      public String getcategoria() {
        return categoria;
    }

    public String geteditora() {
        return editora;
    }

    public int getanoPublicacao() {
        return anoPublicacao;
    }

    public String getsinopse() {
        return sinopse;
    }

    public String getcapa() {
        return capa;
    }

    public String gethistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    public int getnumCopias() {
        return numCopias;
    }

    public static int getnumCopiasDisponiveis() {
        return numCopiasDisponiveis;
    }

     public void addcomentario(Comentario comentario) {
        listaPessoas.add(comentario);
    }

    public Categoria getcategoria() {
        return categoria;
    }
}
