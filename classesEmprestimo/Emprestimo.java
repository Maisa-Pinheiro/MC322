/*pacote que contem apenas a clase de empréstimos */


// fazer método para atribuir os livros às pessoas
package classesEmprestimo;

import java.time.LocalDate;
import classesObras.Multimidia;
import classesPessoas.Membros;

/*
 * classe dedicada apenas os empréstimos, os atributos publicos são os que mudam
 * com frequência e podem ser acessados por outras classes sem necessidade de
 * getters e setters
 */
public class Emprestimo {
	private Membro pessoa; // pessoa que fez o emprestimo
  private int numero; // numero de registro do emprestimo na base de dados
	private Multimidia[] itens_empres;// vetor que guarda os itens emprestados pelo usuário
	private LocalDate retirada; // data de retirada dos itens
  private LocalDate devolucao; // data de devolução dos itens
  private int prazo; // prazo em dias
	public boolean bloqueio; // membro pode ou nao fazer empréstimos


	/* construtor dedicado apenas aos usuarios */
	public Emprestimo(Membro pessoa,int numero, LocalDate retirada, int prazo, boolean bloqueio) {
		this.pessoa = pessoa;
    this.numero = numero;
		this.retirada = retirada;
		this.prazo = prazo;
		this.devolucao = retirada.plusDays(prazo);
		this.categoria = categoria;
		this.prazo = prazo;
		this.bloqueio = bloqueio;
		this.itens_empres = new Multimidia[5];
	}

	/* getters para os atributos privados */
	public String getpessoa() {
		return pessoa.getnome();
	}

	public int getnumero() {
		return numero;
	}

	public int getretirada() {
		return retirada;
	}

	public String getdevolucao() {
		return devolucao;
	}
	public String getprazo() {
		return prazo;
	}
	
 	 public String getbloqueio() {
		return bloqueio;
	}

	/*
	 * não possui setter pois os itens privados não serão mudados(seria outro empréstimo)
	 */
	
	/*
	 * implementação de um metodo para emprestar livros a um usuario(pode ser
	 * considerado um setter?)
	 */
	

	/* método para mostrar quais livros a pessoa emprestou */
	public void ItensEmprestados() {
		System.out.println("Itens emprestados para o usuário " + pessoa.getnome() + ":");
		for (Multimidia livro : itens_empres) {
			if (livro != null) {
				System.out.println("- " + livro.gettitulo());
			}
		}
	}

  
	public void emprestarItem(Multimidia livro) {
		for (int i = 0; i < 5; i++) {
			if (itens_empres[i] == null) {
				itens_empres[i] = livro;
				return;
			}
		}
		System.out.println("O usuário " + pessoa.getnome() + " atingiu o limite de empréstimos.");
	}

	/* método para mostrar quais livros a pessoa emprestou */
	public void ItensEmprestados() {
		System.out.println("Itens emprestados para o usuário " + nome + ":");
		for (Multimidia livro : itens_empres) {
			if (livro != null) {
				System.out.println("- " + livro.gettitulo());
			}
		}
	}
	public void qtsItens() {
	    int a=0;
		for (int i = 0; i < 5; i++) {
			if (itens_empres[i] != null) {
				a= a + 1;
			}
			
		}
		System.out.println("O usuário " + nome + " emprestou " + a + " itens.");
	}
	// calcular atraso
	public int atraso() {
        LocalDate hoje = LocalDate.now();
        long diasAtraso = ChronoUnit.DAYS.between(devolucao, hoje);
        
        return Math.max(0, diasAtraso); // Retorna 0 se não houver atraso
    }
	// calcular multa
	public void getmulta(){
		// para os primeiros 5 dias, a multa é de R$0,50,
		// para os dias de 6 a 10, a multa é de R$ 1,00,
		// para os demais dias, a multa é de  R$ 2,00
		int atraso= atraso();
		int multa=0;
		if(atraso>0 && atraso<=5){
		    multa= atraso/2;
		}else if( atraso<=10){
		    multa= (5/2) + (atraso - 5);
		}else{
		    multa = (5/2) + 5 + (atraso-10)*2;
		}
}

