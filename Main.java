//package Main;

import java.time.LocalDate;

import classesEmprestimo.Emprestimo;
import classesFuncionarios.Funcionarios;
import classesObras.Multimidia;
import classesPessoas.Membro;
import classesRelatorio.Relatorio;
//import classesRenovacaoReserva.Renovacao;

public class Main {
    public static void main(String[] args) {

        // Criando um usuário (Membro)
        Membro membro = new Membro("Maria", 123456789, 3698, 5, "Aluno de graduação", null, false, 25,
                "Rua Jose de Alencar, 123");
        System.out.println("Informações sobre o membro:");
        System.out.println(membro.getnome() + "; " + membro.getcpf() + "; " + membro.getregistro() + "; "
                + membro.emprestimo + "; " + "; " + membro.getatraso() + "; " + membro.getidade() + "; "
                + membro.getendereco());
        System.out.println();

        // Criando dois exemplos de Multimidia
        Multimidia cd = new Multimidia("Pagodes", "Turma do Pagode", 123, "Gravadora", 2023, "Música", 3, 3, "CD");
        Multimidia livro = new Multimidia("O poder do hábito", "Charles Duhingg", 456, "Objetiva", 2012, "Livro", 10, 7,
                "Livro Fisico");

        // Criando um empréstimo e emprestando o CD ao usuário
        // Esse é um exemplo de aplicações de gregação onde um usuário pode ter mais que
        // um objeto de emprestimo, conceito de "um para muitos"
        Emprestimo emprestimo = new Emprestimo(membro, 1, LocalDate.now(), 7, false);
        emprestimo.emprestarItem(cd);
        emprestimo.emprestarItem(livro);

        // Imprimindo os itens emprestados pelo usuário
        emprestimo.ItensEmprestados();
        System.out.println();

        // Exemplo de objeto da classe funcionário
        Funcionarios funcionario = new Funcionarios("Paulo Luiz", 123456, 12345, 1000, "Bibliotecário", "Geral", 25,
                "Rua Benedito Correia");
        System.out.println("Informações sobre o funcionario:");
        System.out.println(funcionario.getnome() + "; " + funcionario.getcpf() + "; " + funcionario.getregistro() + "; "
                + funcionario.getsalario() + "; " + funcionario.cargo + "; " + funcionario.getacesso());
        System.out.println();

        // Criando um objeto exemplo de relatório
        System.out.println("Informações sobre o relatório:");
        Relatorio relatorio = new Relatorio(LocalDate.now(), 1);
        System.out.println("Relatório emitido em: " + relatorio.getdata());
        System.out.println("Número do relatório: " + relatorio.getnumero());

        // objetos de exemplo para o relatório
        // um exemplo de Multimidia
        Multimidia dvd = new Multimidia("Turma da Monica", "Mauricio de Souza", 3504, "Turma da Monica", 1980,
                "Infantil", 40, 30, "DVD");
        relatorio.addItem(dvd);
        relatorio.qtdlivros();
        // dois exemplos de membros
        Membro user1 = new Membro("Carlos Alberto", 24815238, 1259, 2, "Estudante", null, false, 21,
                "Rua Olavio de Carvalho 123");
        Membro user2 = new Membro("Fabiana Santos", 24815238, 1259, 2, "Estudante", null, false, 17,
                "Rua Olavio de Carvalho 123");
        relatorio.addMembro(user1);
        relatorio.addMembro(user2);
        relatorio.membro();
        // um exemplo de funcionario
        Funcionarios func1 = new Funcionarios("Lucas Sampaio", 4567845, 24589, 1.500, "Auxiliar de Limpeza", "Consulta",
                32, "Rua Antonio Silveira 587");
        relatorio.addFuncionario(func1);
        relatorio.funcionarios();
        // um exemplo de renovação
        // Renovacao Renov = new Renovacao(false, 123, user1);
        // relatorio.addRenovacao(Renov);
        // relatorio.reservas();
        // exemplo de emprestimo
        // relatorio.addEmprestimo(emprestimo);
        // relatorio.EmprestimosAtrasados();
    }
}
