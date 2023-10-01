package biblioteca.models.multimidiaPackage;


import java.util.HashSet;
import java.util.Set;

/*subclasse de Multimidia "LivroFisico"*/
public class LivroFisico extends Multimidia {
    private long isbn; // International Standard Book Number
    private int edicao;
    private String local; // localização do livro (estante e prateleira)
    private String estadoConsevacao; // estado de conservação do livro físico

    // Mantenha um conjunto de ISBNs já utilizados
    private static Set<Long> isbnsUtilizados = new HashSet<>();

    public LivroFisico(String titulo,  String autor, String editora, int anoPublicacao,
            String sinopse, String capa, boolean disponibilidade, int numCopias,
            int numCopiasDisponiveis, long isbn, int edicao, String local, String estadoConsevacao, Categoria categoria) {
        super(titulo,  autor, editora, anoPublicacao, sinopse, capa, disponibilidade,
                numCopias, numCopiasDisponiveis, categoria);

        // Verifique se o ISBN já está em uso
        if (isbnsUtilizados.contains(isbn)) {
            throw new IllegalArgumentException("ISBN já existente.");
        }
        // Adicione o ISBN ao conjunto de ISBNs utilizados
        isbnsUtilizados.add(isbn);

        this.isbn = isbn;
        this.edicao = edicao;
        this.edicao = edicao;
        this.local = local;
        this.estadoConsevacao = estadoConsevacao;
    }

    public long getisbn() {
        return isbn;
    }

    public void setisbn(long isbn){
        this.isbn = isbn;
    }

    public int getedicao() {
        return edicao;
    }

    public void setedicao(int edicao){
        this.edicao = edicao;
    }
    
    public String getlocal() {
        return local;
    }

    public void setlocal(String local){
        this.local = local;
    }

    public String getestadoConsevacao() {
        return estadoConsevacao;
    }

    public void setestadoConservacao(String estadoConservacao){
        this.estadoConsevacao = estadoConservacao;
    }
}
