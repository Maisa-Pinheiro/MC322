package biblioteca.models.multimidiaPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class LivroEletronico extends Multimidia {
    private String formato; // PDF, ePub, etc.
    private URL url; // Campo para armazenar a URL
    private String requisitosLeitura; // quais são os requisitos para leitura desse livro (SW e compatibilidade)
    private LocalDate dataDisponibilidade; // Atributo para armazenar a data de disponibilidade

    public LivroEletronico(String titulo,  String autor, String editora, int anoPublicacao,
            String sinopse, String capa, boolean disponibilidade, int numCopias,
            int numCopiasDisponiveis, String formato, String urlstring, String requisitosLeitura,
            LocalDate dataDisponibilidade, Categoria categoria) {
        super(titulo,  autor, editora, anoPublicacao, sinopse, capa, disponibilidade,
                numCopias, numCopiasDisponiveis, categoria);
        this.formato = formato;
        try {
            this.url = new URL(urlstring);
            this.requisitosLeitura = requisitosLeitura;
            this.dataDisponibilidade = dataDisponibilidade;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("URL inválida: " + e.getMessage());
        }
    }

    // Métodos getters e setters 
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getformato() {
        return formato;
    }

    public void setformato(String formato){
        this.formato = formato;
    }

    public String getrequisitosLeitura() {
        return requisitosLeitura;
    }

    public void setrequisitosLeitura(String requisitosLeitura){
        this.requisitosLeitura = requisitosLeitura;
    }

    public LocalDate getDataDisponibilidade() {
        return dataDisponibilidade;
    }

    public void setDataDisponibilidade(LocalDate dataDisponibilidade) {
        this.dataDisponibilidade = dataDisponibilidade;
    }
}
