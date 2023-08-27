/*pacote que contem apenas a classe de relatórios */

package classesRelatorio;

import java.time.LocalDate;
import classesObras.Multimidia;
import classesPessoas.Membro;
import classesFuncionarios.Funcionarios;
import classesRenovacaoReserva.Renovacao;
import classesEmprestimo.Emprestimo;


/*
 * classe dedicada apenas aos relatorios
 */
 
public class Relatorio {
	private Multimidia[] acervo; // todos os itens de emprestimo que a biblioteca possui
	private Membros[] membros; // todos os membros da biblioteca que podem fazer empréstimos
	private Funcionarios[] funcionarios; // todos os funcionarios da biblioteca
	private Emprestimos[] emprestimo; // todos os emprestimos feitos pela biblioteca
	private LocalDate data; //data de emissão do relatório
	private int numero; // numero do relatório
	private RenovacaoReserva[] renovacoes;// todas as renovações e reservas feitas
	

	/* construtor dedicado apenas aos usuarios */
	public Relatorio(LocalDate data, int numero) {
		this.data = data;
		this.numero = numero;
	
	}

	/* getters para os atributos privados */
	public String getdata() {
		return data;
	}

	public int getnumero() {
		return numero;
	}

	/*
	 * a classe não possui setters pois os atributos não podem ser modificados(seria outro relatótio)
	 */
	 
	 /*métodos para a emissão do relatótio*/
	 
	 // quantidade de empréstimos em atraso e total de multas devidas
	 
	 public void EmprestimosAtrasados() {
        int count = 0;
        float totalMultas= 0.00;
        int totalemprestimos = 0;
        LocalDate hoje = LocalDate.now();

        for (Emprestimos emprestimo : emprestimo) {
            LocalDate devolucao = emprestimo.getdevolucao();
            if (devolucao.isBefore(hoje)) {
                count++;
                totalMultas += emprestimo.getmulta();
            }
            if(emprestimo!=null){
                totalemprestimos++;
            }
        }

        String multaformatada = String.format("%.2f", totalMultas);

        System.out.println("Atualmente existem "+ totalemprestimos + " empréstimos na biblioteca, dos quais " + count + " estão em atraso, totalizando R$" + multaformatada + " em multas.");
    }
    
    // total de membros
    public void membros(){
        int qdtmembros=0;
        for( Membro membro : membros){
            if(membros[i]!=null){
                qdtmembros++;
            }
        }
        System.out.println("Atualmente existem " + qdtmembros + " membros na biblioteca.");
    }
    public void funcionarios(){
        int qdtfuncionarios=0;
        for( Funcionarios funcionario : funcionarios){
            if(funcionarios[i]!=null){
                qdtfuncionarios++;
            }
        }
        System.out.println("Atualmente existem " + qdtfuncionarios + " funcionarios na biblioteca.");
    }
    
    
    //total de itens para empréstimo
    public void qtdlivros(){
        int qdtitens=0;
        int qdtdisponível=0;
        for( Multimidia acervo : acervo){
            if(acervo[i]!=null){
                qdtitens= qdtitens + acervo[i].copias;
                qdtdisponivel = qdtdisponivel + acervo[i].disponivel;
            }
        }
        System.out.println("Atualmente existem " + qdtitens + " itens multimídia na biblioteca, dos quais " + qdtdisponivel + " estão disponíveis para empréstimo.");
    }
    
    
    //total de renovações e reservas
    public void reservas(){
        int qdtreservas=0;
        int qdtrenovacoes=0;
        for( RenovacaoReserva renovacao : renovacoes){
            if(renovacoes[i].getreserva()==true){
                qdtreservas++;
            }else if(renovacoes[i].getreserva()==false){
                qdtrenovacoes++;
            }
        }
        System.out.println("Até o presente dia foram feitas " + qdtreservas + " reservas e "+ qdtrenovacoes + " renovações na biblioteca.");
    }
    
    

	
}

