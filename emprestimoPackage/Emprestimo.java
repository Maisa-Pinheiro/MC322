package emprestimoPackage;

import java.time.LocalDate;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Pessoa.Perfil;

public class Emprestimo {
    private int registro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private float multa;

    private Emprestimo(int registro, LocalDate dataEmprestimo, LocalDate dataDevolucao, float multa) {// deixar o
                                                                                                      // construtor
                                                                                                      // privado pois só
                                                                                                      // Administradores
                                                                                                      // e
        // Atendentes podem criar
        this.registro = registro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
    }

    public int getregistro() {
        return registro;
    }

    public void setregistro(int registro) {
        this.registro = registro;
    }

    public LocalDate getdataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getdataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getmulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    // mudar o tipo ↓↓↓↓ de acordo com as classes que você criar
    public static Emprestimo criarEmprestimoComAprovacao(int registro, LocalDate dataEmprestimo,
            LocalDate dataDevolucao, float multa,
            FuncionarioBiblioteca funcionario) {// colocar atributos, deixar esse ultimo no final->,
        // FuncionarioBiblioteca funcionario
        String acess = funcionario.getacesso();
        if ("Administrador".equals(acess) || "Atendente".equals(acess)) {
            // Se o valor da variável "acess" for igual a "Administrador" ou "Atendente",
            // execute o seguinte bloco de código.
            Emprestimo emprestimo = new Emprestimo(registro, dataEmprestimo, dataDevolucao, multa);
            GerenciadorEmprestimos.adicionarEmprestimo(emprestimo); // Adicione o empréstimo à lista
            return emprestimo;
        } else {
            // Caso contrário, execute o seguinte bloco de código.
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Retorne null (ou você pode lançar uma exceção se preferir)
        }
    }

    /* condições de acesso de acordo com o perfil de pessoa */
    public static Emprestimo criarEmprestimoPerfil(int registro, LocalDate dataEmprestimo, LocalDate dataDevolucao,
            float multa) {
        Perfil perfil = pessoasPackage.Pessoa.getperfil();
        int limiteEmprestimo;
        int prazoDias;
        // float multa;

        switch (perfil) {
            case ESTUDANTE_GRADUACAO:
                limiteEmprestimo = 3;
                prazoDias = 15;
                // multa = 1.00f;
                if (pessoasPackage.AlunoGraduacao.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case ESTUDANTE_POS_GRADUACAO:
                limiteEmprestimo = 5;
                prazoDias = 20;
                // multa = 1.00f;
                if (pessoasPackage.AlunoPosGraduacao.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case PROFESSOR:
                limiteEmprestimo = 7;
                prazoDias = 30;
                // multa = 0.50f;
                if (pessoasPackage.Professor.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case FUNCIONARIO:
                limiteEmprestimo = 4;
                prazoDias = 20;
                // multa = 0.75f;
                if (pessoasPackage.FuncionarioBiblioteca.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;
            default:
                return null;
        }
        // Calcula a data de vencimento com base no prazo
        dataDevolucao = LocalDate.now().plusDays(prazoDias);

        Emprestimo emprestimo = new Emprestimo(registro, dataEmprestimo, dataDevolucao, multa);
        GerenciadorEmprestimos.adicionarEmprestimo(emprestimo); // Adicione o empréstimo à lista
        return emprestimo;
    }
}