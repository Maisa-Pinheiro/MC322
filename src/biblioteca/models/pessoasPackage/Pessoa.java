package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* classe "mãe" */
public class Pessoa { // pessoa não será uma classe abstrata, pois uma pessoa pode não ser nem, aluno,
                      // nem professor, nem funcionário, mas ainda estar na biblioteca(um visitante,
                      // por exemplo)
    private String nome;
    private LocalDate data;// Data de Registro
    private int id;// Número de Identificação interno da Universidade
    private String contato; // e-mail ou telefone
    private int idade;
    private String endereco;
    private static Perfil perfil;
    private List<Pessoa> listaPessoas;

    /* construtor dedicado apenas aos usuarios */
    public Pessoa(String nome, LocalDate data, int id, String contato, int idade, String endereco,
            Perfil perfil) {
        this.nome = nome;
        this.data = data;
        this.id = id;
        this.contato = contato;
        this.idade = idade;
        this.endereco = endereco;
        Pessoa.perfil = perfil;
        this.listaPessoas = new ArrayList<>();
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

    /* Estrutura de dados para perfil de pessoa */
    public enum Perfil {
        ESTUDANTE_GRADUACAO,
        ESTUDANTE_POS_GRADUACAO,
        PROFESSOR,
        FUNCIONARIO;
    }

    public static Perfil getperfil() {
        return perfil;
    }

    /*
     * setters dos atributos que não mudam com frequência(atributos que não serão
     * mudados não tem setter)
     */
    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    /* Criação de metodos */
    /* Metodo para adicionar pessoa a lista */
    public void addPessoa(Pessoa pessoa) {
        int idpessoa = pessoa.getid();
        for (Pessoa membro : listaPessoas) {
            if (membro.getid() == idpessoa) {
                System.out.println("Erro: Não é possivel adicionar essa pessoa a lista, pois já existe uma pessoa com o mesmo ID");
                return;
            }
        }
        listaPessoas.add(pessoa);
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
    public void removerPessoaLista(int id) {
        /* cirando um iterador para percorrer a lista */
        Iterator<Pessoa> iterator = listaPessoas.iterator();
        /* enquanto o interador tiver um próximo (não chegou ao fim da lista) */
        while (iterator.hasNext()) {
            Pessoa pessoa = iterator.next();
            if (pessoa.getid() == id) {
                iterator.remove();
                System.out.println("Pessoa com ID" + id + "foi removida com sucesso.");
                return;
            }
        }
        System.out.println("Pessoa com ID " + id + " não encontrada na lista.");
    }

}