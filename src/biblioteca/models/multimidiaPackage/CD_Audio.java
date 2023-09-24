package biblioteca.models.multimidiaPackage;

import java.time.Duration;

public class CD_Audio extends Multimidia {
    private String listaFaixas;
    private Duration duracao; // Atributo para armazenar a duração do CD de áudio
    private String estadoConservacao;

    public CD_Audio(String titulo,  String autor, String editora, int anoPublicacao,
            String sinopse, String capa, boolean disponibilidade, int numCopias, int numCopiasDisponiveis,
            String listaFaixas, Duration duracao, String estadoConservacao, Categoria categoria) {
        super(titulo,  autor, editora, anoPublicacao, sinopse, capa, disponibilidade, numCopias, numCopiasDisponiveis, categoria);
        this.listaFaixas = listaFaixas;
        this.duracao = duracao;
        this.estadoConservacao = estadoConservacao;
    }

    public String getlistaFaixas() {
        return listaFaixas;
    }

    public void setlistaFaixas(String listafaixas){
        this.listaFaixas = listaFaixas;
    }

  
    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
    
    public String getestadoConservacao() {
        return estadoConservacao;
    }

    public void setestadoConservacao(String estadoConservacao){
        this.estadoConservacao = estadoConservacao;
    }
}
