import java.time.LocalDate;
import java.time.LocalTime;

import emprestimoPackage.Emprestimo;
import multimidiaPackage.LivroFisico;
import pessoasPackage.AlunoGraduacao;
import pessoasPackage.AlunoPosGraduacao;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Professor;
import relatorioPackage.Relatorio;
import renovacaoReservaPackage.Renovacao;
import pessoasPackage.Pessoa.Perfil;
import eventosPackage.EventosBiblioteca;
import reservaSalaPackage.ReservaSala;

public class Main {
    public static void main(String[] args) {
        /* criando uma instancia de cada tipo de pessoa */

        System.out.println("Exemplos de instâncias de pessoas:\n");
        System.out.println("Funcionario:\n");

        Perfil perfil1 = Perfil.FUNCIONARIO;
        FuncionarioBiblioteca funcionario = new FuncionarioBiblioteca("Maria", LocalDate.now(), 5430,
                        "funcionario@biblioteca.com", 55,
                        "Rua BC, 22", perfil1, "Supervisora geral", 10000.00f, "das 8h às 18h",
                        "Administrador");

        System.out.println("Nome do Funcionario: " + funcionario.getnome() + "\n" + "Registro do Funcionario: "
                        + funcionario.getregistro() + "\n" + "Contato do Funcionario: "
                        + funcionario.getcontato() + "\n"
                        + "Cargo do Funcionario: " + funcionario.getCargo() + "\n");

        System.out.println(
                        "Aluno de Graduação: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil2 = Perfil.ESTUDANTE_GRADUACAO;
        AlunoGraduacao aluno = AlunoGraduacao.criarAlunoGraduacaoComAprovacao("João", LocalDate.now(), 52420,
                        "joao@dac.unucamp.com.br", 20, "Rua A 12345", perfil2, 244006, "Engenharia",
                        funcionario);

        System.out.println(
                        "Nome do aluno: " + aluno.getnome() + "\n" + "RA do aluno: " + aluno.getra() + "\n");

        System.out.println(
                        "Aluno de Pós Graduação: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil3 = Perfil.ESTUDANTE_POS_GRADUACAO;
        AlunoPosGraduacao alunopos = AlunoPosGraduacao.criarAlunoPosAprovacao("Felipe", LocalDate.now(), 52421,
                        "felipe@dac.unucamp.com.br", 20, "Rua A 12345", perfil3, 244007, "Quimica",
                        funcionario);

        System.out.println(
                        "Nome do aluno: " + alunopos.getnome() + "\n" + "RA do aluno: " + alunopos.getra()
                                        + "\n");

        System.out.println("Professor: (criado por um funcionario com o tipo de acesso administrador)\n");
        Perfil perfil4 = Perfil.PROFESSOR;
        Professor professor = Professor.criarProfessorAprovacao("Bruno", LocalDate.now(), 45056,
                        "bruno@dac.unicamp.br",
                        38, "Rua Campos Vale 789", perfil4, "IC - Instituto de Computação", funcionario);

        System.out.println(
                        "Nome do aluno: " + professor.getnome() + "\n" + "Registro do professor: "
                                        + professor.getregistro()
                                        + "\n" + "Instituto do professor: " + professor.getInstituto() + "\n");

        System.out.println("Exemplos de instâncias de Multimidia:\n");
        System.out.println("Livro Físico:\n");

        LivroFisico livro = new LivroFisico("Calculo 1", 568, "James Stweart", "Cengage Learning", 1980,
                        "Livro de Calculo 1: Limites, Derivadas e Integrais", null, null, true, 1749855545, 0,
                        0, 10,
                        "Estante 4 - Prateleira 2", "Bom");
        System.out.println("Titulo do Livro: " + livro.gettitulo() + "\n" + "Autor do Livro: "
                        + livro.getautor() + "\n"
                        + "Registro do Livro: " + livro.getregistro() + "\n" + "ISBN do livro: "
                        + livro.getisbn() + "\n");

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

        System.out.println("Relatório #" + relatorio.getnumeroRelatorio() + " - Data: "
                        + relatorio.getdataRelatorio());
        System.out.println("Total de Empréstimos no Período: " + emprestimosNoPeriodo);
        System.out.println("Total de Devoluções no Período: " + devolucoesNoPeriodo);
        System.out.println("Total de Multas no Período: R$" + multasNoPeriodo);
        
        EventosBiblioteca eventos = new EventosBiblioteca();

        // Criar um objeto Palestra
        EventosBiblioteca.Palestra palestra = eventos.new Palestra(
            1, "Palestrante 1", "Tópico da Palestra 1",
            "Local da Palestra 1", LocalTime.of(9, 0),
            2, LocalDate.of(2023, 9, 10)
        );

        // Exibir informações da Palestra
        System.out.println("Informações da Palestra:");
        System.out.println("ID: " + palestra.getid());
        System.out.println("Palestrante: " + palestra.getpalestrante());
        System.out.println("Tópico: " + palestra.gettopico());
        System.out.println("Local: " + palestra.local);
        int tempo1 =palestra.getduracao();
        LocalTime horafim1 = palestra.hora.plusHours(tempo1);
        System.out.println("Horário: das " + palestra.hora + " às " + horafim1);
        System.out.println("Data: " + palestra.data);

        // Criar um objeto Workshop
        EventosBiblioteca.Workshop workshop = eventos.new Workshop(
            2, "Instrutor 1", "Tópico do Workshop 1",
            "Local do Workshop 1", LocalTime.of(14, 0),
            3, LocalDate.of(2023, 9, 11), "Materiais Necessários para o Workshop 1"
        );

        // Exibir informações do Workshop
        System.out.println("\nInformações do Workshop:");
        System.out.println("ID: " + workshop.getid());
        System.out.println("Instrutor: " + workshop.getinstrutor());
        System.out.println("Tópico: " + workshop.gettopico());
        System.out.println("Local: " + workshop.local);
        int tempo =workshop.getduracao();
        LocalTime horafim = workshop.hora.plusHours(tempo);
        System.out.println("Horário: das " + workshop.hora + " às " + horafim);
        System.out.println("Data: " + workshop.data);
        System.out.println("Materiais Necessários: " + workshop.getmateriais());

        // Criar um objeto Exposicao
        EventosBiblioteca.Exposicao exposicao = eventos.new Exposicao(
            3, "Expositor 1", "Tópico da Exposição 1",
            "Local da Exposição 1", LocalTime.of(10, 0),
            LocalTime.of(17, 0), 2, LocalDate.of(2023, 9, 12), "Detalhes da Exposição 1"
        );

        // Exibir informações da Exposicao
        System.out.println("\nInformações da Exposição:");
        System.out.println("ID: " + exposicao.getid());
        System.out.println("Expositor: " + exposicao.getexpositor());
        System.out.println("Tópico: " + exposicao.gettopico());
        System.out.println("Local: " + exposicao.local);
        System.out.println("Horário: das " + exposicao.horainicio + " às " +  exposicao.horafim);
        LocalDate fim = exposicao.data.plusDays(exposicao.duracao);
        System.out.println("De: " + exposicao.data + " à " + fim);
        System.out.println("Detalhes: " + exposicao.getdetalhes());
        
        ReservaSala reserva = new ReservaSala(
            1, LocalDate.of(2023, 9, 10),
            LocalTime.of(9, 0), 2
        );



        // Criar um objeto SalaIndividual
        ReservaSala.SalaIndividual salaIndividual = reserva.new SalaIndividual(
            101, true
        );

        // Exibir informações da Reserva
        System.out.println("\nInformações da ReservaSala (SalaIndividual):");
        System.out.println("ID da Reserva: " + reserva.getid());
        System.out.println("Data da Reserva: " + reserva.getdata());
        System.out.println("Hora de Início: " + reserva.gethoraInicio());
        System.out.println("Duração: " + reserva.getduracao() + " horas");
        System.out.println("Informações da SalaIndividual: Número da Sala - " + salaIndividual.getnumsala() + " / Computador Disponível- " + salaIndividual.getcomputadorDisponivel());

    }
}
