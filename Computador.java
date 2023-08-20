/*pacote destinado apenas a classe computador, pois essa classe não se encaixa em nenhuma das outras*/

package classeComputadores;

/*classe dedicada apenas aos computadores da biblioteca*/
public class Computador {
	private String local; // onde está o computador(andar, seção)
	private int registro;
	private String login; // nome de usuário
	private String senha;
	private int tempo; // quanto tempo ele pode ser utilizado por pessoa
	public boolean disponivel; // verdadeiro ou falso para a disponibilidade do computador para uso

	/*construtor dedicado apenas aos Computadores*/
	public Computador(String local, int registro, String login, String senha, int tempo, boolean disponivel) {
		this.local = local;
		this.registro = registro;
		this.login = login;
		this.senha = senha;
		this.tempo = tempo;
		this.disponivel = disponivel;
	}
	
	/*getters para os atributos privados*/
	public String getlocal() {
		return local;
	}

	public String getlogin() {
		return login;
	}

	public int getregistro() {
		return registro;
	}

	public String getsenha() {
		return senha;
	}

	public int gettempo() {
		return tempo;
	}
	
	/*setters para os atributos que não mudam com frequência(atributos que não mudam não tem setter)*/

	public void setlogin(String login) {
		this.login = login;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	public void settempo(int tempo) {
		this.tempo = tempo;
	}
}
