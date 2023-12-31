package biblioteca.models.multimidiaPackage;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import biblioteca.models.renovacaoReservaPackage.Renovacao;
import biblioteca.models.comentariosPackage.Comentario;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.pessoasPackage.Pessoa;

/*classe principal "Multimidia" que ira conter subclasses - Abstrata, pois só há intanciação da suas subclasses*/
public class Multimidia {


    public enum Categoria {
        POESIA, ROMANCE, ACAO, FICCAO, FANTASIA // mais categorias serão adicionadas posteriormente
    }

    private String titulo; // título
    private static int proximoid = 1;
    private int id; // número de registro do livro para biblioteca
    private String autor; // autor ou artista do item do acervo
    private String editora; // editora ou gravadora do item
    private int anoPublicacao; // o ano referente a publicação da obra
    private String sinopse; // resumo conciso e breve do objeto em questão
    private String capa; // no futuro uma classe será implementada no lugar desse atibuto
    public boolean disponibilidade; // true se a cópia em questão está disponível, false se não está
    private int numCopias; // número de cópias que tem esse item
    public int numCopiasDisponiveis; // número de copias (ou licensas) desse titulo que estão disponiveis
    private List<Comentario> comentarios; // comentários de usuários a respeito da obra
    private Categoria categoria;// ação, fantasia, romance, biografia, etc
    private Set<Categoria> categoriasDisponiveis;
    private boolean dano;
    private String local;
    private LinkedList<Renovacao> reservas; // lista com a ordem de reservas do livro em questão
    // membros ao mesmo tempo.

    public Multimidia(String titulo, String autor, String editora, int anoPublicacao, String sinopse,
            String capa, boolean disponibilidade, int numCopias, int numCopiasDisponiveis,
            Categoria categoria, String local) {
        if (anoPublicacao < 0 || numCopias < 0 || numCopiasDisponiveis < 0 || numCopiasDisponiveis > numCopias) {
            throw new DadosInvalidosException("Dados de multimídia inválidos.");
        }
        this.titulo = titulo;
        this.id = proximoid++;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.sinopse = sinopse;
        this.capa = capa;
        this.disponibilidade = disponibilidade;
        this.numCopias = numCopias;
        this.numCopiasDisponiveis = numCopiasDisponiveis;
        this.comentarios = new ArrayList<>();
        this.reservas = new LinkedList<>();
        this.categoria = categoria;
        inicializarCategoriasDisponiveis();
        this.dano = false;
        this.local = local;
    }

    public void settitulo(String titulo){
        this.titulo = titulo;
    }

    public void setdano(boolean dano){
        this.dano = dano;
    }

    public boolean isDanificado(){
        return dano;
    }
    public void setautor(String autor){
        this.autor = autor;
    }
    public void seteditora(String editora){
        this.editora = editora;
    }
    public void setlocal(String local){
        this.local = local;
    }
    public void setanoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    public void setsinopse(String sinopse){
        this.sinopse = sinopse;
    }
    public void setcapa(String capa){
        this.capa = capa;
    }
    public void setdisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }
    public void setnumCopias(int numCopias){
        this.numCopias = numCopias;
    }
    public void setnumCopiasDisponiveis(int numCopiasDisponiveis){
        this.numCopiasDisponiveis = numCopiasDisponiveis;
    }
    public void setcategoria(Categoria categoria){
        this.categoria = categoria;
    }
    

    private void inicializarCategoriasDisponiveis() {
        categoriasDisponiveis = new HashSet<>(); 
        for (Categoria categoria : Categoria.values()) {
            categoriasDisponiveis.add(categoria);
        }
    }

    public String gettitulo() {
        return titulo;
    }

    public int getid() {
        return id;
    }

    public String getautor() {
        return autor;
    }

    public Categoria getcategoria() {
        return categoria;
    }

    public LinkedList<Renovacao> getreservas() {
        return reservas;
    }

    public int getsize() {
        return reservas.size();
    }

    public void remove(int x) {
        reservas.remove(x);
    }

    public void addreserva(Renovacao reserva) {
        reservas.add(reserva);
    }

    public String geteditora() {
        return editora;
    }

    public int getanoPublicacao() {
        return anoPublicacao;
    }

    public String getsinopse() {
        return sinopse;
    }

    public String getcapa() {
        return capa;
    }

    public int getnumCopias() {
        return numCopias;
    }

    public int getnumCopiasDisponiveis() {
        return numCopiasDisponiveis;
    }

    public void SetnumCopiasDisponiveis(int valor) {
        this.numCopiasDisponiveis = valor;
    }

    public void addcomentario(Comentario comentario) {
        comentarios.add(comentario);
    }



}
