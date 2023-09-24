package biblioteca.models.multimidiaPackage;

import java.time.Duration;

public class DVD_Video extends Multimidia {
    private String elenco;
    private Duration duracao;
    private String legendasAudio; // Legendas e Áudio Disponíveis
    private String estadoConservacao;

    public DVD_Video(String titulo,  String autor, String editora, int anoPublicacao,
            String sinopse, String capa,  boolean disponibilidade, int numCopias,
            int numCopiasDisponiveis,
            String elenco, Duration duracao, String legendasAudio, String estadoConservacao, Categoria categoria) {
        super(titulo,  autor, editora, anoPublicacao, sinopse, capa, disponibilidade,
                numCopias, numCopiasDisponiveis, categoria);
        this.elenco = elenco;
        this.duracao = duracao;
        this.legendasAudio = legendasAudio;
        this.estadoConservacao = estadoConservacao;
    }

    public String getelenco() {
        return elenco;
    }
    public void setelenco(String elenco){
        this.elenco = elenco;
    }

    
    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public String getlegendasAudio() {
        return legendasAudio;
    }

    public void setlegendasAudio(String legendasAudio){
        this.legendasAudio = legendasAudio;
    }

    public String getestadoConservacao() {
        return estadoConservacao;
    }

    public void setestadoConservacao(String estadoConservacao){
        this.estadoConservacao = estadoConservacao;
    }
}
