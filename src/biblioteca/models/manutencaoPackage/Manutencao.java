package biblioteca.models.manutencaoPackage;

import java.time.LocalDate;
import biblioteca.models.multimidiaPackage.Multimidia;

public class Manutencao {
    private int proxid = 1;
    private int id;
    private Multimidia item;
    private LocalDate datainicio;
    private LocalDate previsaotermino;
    private String gravidade; // gravidade do dano
    private String matnecessario; // material mecessário para o reparo

    public Manutencao(Multimidia item, LocalDate datainicio, LocalDate previsaotermino, String gravidade,
            String matnecessario) {
        this.item = item;
        this.datainicio = datainicio;
        this.previsaotermino = previsaotermino;
        this.gravidade = gravidade;
        this.matnecessario = matnecessario;
        this.id = proxid++;
    }

    public int getid() {
        return id;
    }

    public Multimidia getitem() {
        return item;
    }

    public LocalDate getdatainicio() {
        return datainicio;
    }

    public LocalDate getprevisao() {
        return previsaotermino;
    }

    public String getgravidade() {
        return gravidade;
    }

    public String getmatnecessario() {
        return matnecessario;
    }

    public void setdatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public void setprevisao(LocalDate previsaotermino) {
        this.previsaotermino = previsaotermino;
    }

    public void setgravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public void setmatnecessario(String matnecessario) {
        this.matnecessario = matnecessario;
    }
}
