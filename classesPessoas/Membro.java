/*pacote que contem apenas as classes de pessoas: aluno, porfessor e funcionario */

package classesPessoas;

import classesObras.Multimidia;

/*
 * classe dedicada apenas aos membros, considerando que tanto alunos e professores como funcionários podem
 * emprestar livrod, os atributos publicos são os que mudam
 * com frequência e podem ser acessados por outras classes sem necessidade de
 * getters e setters
 */
public class Membro {
	private String nome;
	private int cpf;
	private int registro;
	public int emprestimo; // quantos livros o usuario tem emprestado
	private String categoria; // aluno grad, aluno pos, funcionário ou professor
	public String prazo; // prazo de devolucao
	public int atraso; // o numero de atraso em dias
	public int idade; // idade do usuario
	private String endereco; 

	/* construtor dedicado apenas aos usuarios */
	public Membro(String nome, int cpf, int registro, int emprestimo, String categoria, String prazo, int atraso, int idade,
			String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.emprestimo = emprestimo;
		this.categoria = categoria;
		this.prazo = prazo;
		this.atraso = atraso;
		this.idade = idade;
		this.endereco = endereco;
	
		
	}

	/* getters para os atributos privados */
	public String getnome() {
		return nome;
	}

	public int getcpf() {
		return cpf;
	}

	public int getregistro() {
		return registro;
	}

	public String getendereco() {
		return endereco;
	}
	public String getcategoria() {
		return categoria;
	}


	/*
	 * setters dos atributos que não mudam com frequência(atributos que não serão
	 * mudados não tem setter)
	 */
	public void setnome(String nome) {
		this.nome = nome;
	}

	public void setcpf(int cpf) {
		this.cpf = cpf;
	}

	public void setendereco(String endereco) {
		this.endereco = endereco;
	}
	

	
	
}
