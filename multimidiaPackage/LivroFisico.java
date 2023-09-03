package multimidiaPackage;

/*subclasse de Multimidia "LivroFisico"*/
public class LivroFisico extends Multimidia {
    private long isbn; // International Standard Book Number
    private int edicao;
    private int numCopias; // número de cópias que tem esse livro
    private String local; // localização do livro (estante e prateleira)
    private String estadoConsevacao; // estado de conservação do livro físico

    public LivroFisico(String titulo, int registro, String autor, String editora, int anoPublicacao, String sinopse,
            String capa, String historicoEmprestimo, boolean disponibilidade, long isbn, int edicao, int numCopias,
            int numCopiasDisponiveis, String local, String estadoConsevacao) {
        super(titulo, registro, autor, editora, anoPublicacao, sinopse, capa, historicoEmprestimo, disponibilidade,
                numCopiasDisponiveis);
        this.isbn = isbn;
        this.edicao = edicao;
        this.edicao = edicao;
        this.numCopias = numCopias;
        this.local = local;
        this.estadoConsevacao = estadoConsevacao;
    }

    public long getisbn() {
        return isbn;
    }

    public int getedicao() {
        return edicao;
    }

    public int getnumCopias() {
        return numCopias;
    }

    public String getlocal() {
        return local;
    }

    public String getestadoConsevacao() {
        return estadoConsevacao;
    }
}