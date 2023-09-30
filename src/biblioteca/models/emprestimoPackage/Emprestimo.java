package biblioteca.models.emprestimoPackage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import biblioteca.models.multimidiaPackage.Multimidia;
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
    private Set<Emprestimo> emprestimosSemRepeticao; // set para garantir que um item não seja emprestado para dois
     // membros ao mesmo tempo.

    /* construtor privado, pois só administradores podem criar */
    public Emprestimo(LocalDate dataEmprestimo, Multimidia multimidia, Pessoa pessoa) {
        Perfil perfil = pessoa.getperfil();

        // Verifique o perfil do usuário
        switch (perfil) {
            case ESTUDANTE_GRADUACAO:
                // Lógica específica para estudantes de graduação
                // Por exemplo:
                this.dataDevolucao = dataEmprestimo.plusDays(15);
                int limiteEmprestimoEstudanteGraduacao = 3;
                if (pessoa.contarEmprestimos() >= limiteEmprestimoEstudanteGraduacao) {
                    throw new IllegalArgumentException(
                            "Limite de empréstimos para estudantes de graduação atingido. O Usuário não pode emprestar mais itens do que o limite permitido");
                    // se o perfil de pessoa não atingiu o limite de emprestimo
                } else {
                    this.registro = proximoregistro++;
                    this.dataEmprestimo = dataEmprestimo;
                    this.multa = 0;
                    this.multimidia = multimidia;
                    this.pessoa = pessoa;
                    emprestimosSemRepeticao = new HashSet<>();
                }
                break;

            case ESTUDANTE_POS_GRADUACAO:
                // Lógica específica para estudantes de pós-graduação
                // Por exemplo:
                this.dataDevolucao = dataEmprestimo.plusDays(20);
                int limiteEmprestimoEstudantePosGraduacao = 5;
                if (pessoa.contarEmprestimos() >= limiteEmprestimoEstudantePosGraduacao) {
                    throw new IllegalArgumentException(
                            "Limite de empréstimos para estudantes de pós-graduação atingido.O Usuário não pode emprestar mais itens do que o limite permitido");
                } else {
                    this.registro = proximoregistro++;
                    this.dataEmprestimo = dataEmprestimo;
                    this.multa = 0;
                    this.multimidia = multimidia;
                    this.pessoa = pessoa;
                    emprestimosSemRepeticao = new HashSet<>();
                }
                break;

            case PROFESSOR:
                // Lógica específica para professores
                // Por exemplo:
                this.dataDevolucao = dataEmprestimo.plusDays(30);
                int limiteEmprestimoProfessor = 7;
                if (pessoa.contarEmprestimos() >= limiteEmprestimoProfessor) {
                    throw new IllegalArgumentException("Limite de empréstimos para professores atingido. O Usuário não pode emprestar mais itens do que o limite permitido");

                } else {
                    this.registro = proximoregistro++;
                    this.dataEmprestimo = dataEmprestimo;
                    this.multa = 0;
                    this.multimidia = multimidia;
                    this.pessoa = pessoa;
                    emprestimosSemRepeticao = new HashSet<>();
                }
                break;

            case FUNCIONARIO:
                // Lógica específica para funcionários
                // Por exemplo:
                this.dataDevolucao = dataEmprestimo.plusDays(20);
                int limiteEmprestimoFuncionario = 4;
                if (pessoa.contarEmprestimos() >= limiteEmprestimoFuncionario) {
                    throw new IllegalArgumentException("Limite de empréstimos para funcionários atingido.O Usuário não pode emprestar mais itens do que o limite permitido");

                } else {
                    this.registro = proximoregistro++;
                    this.dataEmprestimo = dataEmprestimo;
                    this.multa = 0;
                    this.multimidia = multimidia;
                    this.pessoa = pessoa;
                    emprestimosSemRepeticao = new HashSet<>();
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

    public void setmulta(int atraso, Pessoa pessoa) {
        float multiplicador = 1.0f;
        Perfil perfil2 = pessoa.getperfil();
        switch (perfil2) {
            case ESTUDANTE_GRADUACAO:
                multiplicador = 1.0f;
                break;
            case ESTUDANTE_POS_GRADUACAO:
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
        float multa = (multiplicador * atraso);
        this.multa = multa;
    }

    public Multimidia getMultimidia() {
        return multimidia;
    }

    public String getpessoa() {
        return pessoa.getnome();
    }

    public void SetemprestimosSemRepeticao(Emprestimo emprestimo){
        emprestimosSemRepeticao.add(emprestimo);
    }

}
