package pessoasPackage;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import emprestimoPackage.Emprestimo;
import renovacaoReservaPackage.Renovacao;

// Classe Funcionário da Biblioteca que herda de Pessoa
public class FuncionarioBiblioteca extends Pessoa {
    private String cargo;
    private float salario;
    private String horario;// horário de trabalho (ex: das 9h30 às 18h30)
    private List<Emprestimo> emprestimos;// lista com os empréstimos feitos pelo aluno
    private List<Renovacao> renovacoes; // A lista de renovações
    private String acesso;// tipo de acesso, será verificado nas operações de classes que exigem certo
                          // nível de acesso

    // Construtor da classe Funcionário da Biblioteca(é publico pois precisa-se de
    // pelo menos um funcionário criado sem permissão para criar os outros)
    public FuncionarioBiblioteca(String nome, LocalDate data, int registro, String contato, int idade, String endereco,
            String cargo, float salario, String horario, String acesso) {
        super(nome, data, registro, contato, idade, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.horario = horario;
        this.emprestimos = new ArrayList<>();
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

    public void getemprestimos() {
        System.out.println("empréstimos do aluno:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.getregistro());
        }
        System.out.println("\n");
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

    public static FuncionarioBiblioteca criarFuncionarioAprovacao(String nome, LocalDate data, int registro,
            String contato, int idade, String endereco,
            String cargo, float salario, String horario, String acesso, FuncionarioBiblioteca funcionario) {
        String acess = funcionario.getacesso();
        if ("Administrador".equals(acess)) {
            return new FuncionarioBiblioteca(nome, data, registro, contato, idade, endereco, cargo, salario, horario,
                    acesso);
        } else {
            System.out.println("Funcionário não autorizado a criar um Funcionário.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
    }
}