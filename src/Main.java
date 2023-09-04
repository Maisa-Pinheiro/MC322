import java.time.LocalDate;

import emprestimoPackage.Emprestimo;
import multimidiaPackage.LivroFisico;
import pessoasPackage.AlunoGraduacao;
import pessoasPackage.AlunoPosGraduacao;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Professor;
import relatorioPackage.Relatorio;
import renovacaoReservaPackage.Renovacao;
import pessoasPackage.Pessoa.Perfil;

public class Main {
    public static void main(String[] args) {
        /* criando uma instancia de cada tipo de pessoa */

        System.out.println("Exemplos de instâncias de pessoas:\n");
        System.out.println("Funcionario:\n");

        Perfil perfil1 = Perfil.fromString("FUNCIONARIO");
        FuncionarioBiblioteca funcionario = new FuncionarioBiblioteca("Maria", LocalDate.now(), 5430,
                "funcionario@biblioteca.com", 55,
                "Rua BC, 22", perfil1, "Supervisora geral", 10000.00f, "das 8h às 18h", "Administrador");

        System.out.println("Nome do Funcionario: " + funcionario.getnome() + "\n" + "Registro do Funcionario: "
                + funcionario.getregistro() + "\n" + "Contato do Funcionario: " + funcionario.getcontato() + "\n"
                + "Cargo do Funcionario: " + funcionario.getCargo() + "\n");

        System.out.println("Aluno de Graduação: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil2 = Perfil.fromString("ESTUDANTE_GRADUACAO");
        AlunoGraduacao aluno = AlunoGraduacao.criarAlunoGraduacaoComAprovacao("João", LocalDate.now(), 52420,
                "joao@dac.unucamp.com.br", 20, "Rua A 12345", perfil2, 244006, "Engenharia", funcionario);

        System.out.println(
                "Nome do aluno: " + aluno.getnome() + "\n" + "RA do aluno: " + aluno.getra() + "\n");

        System.out.println("Aluno de Pós Graduação: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil3 = Perfil.fromString("ESTUDANTE_POS_GRADUACAO");
        AlunoPosGraduacao alunopos = AlunoPosGraduacao.criarAlunoPosAprovacao("Felipe", LocalDate.now(), 52421,
                "felipe@dac.unucamp.com.br", 20, "Rua A 12345", perfil3, 244007, "Quimica", funcionario);

        System.out.println(
                "Nome do aluno: " + alunopos.getnome() + "\n" + "RA do aluno: " + alunopos.getra() + "\n");

        System.out.println("Professor: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil4 = Perfil.fromString("PROFESSOR");
        Professor professor = Professor.criarProfessorAprovacao("Bruno", LocalDate.now(), 45056, "bruno@dac.unicamp.br",
                38, "Rua Campos Vale 789", perfil4, "IC - Instituto de Computação", funcionario);

        System.out.println(
                "Nome do aluno: " + professor.getnome() + "\n" + "Registro do professor: " + professor.getregistro()
                        + "\n" + "Instituto do professor: " + professor.getInstituto() + "\n");

        System.out.println("Exemplos de instâncias de Multimidia:\n");
        System.out.println("Livro Físico:\n");

        LivroFisico livro = new LivroFisico("Calculo 1", 568, "James Stweart", "Cengage Learning", 1980,
                "Livro de Calculo 1: Limites, Derivadas e Integrais", null, null, true, 1749855545, 0, 0, 10,
                "Estante 4 - Prateleira 2", "Bom");
        System.out.println("Titulo do Livro: " + livro.gettitulo() + "\n" + "Autor do Livro: " + livro.getautor() + "\n"
                + "Registro do Livro: " + livro.getregistro() + "\n" + "ISBN do livro: " + livro.getisbn() + "\n");

        /* Gerando um emprestimo exemplo */
        Emprestimo emprestimo = Emprestimo.criarEmprestimoComAprovacao(0001,
                LocalDate.of(2023, 9, 15), LocalDate.of(2023, 9, 30), 124, funcionario);
        aluno.novoEmprestimo(emprestimo);
        System.out.println("Exemplo de empréstimo:\n");
        System.out.println("Registro: " + emprestimo.getregistro());
        System.out.println("Datade empréstimo: " + emprestimo.getdataEmprestimo());
        System.out.println("Data de devolução: " + emprestimo.getdataDevolucao());
        System.out.println("Multa: " + emprestimo.getmulta());
        System.out.println("\n");

        /* Gerando um exemplo de renovação */
        System.out.println("Exemplo de Renovação:\n");
        Renovacao renovacao = Renovacao.criarRenovacaoAprovacao(true, 1266, alunopos, funcionario);
        System.out.println("Nome do usuário: " + renovacao.getpessoa());
        System.out.println("Tipo de processo(renovação-true/reserva-false): " + renovacao.gettipo());
        System.out.println("Registro: " + renovacao.getregistro());
        renovacao.renovar(emprestimo);
        System.out.println("\n");

        /* Gerando um relatório de exemplo */
        Relatorio relatorio = new Relatorio(1, LocalDate.now());

        LocalDate inicioPeriodo = LocalDate.of(2023, 1, 1);
        LocalDate fimPeriodo = LocalDate.of(2023, 12, 31);

        int emprestimosNoPeriodo = relatorio.contarEmprestimosNoPeriodo(inicioPeriodo, fimPeriodo);
        int devolucoesNoPeriodo = relatorio.contarDevolucoesNoPeriodo(inicioPeriodo, fimPeriodo);
        float multasNoPeriodo = relatorio.calcularMultasNoPeriodo(inicioPeriodo, fimPeriodo);

        System.out.println("Relatório #" + relatorio.getnumeroRelatorio() + " - Data: " + relatorio.getdataRelatorio());
        System.out.println("Total de Empréstimos no Período: " + emprestimosNoPeriodo);
        System.out.println("Total de Devoluções no Período: " + devolucoesNoPeriodo);
        System.out.println("Total de Multas no Período: R$" + multasNoPeriodo);

    }
}
