package biblioteca.models.pessoasPackage;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.renovacaoReservaPackage.Renovacao;

// Classe Funcionário da Biblioteca que herda de Pessoa
public class FuncionarioBiblioteca extends Pessoa {
    private String cargo;
    private float salario;
    private String horario;// horário de trabalho (ex: das 9h30 às 18h30)
    private static List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações
    private String acesso;// tipo de acesso, será verificado nas operações de classes que exigem certo
                          // nível de acesso

    // Construtor da classe Funcionário da Biblioteca
    public FuncionarioBiblioteca(String nome, LocalDate data, int registro, String contato, int idade, String endereco,
            Perfil perfil,
            String cargo, float salario, String horario, String acesso) {
        super(nome, data, registro, contato, idade, endereco, perfil);
        this.cargo = cargo;
        this.salario = salario;
        this.horario = horario;
        FuncionarioBiblioteca.emprestimos = new ArrayList<>();
        this.renovacoes = new ArrayList<>();
        this.acesso = acesso;// gerente, atendente, administrador
    }

    // Método específico para Funcionário da Biblioteca
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;

    }

    public String getacesso() {
        return acesso;
    }

    public void setacesso(String acesso) {
        this.acesso = acesso;

    }

    public String gethorario() {
        return horario;
    }

    public void setsalario(float salario) {
        this.salario = salario;

    }

    public float getsalario() {
        return salario;
    }

    /* descrição dos emprestimos */
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
