package biblioteca.models.emprestimoPackage;

import java.time.LocalDate;

import biblioteca.models.multimidiaPackage.Multimidia;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.pessoasPackage.Pessoa.Perfil;

public class Emprestimo {
    private static int proximoregistro = 1; // Variável estática para rastrear o próximo id
    private int registro;// Id
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private float multa;
    private Multimidia multimidia;
    private Pessoa pessoa;

    /* construtor privado, pois só administradores podem criar */
    private Emprestimo( LocalDate dataEmprestimo, Multimidia multimidia, Pessoa pessoa) {
        this.registro = proximoregistro++;
        this.dataEmprestimo = dataEmprestimo;
        this.multa = 0 ;
        this.multimidia = multimidia;
        this.pessoa = pessoa;
        Perfil perfil = biblioteca.models.pessoasPackage.Pessoa.getperfil();
        // Verifique o perfil do usuário
        switch (perfil) {
            case ESTUDANTE_GRADUACAO:
                // Lógica específica para estudantes de graduação
                // Por exemplo:
                this.dataDevolucao = dataEmprestimo.plusDays(15);
                int limiteEmprestimoEstudanteGraduacao = 3;
                if (biblioteca.models.pessoasPackage.AlunoGraduacao
                        .contarEmprestimos() >= limiteEmprestimoEstudanteGraduacao) {
                    throw new IllegalArgumentException("Limite de empréstimos para estudantes de graduação atingido.");
                }
            
                break;

            case ESTUDANTE_POS_GRADUACAO:
                // Lógica específica para estudantes de pós-graduação
                // Por exemplo:
                 this.dataDevolucao = dataEmprestimo.plusDays(20);
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
                 this.dataDevolucao = dataEmprestimo.plusDays(30);
                int limiteEmprestimoProfessor = 7;
                if (biblioteca.models.pessoasPackage.Professor.contarEmprestimos() >= limiteEmprestimoProfessor) {
                    throw new IllegalArgumentException("Limite de empréstimos para professores atingido.");

                }
                break;

            case FUNCIONARIO:
                // Lógica específica para funcionários
                // Por exemplo:
                 this.dataDevolucao = dataEmprestimo.plusDays(20);
                int limiteEmprestimoFuncionario = 4;
                if (biblioteca.models.pessoasPackage.FuncionarioBiblioteca
                        .contarEmprestimos() >= limiteEmprestimoFuncionario) {
                    throw new IllegalArgumentException("Limite de empréstimos para funcionários atingido.");

                }
                break;

            default:

                break;
        }
        
        
        
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

    public void setMulta(int atraso) {
        float multiplicador = 1.0f;
        switch (pessoa.getPerfil()) {
            case ALUNO_GRADUACAO:
            case ALUNO_POS_GRADUACAO:
                multiplicador = 1.0f;
                break;
            case PROFESSOR:
                multiplicador = 0.5f;
                break;
            case FUNCIONARIO:
                multiplicador = 0.75f;
                break;
            default:
                // Trate qualquer outro caso aqui, se necessário
                break;
        }
        multa = (multiplicador * atraso);
        this.multa = multa;
    }

    public Multimidia getMultimidia() {
        return multimidia;
    }

    public String getpessoa() {
        return pessoa.getnome();
    }

}
