import java.time.LocalDate;

import pessoasPackage.AlunoGraduacao;
import pessoasPackage.FuncionarioBiblioteca;
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

        Perfil perfil2 = Perfil.fromString("ESTUDANTE_GRADUACAO");
        AlunoGraduacao aluno = AlunoGraduacao.criarAlunoGraduacaoComAprovacao("João", LocalDate.now(), 52420,
                "joao@dac.unucamp.com.br", 20, "Rua A 12345", perfil2, 244006, "engenharia", funcionario);

        System.out.println(
                "Nome do aluno: " + aluno.getnome() + " RA do aluno: " + aluno.getra() + "; " + aluno.getdata());

    }
}
