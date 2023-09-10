package biblioteca.models.emprestimoPackage;

import java.time.LocalDate;

import biblioteca.models.multimidiaPackage.Multimidia;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.pessoasPackage.Pessoa.Perfil;

public class Emprestimo {
    private int registro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private float multa;
    private Multimidia multimidia;
    private Pessoa pessoa;

    /* construtor privado, pois só administradores podem criar */
    private Emprestimo(int registro, LocalDate dataEmprestimo, LocalDate dataDevolucao, float multa,
            Multimidia multimidia, Pessoa pessoa) {
        Perfil perfil = biblioteca.models.pessoasPackage.Pessoa.getperfil();
        // Verifique o perfil do usuário
        switch (perfil) {
            case ESTUDANTE_GRADUACAO:
                // Lógica específica para estudantes de graduação
                // Por exemplo:
                int limiteEmprestimoEstudanteGraduacao = 3;
                if (biblioteca.models.pessoasPackage.AlunoGraduacao
                        .contarEmprestimos() >= limiteEmprestimoEstudanteGraduacao) {
                    throw new IllegalArgumentException("Limite de empréstimos para estudantes de graduação atingido.");

                }
                break;

            case ESTUDANTE_POS_GRADUACAO:
                // Lógica específica para estudantes de pós-graduação
                // Por exemplo:
                int limiteEmprestimoEstudantePosGraduacao = 5;
                if (biblioteca.models.pessoasPackage.AlunoPosGraduacao
                        .contarEmprestimos() >= limiteEmprestimoEstudantePosGraduacao) {
                    throw new IllegalArgumentException(
                            "Limite de empréstimos para estudantes de pós-graduação atingido.");
                }
                break;

            case PROFESSOR:
                // Lógica específica para professores
                // Por exemplo:
                int limiteEmprestimoProfessor = 7;
                if (biblioteca.models.pessoasPackage.Professor.contarEmprestimos() >= limiteEmprestimoProfessor) {
                    throw new IllegalArgumentException("Limite de empréstimos para professores atingido.");

                }
                break;

            case FUNCIONARIO:
                // Lógica específica para funcionários
                // Por exemplo:
                int limiteEmprestimoFuncionario = 4;
                if (biblioteca.models.pessoasPackage.FuncionarioBiblioteca
                        .contarEmprestimos() >= limiteEmprestimoFuncionario) {
                    throw new IllegalArgumentException("Limite de empréstimos para funcionários atingido.");

                }
                break;

            default:

                break;
        }
        this.registro = registro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        this.multimidia = multimidia;
        this.pessoa = pessoa;
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

    public String getMultimidia() {
        return multimidia.gettitulo();
    }

    public String getpessoa() {
        return pessoa.getnome();
    }

}