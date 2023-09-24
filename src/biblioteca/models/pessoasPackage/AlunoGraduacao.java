package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.renovacaoReservaPackage.Renovacao;

public class AlunoGraduacao extends Pessoa {
    private int ra;
    private String curso;
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Aluno de Graduação
    public AlunoGraduacao(String nome, LocalDate data, int id, String contato, int idade, String endereco,
            Perfil perfil,
            int ra, String curso) {
        super(nome, data, contato, idade, endereco, perfil);
        this.ra = ra;
        this.renovacoes = new ArrayList<>();
    }

    // Método específico para Aluno de Graduação
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
