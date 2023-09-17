package biblioteca.models.comentariosPackage;

import java.time.LocalDate;

import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.pessoasPackage.Pessoa;

public class Comentario {
    private LocalDate data;
    private Multimidia multimidia;
    private Pessoa pessoa;
    private String comentario;

    private Comentario(LocalDate data, Multimidia multimidia, Pessoa pessoa, String comentario) {
        this.data = data;
        this.multimidia = multimidia;
        this.comentario = comentario;
        this.pessoa = pessoa;
    }

    public LocalDate getdata() {
        return data;
    }

    public void setcomentario(String comentario) { // o comentário pode ser alterado por decisão do usuário ou caso a
                                                   // biblioteac o considere inapropriado
        this.comentario = comentario;
    }

    public String getMultimidianome() {
        return multimidia.gettitulo();
    }

    public String getpessoanome() {
        return pessoa.getnome();
    }

    public String getcomentario() {
        return comentario;
    }

    public Pessoa getpessoa() {
        return pessoa;
    }

    public Multimidia getmultimidia() {
        return multimidia;
    }

}
