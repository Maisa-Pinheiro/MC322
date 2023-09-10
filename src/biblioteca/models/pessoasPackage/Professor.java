package pessoasPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import emprestimoPackage.Emprestimo;
import renovacaoReservaPackage.Renovacao;

// Classe Professor que herda de Pessoa
public class Professor extends Pessoa {
    private String instituto;
    private static List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações

    // Construtor da classe Professor
    public Professor(String nome, LocalDate data, int registro, String contato, int idade, String endereco,
            Perfil perfil, String instituto) {
        super(nome, data, registro, contato, idade, endereco, perfil);
        this.instituto = instituto;
        Professor.emprestimos = new ArrayList<>();
        this.renovacoes = new ArrayList<>();
    }

    // getters e setters do professor
    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    /* descrição dos emprstimos */
    public void getemprestimos() {
        System.out.println("empréstimos do aluno:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.getregistro());
        }
        System.out.println("\n");
    }

    /* quantidade de emprestimos */
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

    
}
