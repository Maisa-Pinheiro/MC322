package biblioteca.models.multimidiaPackage;

/*classe principal "Multimidia" que ira conter subclasses*/
public class Multimidia {
    private String titulo; // título
    private int registro; // número de registro do livro para biblioteca
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

    public Multimidia(String titulo, int registro, String autor, String editora, int anoPublicacao, String sinopse,
            String capa, String historicoEmprestimo, boolean disponibilidade, int numCopias, int numCopiasDisponiveis) {
        this.titulo = titulo;
        this.registro = registro;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.sinopse = sinopse;
        this.capa = capa;
        this.historicoEmprestimo = historicoEmprestimo;
        this.disponibilidade = disponibilidade;
        this.numCopias = numCopias;
        Multimidia.numCopiasDisponiveis = numCopiasDisponiveis;
    }

    public String gettitulo() {
        return titulo;
    }

    public int getregistro() {
        return registro;
    }

    public String getautor() {
        return autor;
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
}