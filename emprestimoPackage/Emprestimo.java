package emprestimoPackage;

import java.time.LocalDate;

import multimidiaPackage.Multimidia;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Pessoa;
import pessoasPackage.Pessoa.Perfil;

public class Emprestimo {
    private int registro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private float multa;
    private static Multimidia multimidia;
    private static Pessoa pessoa;

    /* construtor privado, pois só administradores podem criar */
    private Emprestimo(int registro, LocalDate dataEmprestimo, LocalDate dataDevolucao, float multa,
            Multimidia multimidia, Pessoa pessoa) {
        this.registro = registro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        Emprestimo.multimidia = multimidia;
        Emprestimo.pessoa = pessoa;
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

    public Multimidia getMultimidia() {
        return multimidia;
    }

    public Pessoa getpessoa() {
        return pessoa;
    }

    /* condições para criar um emprestimo */
    public static Emprestimo criarEmprestimoComAprovacao(int registro, LocalDate dataEmprestimo,
            LocalDate dataDevolucao, float multa,
            FuncionarioBiblioteca funcionario) {
        String acesso = funcionario.getacesso();
        Perfil perfil = pessoasPackage.Pessoa.getperfil();

        // Verifique se o usuário tem acesso de "Administrador" ou "Atendente"
        if ("Administrador".equals(acesso) || "Atendente".equals(acesso)) {
            // Verifique o perfil do usuário
            switch (perfil) {
                case ESTUDANTE_GRADUACAO:
                    // Lógica específica para estudantes de graduação
                    // Por exemplo:
                    int limiteEmprestimoEstudanteGraduacao = 3;
                    if (pessoasPackage.AlunoGraduacao.contarEmprestimos() >= limiteEmprestimoEstudanteGraduacao) {
                        System.out.println("Limite de empréstimos para estudantes de graduação atingido.");
                        return null;
                    }
                    break;

                case ESTUDANTE_POS_GRADUACAO:
                    // Lógica específica para estudantes de pós-graduação
                    // Por exemplo:
                    int limiteEmprestimoEstudantePosGraduacao = 5;
                    if (pessoasPackage.AlunoPosGraduacao.contarEmprestimos() >= limiteEmprestimoEstudantePosGraduacao) {
                        System.out.println("Limite de empréstimos para estudantes de pós-graduação atingido.");
                        return null;
                    }
                    break;

                case PROFESSOR:
                    // Lógica específica para professores
                    // Por exemplo:
                    int limiteEmprestimoProfessor = 7;
                    if (pessoasPackage.Professor.contarEmprestimos() >= limiteEmprestimoProfessor) {
                        System.out.println("Limite de empréstimos para professores atingido.");
                        return null;
                    }
                    break;

                case FUNCIONARIO:
                    // Lógica específica para funcionários
                    // Por exemplo:
                    int limiteEmprestimoFuncionario = 4;
                    if (pessoasPackage.FuncionarioBiblioteca.contarEmprestimos() >= limiteEmprestimoFuncionario) {
                        System.out.println("Limite de empréstimos para funcionários atingido.");
                        return null;
                    }
                    break;

                default:
                    // havera outros perfis? como limitar o numero de emprestimos deles?
                    break;
            }

            // Se passar por todas as verificações, crie o empréstimo
            Emprestimo emprestimo = new Emprestimo(registro, dataEmprestimo, dataDevolucao, multa, multimidia, pessoa);
            GerenciadorEmprestimos.adicionarEmprestimo(emprestimo); // Adicione o empréstimo à lista
            return emprestimo;
        } else {
            // Caso contrário, execute o seguinte bloco de código.
            System.out.println("Funcionário não autorizado a criar um empréstimo.");
            return null; // Retorne null 
        }
    }
}