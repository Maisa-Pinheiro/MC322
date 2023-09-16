package biblioteca.models.pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.renovacaoReservaPackage.Renovacao;

public class AlunoGraduacao extends Pessoa {
    private int ra;
    private String curso;
    private static List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Aluno de Graduação
    public AlunoGraduacao(String nome, LocalDate data, int id, String contato, int idade, String endereco,
            Perfil perfil,
            int ra, String curso) {
        super(nome, data, id, contato, idade, endereco, perfil);
        this.ra = ra;
        AlunoGraduacao.emprestimos = new ArrayList<>();
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

    /*descrição dos emprestimos*/
    public void getemprestimos() {
        System.out.println("empréstimos do aluno:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.getregistro());
        }
        System.out.println("\n");
    }
    /*quantidade de emprestimos*/
    public static int contarEmprestimos() {
        return emprestimos.size();
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

    // adicionar empréstimo
    public void novoEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    /* condições para o funcionario "criar" uma aluno de graduação */
   
}
