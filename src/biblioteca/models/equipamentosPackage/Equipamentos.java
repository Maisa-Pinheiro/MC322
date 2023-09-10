package biblioteca.models.equipamentosPackage;

public class Equipamentos {

    private int id; // número de identificação interno para o recurso de multimidia
    private int serialNumber; // número de serie do item
    private String tipo; // qual é o tipo do item (ex.: Informatica, Audio Visual ou impressão)
    private String marca; // marca do item
    private String modelo; // modelo do item
    private String estadoConservacao; // qual é o estado de conservação do item

    /* construtor da classe externa */

    public Equipamentos(int id, int serialNumber, String tipo, String marca, String modelo, String estadoConservacao) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.estadoConservacao = estadoConservacao;
    }

    /* getters da classe externa */

    public int getid() {
        return id;
    }

    public int getserialNumber() {
        return serialNumber;
    }

    public String getmarca() {
        return marca;
    }

    public String getmodelo() {
        return modelo;
    }

    public String gettipo() {
        return tipo;
    }

    public String getestadoConservacao() {
        return estadoConservacao;
    }

    /* definição das classes internas */
    public class Informatica {
        private String acesso; // caso haja alguma restrição no acesso (por exemplo, necessidade de login)
        private String detalhes; // mais detalhes sobre o item de acordo com a nessecidade (Ex.: processador,
                                 // tela, sistema operacional e etc.)

        /* construtor da classe interna */

        public Informatica(String acesso, String detalhes) {
            this.acesso = acesso;
            this.detalhes = detalhes;
        }

        /* getters da classe interna */

        public String getacesso() {
            return acesso;
        }

        public String getdetalhes() {
            return detalhes;
        }
    }

    public class AudioVisual {
        private String descricao; // descrição do item (ex.: câmeras, microfones, caixas de som, etc.)
        private String kit; // se o item faz parte de um kit - quais são os item do kit
        private String conexao; // qual tipo de conexão (bluetoth ou cabo)

        /* construtor da classe interna */

        public AudioVisual(String descricao, String kit, String conexao) {
            this.descricao = descricao;
            this.kit = kit;
            this.conexao = conexao;
        }

        /* getters da classe interna */

        public String getdescricao() {
            return descricao;
        }

        public String getkit() {
            return kit;
        }

        public String conexao() {
            return conexao;
        }
    }

    public class Impressao {
        private String descricao; // descrição do item (ex.: Impressoras, scanners, copiadoras, etc.)
        private String conexao; // qual tipo de conexão (bluetoth ou cabo)
        private String manual; // futuramente pode se atrelar aqui um manual do dispositivo (como conectar-se a
                               // ele, por exemplo)
        private String detalhes; // detalhes adicionais do item

        /* construtor da classe interna */

        public Impressao(String descricao, String conexao, String manual, String detalhes) {
            this.descricao = descricao;
            this.conexao = conexao;
            this.manual = manual;
            this.detalhes = detalhes;
        }

        /* getters da classe interna */

        public String getdescricao() {
            return descricao;
        }

        public String getconexao() {
            return conexao;
        }

        public String getmanual() {
            return manual;
        }

        public String getdetalhes() {
            return detalhes;
        }
    }

    public enum CatogoriaEquipamento {
        INFORMATICA,
        AUDIOVISUAL,
        IMPRESSÃO
    }
}
