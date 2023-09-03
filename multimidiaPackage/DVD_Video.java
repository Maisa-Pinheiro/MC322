package multimidiaPackage;

import java.time.Duration;

public class DVD_Video extends Multimidia {
    private String elenco;
    private Duration duracao;
    private int numCopias;
    private int numCopiasDisponiveis;
    private String legendasAudio; // Legendas e Áudio Disponíveis
    private String estadoConservacao;

    public DVD_Video(String titulo, int registro, String autor, String editora, int anoPublicacao,
                     String sinopse, String capa, String historicoEmprestimo, boolean disponibilidade,
                     String elenco, Duration duracao, int numCopias, int numCopiasDisponiveis,
                     String legendasAudio, String estadoConservacao) {
        super(titulo, registro, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade);
        this.elenco = elenco;
        this.duracao = duracao;
        this.numCopias = numCopias;
        this.numCopiasDisponiveis = numCopiasDisponiveis;
        this.legendasAudio = legendasAudio;
        this.estadoConservacao = estadoConservacao;
    }

    public String getelenco() {
        return elenco;
    }

    // Métodos getters e setters para a duração
    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public int getnumCopias() {
        return numCopias;
    }

    public int getnumCopiasDisponiveis() {
        return numCopiasDisponiveis;
    }

    public String getlegendasAudio() {
        return legendasAudio;
    }

    public String getestadoConservacao() {
        return estadoConservacao;
    }
}








