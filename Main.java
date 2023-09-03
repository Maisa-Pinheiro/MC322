import java.time.LocalDate;

import pessoasPackage.AlunoGraduacao;
import pessoasPackage.AlunoPosGraduacao;
import pessoasPackage.FuncionarioBiblioteca;
import pessoasPackage.Professor;
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
        Professor professor = Professor.criarProfessorAprovacao("Bruno", LocalDate.now(), 45056, "bruno@dac.unicamp.br", 38, "Rua Campos Vale 789", perfil4, "IC - Instituto de Computação", funcionario);

        System.out.println(
                "Nome do aluno: " + professor.getnome() + "\n" + "Registro do professor: " + professor.getregistro() + "\n" + "Instituto do professor: " + professor.getInstituto() + "\n");

    }
}
