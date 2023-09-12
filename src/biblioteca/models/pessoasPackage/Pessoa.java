package biblioteca.models.pessoasPackage;

import java.time.LocalDate;

public class Pessoa { // pessoa não será uma classe abstrata, pois uma pessoa pode não ser nem, aluno,
                      // nem professor, nem funcionário, mas ainda estar na biblioteca(um visitante,
                      // por exemplo)
    private String nome;
    private LocalDate data;// Data de Registro
    private int registro;// Número de Identificação da Universidade
    private String contato; // e-mail ou telefone
    private int idade;
    private String endereco;
    private static Perfil perfil;
    // criar um atributo vertor para adicionar os membros --> ver com a Maisa se posso mudar "registro para ID" para fazer busca

    /* construtor dedicado apenas aos usuarios */
    public Pessoa(String nome, LocalDate data, int registro, String contato, int idade, String endereco,
            Perfil perfil) {
        this.nome = nome;
        this.data = data;
        this.registro = registro;
        this.contato = contato;
        this.idade = idade;
        this.endereco = endereco;
        Pessoa.perfil = perfil;
    }

    /* getters para os atributos privados */
    public String getnome() {
        return nome;
    }

    public LocalDate getdata() {
        return data;
    }

    public int getregistro() {
        return registro;
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

    // criar três metodos: adição de membro, remoção de membro e busca de membro por ID
}