package multimidiaPackage;

import java.net.URL;
import java.time.LocalDate;

public class LivroEletronico extends Multimidia {
    private String formato; // PDF, ePub, etc.
    private int numLicencas; // para determinar o número de cópias simultâneas permitidas
    private URL url; // Campo para armazenar a URL
    private String requisitosLeitura; // quais são os requisitos para leitura desse livro (SW e compatibilidade)
    private LocalDate dataDisponibilidade; // Atributo para armazenar a data de disponibilidade

    public LivroEletronico(String titulo, int registro, String autor, String editora, int anoPublicacao,
            String sinopse, String capa, String historicoEmprestimo, boolean disponibilidade,
            String formato, int numLicencas, URL url, LocalDate dataDisponibilidade) {
        super(titulo, registro, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade);
        this.formato = formato;
        this.numLicencas = numLicencas;
        this.url = url;
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

    public int getnumLicencas() {
        return numLicencas;
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