/*pacote que contem apenas a classe de  funcionarios */

package classesFuncionarios;

/*
 * classe dedicada apenas aos funcionários, os atributos publicos são os que mudam
 * com frequência e podem ser acessados por outras classes sem necessidade de
 * getters e setters
 */
public class Funcionarios {
	private String nome;
	private int cpf;
	private int registro;
	public String cargo; // cargo do funcionário( bibliotecário, gerente, segurança, equipe de limpeza)

	private String acesso; /*
							 * nivel de acesso aos sistemas( Consulta(somente visualizar informações sobre
							 * itens de emprestimo),
							 * Adm acervo(modificar informaçoes sobre itens de emprestimo),
							 * Adm emprestimo e renovacao(modificar emprestimos e renovações),
							 * Adm geral(modificar todos os dados))
							 */

	private float salario;
	public int idade;
	private String endereco;

	/* construtor dedicado apenas aos funcionarios */
	public Funcionarios(String nome, int cpf, int registro, float salario, String cargo, String acesso, int idade,
			String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
		this.salario = salario;
		this.cargo = cargo;
		this.acesso = acesso;
		this.idade = idade;
		this.endereco = endereco;

	}

	public Funcionarios(String nome2, int cpf2, int registro2, double d, String cargo2, String acesso2, int idade2,
			String endereco2) {
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

	public String getacesso() {
		return acesso;
	}

	public float getsalario() {
		return salario;
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

	public void setsalario(float salario) {
		this.salario = salario;
	}

	public void setacesso(String acesso) {
		this.acesso = acesso;
	}
}
