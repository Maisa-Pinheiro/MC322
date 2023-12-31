package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.multimidiaPackage.Multimidia;

/* classe "mãe" */
abstract public class Pessoa { // como agora os empréstimnos foram transferidos diretamente para a classe mãe,
                               // ela passa a ser abstrata
    private String nome;
    private LocalDate data;// Data de Registro
    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int id;// Número de Identificação interno da Universidade
    private String contato; // e-mail ou telefone
    private int idade;
    private String endereco;
    private Perfil perfil;
    private static List<Pessoa> listaPessoas;
    private LinkedList<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo membro
    private boolean podeemprestar; // true -pode, false- não pode, bloqueado por atraso
    private List<Multimidia> historico; // histórico de itens emprestados

    /* construtor dedicado apenas aos usuarios */
    public Pessoa(String nome, LocalDate data, String contato, int idade, String endereco,
            Perfil perfil) {
        this.nome = nome;
        this.data = data;
        this.id = proximoId++;
        this.contato = contato;
        this.idade = idade;
        this.endereco = endereco;
        this.perfil = perfil;
        if (listaPessoas == null) {
            Pessoa.listaPessoas = new ArrayList<>();
        }
        this.emprestimos = new LinkedList<>();
        this.historico = new ArrayList<>();
        this.podeemprestar = true;
    }

    /* getters para os atributos privados */
    public String getnome() {
        return nome;
    }

    public LocalDate getdata() {
        return data;
    }

    public int getid() {
        return id;
    }

    public String getcontato() {
        return contato;
    }

    public int getidade() {
        return idade;
    }

    public String getendereco() {
        return endereco;
    }

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setpodeemprestar(boolean podeemprestar) {
        this.podeemprestar = podeemprestar;
    }

    public Boolean getpodeemprestar() {
        return podeemprestar;
    }

    /* Estrutura de dados para perfil de pessoa */
    public enum Perfil {
        ESTUDANTE_GRADUACAO,
        ESTUDANTE_POS_GRADUACAO,
        PROFESSOR,
        FUNCIONARIO;
    }

    public Perfil getperfil() {
        return perfil;
    }

    /*
     * setters dos atributos que não mudam com frequência(atributos que não serão
     * mudados não tem setter)
     */
    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setcontato(String contato) {
        this.contato = contato;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    /* Criação de metodos */
    /* Metodo para adicionar pessoa a lista */
    public static void addPessoa(Pessoa pessoa) {
        int idpessoa = pessoa.getid();
        for (Pessoa membro : listaPessoas) {
            if (membro.getid() == idpessoa) {
                System.out.println(
                        "Erro: Não é possivel adicionar essa pessoa a lista, pois já existe uma pessoa com o mesmo ID");
                return;
            }
        }
        listaPessoas.add(pessoa);
    }

    /* Metodo para retornar a lista de pessoas */
    public static List<Pessoa> listarPessoas() {
        return listaPessoas;
    }

    /*
     * Metodo para buscar uma pessoa da lista por ID - do tipo pessoa, pois deve
     * retornar a pessoa buscada
     */
    public Pessoa buscaPessoaPorID(int id) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getid() == id) {
                return pessoa; /* Se encontrar, retona a pessoa */
            }
        }
        return null; /* Se não encontrar, retona NULL */
    }

    /* Metodo para remover uma pessoa com id especifico da lista */
    public static void removerPessoaLista(int id) {
        /* cirando um iterador para percorrer a lista */
        Iterator<Pessoa> iterator = listaPessoas.iterator();
        /* enquanto o interador tiver um próximo (não chegou ao fim da lista) */
        while (iterator.hasNext()) {
            Pessoa pessoa = iterator.next();
            if (pessoa.getid() == id) {
                iterator.remove();
                System.out.println("Pessoa com ID: " + id + " foi removida com sucesso.\n");
                return;
            }
        }
        System.out.println("Pessoa com ID " + id + " não encontrada na lista.");
    }

    public void getemprestimosid() {
        System.out.println("empréstimos do membro:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.getregistro());
        }
        System.out.println("\n");
    }

    /* quantidade de emprestimos */
    public int contarEmprestimos() {
        return emprestimos.size();
    }

    // adicionar empréstimo
    public void novoEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    // retornar a lista de emprestimos
    public LinkedList<Emprestimo> getemprestimos() {
        return emprestimos;
    }

    public void addhistorico(Multimidia item) {
        historico.add(item);
    }

    public List<Multimidia> gethistorico() {
        return historico;
    }

    public void removeremprestimo(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }

}
