/*pacote destinado apenas a classe main*/

package classeMain;

import classesPessoas.Usuario;
import classesPessoas.Funcionario;
import classesPessoas.Visitante;
import classesObras.Cd;
import classesObras.Livro;
import classesObras.Revista;
import classesObras.Academico;
import classeComputadores.Computador;

public class Main {
	public static void main(String[] args) {
		/*criando os objetos exemplo de livros e imprimindo*/
		Livro livro1 = new Livro("Harry Potter", "JK Rowling", 1234, "Rocco", 1, "fantasia", 3, 3);
		System.out.println("Informacoes do livro:\n");
		System.out.println(livro1.gettitulo() + "; " + livro1.getautor() + "; " + livro1.getregistro() + "; "
				+ livro1.geteditora() + "; " + livro1.getedicao() + "; " + livro1.getcategoria() + "; " + livro1.copias
				+ "; " + livro1.disponivel);
		System.out.println("\n");

		/* criando os objetos exemplo de usuários e imprimindo */
		Usuario pessoa = new Usuario("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
		System.out.println("Informacoes do usuario:\n");
		System.out.println(pessoa.getnome() + "; " + pessoa.getcpf() + "; " + pessoa.getregistro() + "; "
				+ pessoa.emprestimo + "; " + pessoa.prazo + "; " + pessoa.atraso + "; " + pessoa.idade + "; "
				+ pessoa.getendereco());
		System.out.println("\n");

		/* criando os objetos exemplo de funcionarios e imprimindo */
		Funcionario trabalhador1 = new Funcionario("Karl", 895456789, 7898, "7h30 as 17h15", "Bibliotecario", 3000, 27,
				"Avenida Marechal Rondon, 13");
		System.out.println("Informacoes do funcionario:\n");
		System.out.println(trabalhador1.getnome() + "; " + trabalhador1.getcpf() + "; " + trabalhador1.getregistro()
				+ "; " + trabalhador1.gethorario() + "; " + trabalhador1.getcargo() + "; " + trabalhador1.getsalario()
				+ "; " + trabalhador1.idade + "; " + trabalhador1.getendereco());
		System.out.println("\n");

		/* criando os objetos exemplo de CDs/DVDs e imprimindo */
		Cd dvd1 = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010, true);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(dvd1.getnome() + "; " + dvd1.gettipo() + "; " + dvd1.getregistro() + "; " + dvd1.getautor()
				+ "; " + dvd1.getano() + "; " + dvd1.disponivel);
		System.out.println("\n");

		/* criando os objetos exemplo de Computadores */
		Computador comp1 = new Computador("3AA", 9988, "biblioteca01", "comp9988", 1, true);
		System.out.println("Informacoes do Computador:\n");
		System.out.println(comp1.getlocal() + "; " + comp1.getregistro() + "; " + comp1.getlogin() + "; "
				+ comp1.getsenha() + "; " + comp1.gettempo() + "; " + comp1.disponivel);
		System.out.println("\n");

		/* criando os objetos exemplo de revistas */
		Revista revista1 = new Revista("automotivo", 5006, "Auto Esporte", "Globo", "janeiro de 2023", true);
		System.out.println("Informacoes da Revista:\n");
		System.out.println(revista1.getnome() + "; " + revista1.getcategoria() + "; " + revista1.getregistro() + "; "
				+ revista1.geteditora() + "; " + revista1.getedicao() + "; " + revista1.disponivel);
		System.out.println("\n");

		/* criando os objetos exemplo de Acadêmicos */
		Academico acad = new Academico("Ginástica Laboral: Um meio para a Promoção da Qualidade de Vida", 5336,
				"Poliana Carvalho", "universidade Estadual de Campinas", true);
		System.out.println("Informacoes do CD ou DVD:\n");
		System.out.println(acad.gettitulo() + "; " + acad.getautor() + "; " + acad.getregistro() + "; "
				+ acad.getinstituicao() + "; " + acad.disponivel);
		System.out.println("\n");

		/* criando os objetos exemplo de visitantes */
		Visitante vis1 = new Visitante("Av Bruxelas, 1", 22, "Marcos", 555889994);
		System.out.println("Informacoes do Visitante:\n");
		System.out.println(vis1.getnome() + "; " + vis1.getidade() + "; " + vis1.getendereco() + "; " + vis1.getcpf());
		System.out.println("\n");

		/*teste dos setters*/
		System.out.println("Mudança de senha do computador:\n");
		comp1.setsenha("comp1senhanova");
		System.out.println("Informacoes do Computador:\n");
		System.out.println(comp1.getlocal() + "; " + comp1.getregistro() + "; " + comp1.getlogin() + "; "
				+ comp1.getsenha() + "; " + comp1.gettempo() + "; " + comp1.disponivel);
		System.out.println("\n");

		/*empréstimo de livros ao usuário*/

		pessoa.emprestarLivro(livro1);
		pessoa.livrosEmprestados();

	}
}
