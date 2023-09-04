package multimidiaPackage;

import java.time.Duration;

public class CD_Audio extends Multimidia {
    private String listaFaixas;
    private Duration duracao; // Atributo para armazenar a duração do CD de áudio
    private int numCopias;
    private String estadoConservacao;

    public CD_Audio(String titulo, int registro, String autor, String editora, int anoPublicacao,
            String sinopse, String capa, String historicoEmprestimo, boolean disponibilidade,
            String listaFaixas, Duration duracao, int numCopias, String estadoConservacao) {
        super(titulo, registro, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade,
                numCopiasDisponiveis);
        this.listaFaixas = listaFaixas;
        this.duracao = duracao;
        this.numCopias = numCopias;
        this.estadoConservacao = estadoConservacao;
    }

    public String getlistaFaixas() {
        return listaFaixas;
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

    public String getestadoConservacao() {
        return estadoConservacao;
    }
}