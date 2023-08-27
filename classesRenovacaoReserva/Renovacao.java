/*pacote que contem apenas a classe de reservas e renovações */

package classesRenovacaoReserva;

import classesObras.Multimidia;
import classesPessoas.Membros;
import classesEmprestimo.Emprestimo;

/*
 * classe dedicada apenas aos processos de renovação e reservas
 */
public class Renovacao {
	private boolean tipo; // true - renovação, false- reserva
	private int registro; // registro da renovação ou reserva
	private Membro pessoa; //pessoa que está fazendo a renovação ou reserva
	
	
	/* construtor dedicado apenas aos usuarios */
	public Renovacao(Membro pessoa, boolean tipo, int registro) {
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

	/*
	 * a classe não tem setters pois os atributos não podem ser mudados
	 */


	// renovação
	
	public void renovar(Emprestimo emprestimo){
	    if(emprestimo.bloqueio==false){
	        System.out.println("O usuário " + pessoa.getnome() + " não pode renovar o empréstimo " + emprestimo.getnumero() + " pois o mesmo está em atraso.");
	    }else{
	        emprestimo.setprazo();
	        System.out.println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo " + emprestimo.getnumero() + " aumentado em 5 dias.");
	    }
	}
	
	//reserva
	
	public void reservar(Multimidia item){
	    if(item.disponivel>0){
	        System.out.println("O livro está disponivel para empréstimo, não é permitido reservar");
	    }else{
	        item.disponivel=item.disponivel - 1;
	        System.out.println("O livro está reservado, o usuário será avisado quando o mesmo puder ser retirado");
	    }
	}
	
}
