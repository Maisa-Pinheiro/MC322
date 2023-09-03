package multimidiaPackage;

public class Outros extends Multimidia {
    private String tipo;
    private String formato;
    private int numCopias;
    private int numCopiasDisponiveis;
    private String local; // se for tipo fisico qual sua localização da biblioteca
    private String estadoConservacao;

    public Outros(String titulo, int registro, String autor, String editora, int anoPublicacao,
            String sinopse, String capa, String historicoEmprestimo, boolean disponibilidade,
            String tipo, String formato, int numCopias, int numCopiasDisponiveis, String local,
            String estadoConservacao) {
        super(titulo, registro, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade);
        this.tipo = tipo;
        this.formato = formato;
        this.numCopias = numCopias;
        this.numCopiasDisponiveis = numCopiasDisponiveis;
        this.local = local;
        this.estadoConservacao = estadoConservacao;
    }

    public String gettipo() {
        return tipo;
    }

    public String getformato() {
        return formato;
    }

    public int getnumCopias() {
        return numCopias;
    }

    public int getnumCopiasDisponiveis() {
        return numCopiasDisponiveis;
    }

    public String getlocal() {
        return local;
    }

    public String getestadoConservacao() {
        return estadoConservacao;
    }
}
