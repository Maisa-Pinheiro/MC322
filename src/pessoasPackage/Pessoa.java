package pessoasPackage;

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

        public static Perfil fromString(String perfilStr) {
            switch (perfilStr) {
                case "ESTUDANTE_GRADUACAO":
                    return ESTUDANTE_GRADUACAO;
                case "ESTUDANTE_POS_GRADUACAO":
                    return ESTUDANTE_POS_GRADUACAO;
                case "PROFESSOR":
                    return PROFESSOR;
                case "FUNCIONARIO":
                    return FUNCIONARIO;
                default:
                    throw new IllegalArgumentException("Perfil não reconhecido: " + perfilStr);
            }
        }
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
}