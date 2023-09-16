package biblioteca.models.multimidiaPackage;

import java.net.URL;
import java.time.LocalDate;

public class LivroEletronico extends Multimidia {
    private String formato; // PDF, ePub, etc.
    private URL url; // Campo para armazenar a URL
    private String requisitosLeitura; // quais são os requisitos para leitura desse livro (SW e compatibilidade)
    private LocalDate dataDisponibilidade; // Atributo para armazenar a data de disponibilidade

    public LivroEletronico(String titulo, int id, String autor, String editora, int anoPublicacao,
            String sinopse, String capa, String historicoEmprestimo, boolean disponibilidade, int numCopias,
            int numCopiasDisponiveis, String formato, URL url, String requisitosLeitura,
            LocalDate dataDisponibilidade) {
        super(titulo, id, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade,
                numCopias, numCopiasDisponiveis);
        this.formato = formato;
        this.url = url;
        this.requisitosLeitura = requisitosLeitura;
        this.dataDisponibilidade = dataDisponibilidade;
    }

    // Métodos getters e setters para a URL e data de disponibilidade
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getformato() {
        return formato;
    }

    public String getrequisitosLeitura() {
        return requisitosLeitura;
    }

    public LocalDate getDataDisponibilidade() {
        return dataDisponibilidade;
    }

    public void setDataDisponibilidade(LocalDate dataDisponibilidade) {
        this.dataDisponibilidade = dataDisponibilidade;
    }
}