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
	private Membro[] membros; // todos os membros da biblioteca que podem fazer empréstimos
	private Funcionarios[] funcionarios; // todos os funcionarios da biblioteca
	private Emprestimo[] emprestimo; // todos os emprestimos feitos pela biblioteca
	private LocalDate data; //data de emissão do relatório
	private int numero; // numero do relatório
	private Renovacao[] renovacoes;// todas as renovações e reservas feitas
	

	/* construtor dedicado apenas aos usuarios */
	public Relatorio(LocalDate data, int numero) {
		this.data = data;
		this.numero = numero;
	
	}

	/* getters para os atributos privados */
	public LocalDate getdata() {
		return data;
	}

	public int getnumero() {
		return numero;
	}

	
	 
	 /*métodos para a emissão do relatótio*/
	 
	 // quantidade de empréstimos em atraso e total de multas devidas
	 
	 public void EmprestimosAtrasados() {
        int count = 0;
        float totalMultas= 0;
        int totalemprestimos = 0;
        LocalDate hoje = LocalDate.now();

        for (Emprestimo emprestimo : emprestimo) {
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
            if(membro!=null){
                qdtmembros++;
            }
        }
        System.out.println("Atualmente existem " + qdtmembros + " membros na biblioteca.");
    }
    public void funcionarios(){
        int qtdfuncionarios=0;
        for( Funcionarios funcionario : funcionarios){
            if(funcionario!=null){
                qtdfuncionarios++;
            }
        }
        System.out.println("Atualmente existem " + qtdfuncionarios + " funcionarios na biblioteca.");
    }
    
    
    //total de itens para empréstimo
    public void qtdlivros(){
        int qtditens=0;
        int qtddisponivel=0;
        for( Multimidia acervos : acervo){
            if(acervos!=null){
                qtditens= qtditens + acervos.copias;
                qtddisponivel = qtddisponivel + acervos.disponivel;
            }
        }
        System.out.println("Atualmente existem " + qtditens + " itens multimídia na biblioteca, dos quais " + qtddisponivel + " estão disponíveis para empréstimo.");
    }
    
    
    //total de renovações e reservas
    public void reservas(){
        int qtdreservas=0;
        int qtdrenovacoes=0;
        for( Renovacao renovacao : renovacoes){
            if(renovacao.gettipo()==true){
                qtdreservas++;
            }else if(renovacao.gettipo()==false){
                qtdrenovacoes++;
            }
        }
        System.out.println("Até o presente dia foram feitas " + qtdreservas + " reservas e "+ qtdrenovacoes + " renovações na biblioteca.");
    }
    
 }

