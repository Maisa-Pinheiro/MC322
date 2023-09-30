package ComentariosPackage;

import java.time.LocalDate;
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

    public Manutencao(Multimidia item, LocalDate datainicio, LocalDate previsaotermino, String gravidade, String matnecessario){
        this.item = item;
        this.datainicio = datainicio;
        this.previsaotermino = previsaotermino;
        this.gravidade = gravidade;
        this.matnecessario = matnecessario;
        this.id = proxid++;
    }

    public int getid(){
        return id;
    }
    
    public LocalDate getdatainicio(){
        return datainicio;
    }

    public LocalDate getprevisao(){
        return previsaotermino;
    }

    public String getgravidade(){
        return gravidade;
    }

     public String getmatnecessario(){
        return matnecessario;
    }

    public void setdatainicio(LocalDate datainicio){
        this.datainicio = datainicio;
    }

    public void setprevisao(LocalDate previsaotermino){
        this.previsaotermino = previsaotermino;
    }

    public void setgravidade(String gravidade){
        this.gravidade = gravidade;
    }

     public void setmatnecessario(String matnecessario){
        this.matnecessario = matnecessario;
    }
}

import multimidiaPackage.Multimidia;
import pessoasPackage.Pessoa;
import pessoasPackage.Pessoa.Perfil;

public class Comentarios {
    private LocalDate data;
    private  Multimidia multimidia;
    private  Pessoa pessoa;
    private String comentario;

  
    private Comentarios(LocalDate data, Multimidia multimidia, Pessoa pessoa, String comentario) {
        this.data = data;
        this.multimidia = multimidia;
        this.comentario = comentario;
        this.pessoa = pessoa;
    }


    public LocalDate getdata() {
        return data;
    }

    public void setcomentario(String comentario)) { // o comentário pode ser alterado por decisão do usuário ou caso a biblioteac o considere inapropriado
        this.comentario = dataDevolucaocomentario;
    }


    public String getMultimidianome() {
        return multimidia.gettitulo();
    }

    public String getpessoanome() {
        return pessoa.getnome();
    }
    
    public String getcomentario() {
        return comentario();
    }
    
    public Pessoa getpessoa(){
        return pessoa;
    }
    
    public Multimidia getmultimidia(){
        return multimidia;
    }

}
