package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.renovacaoReservaPackage.Renovacao;

// Classe Professor que herda de Pessoa
public class Professor extends Pessoa {
    private String instituto;
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Professor
    public Professor(String nome, LocalDate data, int id, String contato, int idade, String endereco,
            Perfil perfil, String instituto) {
        super(nome, data, contato, idade, endereco, perfil);
        this.instituto = instituto;
        this.renovacoes = new ArrayList<>();
    }

    // getters e setters do professor
    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }


    public void getrenovacoes() {
        System.out.println("renovações do aluno:");
        for (Renovacao renovacao : renovacoes) {
            System.out.println(renovacao.getregistro());
        }
        System.out.println("\n");
    }

    // adicionar renovações
    public void adicionarRenovacao(Renovacao renovacao) {
        renovacoes.add(renovacao);
    }
    
}
