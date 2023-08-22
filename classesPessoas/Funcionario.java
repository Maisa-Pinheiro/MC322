package classesPessoas;


/* classe dedicada apenas aos funcionarios */
public class Funcionario {
	private String nome;
	private int cpf;
	private int registro;
	private String horario; // horário de entrada e de saída do funcionário
	private String cargo; // cargo do Funcionarios
	private int salario;
	public int idade; // idade do funcionario
	private String endereco;

	/* construtor dedicado apenas aos funcionários */
	public Funcionario(String nome, int cpf, int registro, String horario, String cargo, int salario, int idade,
			String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.horario = horario;
		this.cargo = cargo;
		this.salario = salario;
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

	public String gethorario() {
		return horario;
	}

	public String getcargo() {
		return cargo;
	}

	public int getsalario() {
		return salario;
	}

	public String getendereco() {
		return endereco;
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

	public void sethorario(String horario) {
		this.horario = horario;
	}

	public void setcargo(String cargo) {
		this.cargo = cargo;
	}

	public void setsalario(int salario) {
		this.salario = salario;
	}

	public void setendereco(String endereco) {
		this.endereco = endereco;
	}
}