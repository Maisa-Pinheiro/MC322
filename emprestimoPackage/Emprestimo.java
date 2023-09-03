package emprestimoPackage;

import java.time.LocalDate;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Pessoa.Perfil;

public class Emprestimo {
    private int registro;
    public LocalDate prazo; // prazo de devolução

    private Emprestimo(LocalDate prazo, int registro) {// deixar o construtor privado pois só Administradores e
                                                       // Atendentes podem criar
        this.prazo = prazo;
        this.registro = registro;
    }

    public int getregistro() {
        return registro;
    }

    public void setregistro(int registro) {
        this.registro = registro;
    }

    public LocalDate getprazo() {
        return prazo;
    }

    // mudar o tipo ↓↓↓↓ de acordo com as classes que você criar
    public static Emprestimo criarEmprestimoComAprovacao(LocalDate prazo, int registro,
            FuncionarioBiblioteca funcionario) {// colocar atributos, deixar esse ultimo no final->,
        // FuncionarioBiblioteca funcionario
        String acess = funcionario.getacesso();
        if ("Administrador".equals(acess) || "Atendente".equals(acess)) {
            // Se o valor da variável "acess" for igual a "Administrador" ou "Atendente",
            // execute o seguinte bloco de código.
            return new Emprestimo(prazo, registro); // Crie um objeto Emprestimo e retorne-o
        } else {
            // Caso contrário, execute o seguinte bloco de código.
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Retorne null (ou você pode lançar uma exceção se preferir)
        }
    }

    /* condições de acesso de acordo com o perfil de pessoa */
    public static Emprestimo criarEmprestimoPerfil(LocalDate prazo, int registro) {
        Perfil perfil = pessoasPackage.Pessoa.getperfil();
        int limiteEmprestimo;
        int prazoDias;
        //float multa;

        switch (perfil) {
            case ESTUDANTE_GRADUACAO:
                limiteEmprestimo = 3;
                prazoDias = 15;
                //multa = 1.00f;
                if (pessoasPackage.AlunoGraduacao.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case ESTUDANTE_POS_GRADUACAO:
                limiteEmprestimo = 5;
                prazoDias = 20;
                //multa = 1.00f;
                if (pessoasPackage.AlunoPosGraduacao.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case PROFESSOR:
                limiteEmprestimo = 7;
                prazoDias = 30;
                //multa = 0.50f;
                if (pessoasPackage.Professor.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;

            case FUNCIONARIO:
                limiteEmprestimo = 4;
                prazoDias = 20;
                //multa = 0.75f;
                if (pessoasPackage.FuncionarioBiblioteca.contarEmprestimos() >= limiteEmprestimo) {
                    System.out.println("Limite de empréstimos atingido.");
                    return null;
                }
                break;
            default:
                return null;
        }
        // Calcula a data de vencimento com base no prazo
        LocalDate dataDevolucao = LocalDate.now().plusDays(prazoDias);

        return new Emprestimo(dataDevolucao, registro);
    }
}