package equipamentosPackage;

public class Equipamentos {

    /* definição das classes internas */
    public class Informatica {
        private int id; // número de identificação para o recurso de multimidia
        private int serialNumber; // número de serie do item
        private String tipo; // qual é o tipo do item (ex.: computadores, tablets, projetores, etc.)

        /* construtor da classe interna */

        public Informatica(int id, int serialNumber, String tipo) {
            this.id = id;
            this.serialNumber = serialNumber;
            this.tipo = tipo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public int getserialNumber() {
            return serialNumber;
        }

        public String tipo() {
            return tipo;
        }
    }

    public class AudioVisual {
        private int id; // número de identificação para o recurso de multimidia
        private int serialNumber; // número de serie do item
        private String tipo; // qual é o tipo do item (ex.: câmeras, microfones, caixas de som, etc.)

        /* construtor da classe interna */

        public AudioVisual(int id, int serialNumber, String tipo) {
            this.id = id;
            this.serialNumber = serialNumber;
            this.tipo = tipo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public int getserialNumber() {
            return serialNumber;
        }

        public String tipo() {
            return tipo;
        }
    }

    public class Impressao {
        private int id; // número de identificação para o recurso de multimidia
        private int serialNumber; // número de serie do item
        private String tipo; // qual é o tipo do item (ex.: Impressoras, scanners, copiadoras, etc.)

        /* construtor da classe interna */

        public Impressao(int id, int serialNumber, String tipo) {
            this.id = id;
            this.serialNumber = serialNumber;
            this.tipo = tipo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public int getserialNumber() {
            return serialNumber;
        }

        public String tipo() {
            return tipo;
        }
    }

    public enum CatogoriaEquipamento {
        INFORMATICA,
        AUDIOVISUAL,
        IMPRESSÃO
    }
}
