package renovacaoReservaPackage;

import java.time.LocalDate;

import pessoasPackage.Pessoa;
import pessoasPackage.AlunoGraduacao;
import pessoasPackage.AlunoPosGraduacao;
import pessoasPackage.Professor;
import pessoasPackage.FuncionarioBiblioteca;
import emprestimoPackage.Emprestimo;
import multimidiaPackage.Multimidia;;


public class Renovacao{ // classe dedicada a renovações e reservas inteligentes
    private boolean tipo; // true - renovação, false- reserva
	private int registro; // registro de identificação renovação ou reserva
	private Pessoa pessoa; // pessoa que está fazendo a renovação ou reserva

	/* construtor dedicado apenas às usuarios */
	private Renovacao(boolean tipo, int registro, Pessoa pessoa) {
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.registro = registro;

	}

	/* getters para os atributos privados */
	public String getpessoa() {
		return pessoa.getnome();
	}

	public boolean gettipo() {
		return tipo;
	}

	public int getregistro() {
		return registro;
	}

	/*
	 * a classe não tem setters pois os atributos não podem ser mudados
	 */

	// renovação

	public void renovar(Emprestimo emprestimo) {
	    LocalDate dataHoje = LocalDate.now();
	    if (pessoa instanceof AlunoGraduacao) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(15);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof AlunoPosGraduacao) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(20);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof Professor) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(30);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else if (pessoa instanceof FuncionarioBiblioteca) {
            if (emprestimo.prazo.isBefore(dataHoje)) {
			System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
		} else {
			emprestimo.prazo= emprestimo.prazo.plusDays(30);
			System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
		}
        } else {
            System.out.println(pessoa.getnome() + " não é um membro da biblioteca, logo, não pode  fazer renovações, favor fazer cadastro");
        }
	    
		
	}

	// reserva
	
	public void reservar(Multimidia item) {
	    if(item.copiadisponivel==true){
	        System.out.println("A cópia desejada do livro está disponivel para empréstimo, não é permitido reservá-la");
	    }else{
            if (item.disponivel > 0) {
			System.out.println("Outras cópias do livro estão disponiveis para empréstimo, não é permitido reservar uma cópia em específico");
		    } else {
			item.disponivel = item.disponivel - 1;
			System.out.println("O livro está reservado para " + pessoa.getnome() + ", o usuário será avisado quando o mesmo puder ser retirado");
		    }
	    }
	}
	
		public static Renovacao criarRenovacaoAprovacao(boolean tipo, int registro, Pessoa pessoa, FuncionarioBiblioteca funcionario) {
        String acess=funcionario.getacesso();
        if ( "Administrador".equals(acess)||"Atendente".equals(acess)) {
            return new Renovacao(tipo, registro, pessoa);
        } else {
            System.out.println("Funcionário não autorizado a criar uma renovação/reserva.");
            return null; // Ou você pode lançar uma exceção se preferir
        }
        }
}