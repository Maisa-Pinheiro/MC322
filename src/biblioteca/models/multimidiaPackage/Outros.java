package biblioteca.models.multimidiaPackage;

public class Outros extends Multimidia {
    private String tipo;
    private String formato;
    private String local; // se for tipo fisico qual sua localização da biblioteca
    private String estadoConservacao;

    public Outros(String titulo,  String autor, String editora, int anoPublicacao,
            String sinopse, String capa, boolean disponibilidade, int numCopias,
            int numCopiasDisponiveis, String tipo, String formato, String local,
            String estadoConservacao, Categoria categoria) {
        super(titulo, autor, editora, anoPublicacao, sinopse, capa, disponibilidade,
                numCopias, numCopiasDisponiveis, categoria);
        this.tipo = tipo;
        this.formato = formato;
        this.local = local;
        this.estadoConservacao = estadoConservacao;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo){
        this.tipo = tipo;
    }

    public String getformato() {
        return formato;
    }

    public void setformato(String formato){
        this.formato = formato;
    }

    public String getlocal() {
        return local;
    }

    public void setlocal(String local){
        this.local = local;
    }

    public String getestadoConservacao() {
        return estadoConservacao;
    }

    public void setestadoConservacao(String estadoConservacao){
        this.estadoConservacao = estadoConservacao;
    }
}
