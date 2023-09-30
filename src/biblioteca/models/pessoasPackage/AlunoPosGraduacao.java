package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.renovacaoReservaPackage.Renovacao;

// Classe Aluno de Pós-Graduação que herda de Pessoa
public class AlunoPosGraduacao extends Pessoa {
    private int ra;
    private String curso;
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Aluno de Pós-Graduação 
    public AlunoPosGraduacao(String nome, LocalDate data, String contato, int idade, String endereco,
            Perfil perfil, int ra, String curso) {
        super(nome, data, contato, idade, endereco, perfil);
        this.curso = curso;
        this.ra = ra;
        this.renovacoes = new ArrayList<>();
    }

    // setters e getters
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getra() {
        return ra;
    }

    public void setra(int ra) {
        this.ra = ra;
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
