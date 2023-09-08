package recursosMultimidiaPackage;

public class RecursoMultimidia {

    /* definição das classes internas */
    public class Audio {
        private int id; // número de identificação para o recurso de multimidia
        private String titulo; // titulo do recurso de multimidia
        private String tipo; // qual o tipo de recurso de audio (ex.: CDs, podcast, gravações e etc)
        private String resumo; // um breve resumo sobre o que se trata o recurso de multimidia

        /* construtor da classe interna */

        public Audio(int id, String titulo, String tipo, String resumo) {
            this.id = id;
            this.titulo = titulo;
            this.tipo = tipo;
            this.resumo = resumo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public String gettitulo() {
            return titulo;
        }

        public String tipo() {
            return tipo;
        }

        public String resumo() {
            return resumo;
        }
    }

    public class Video {
        private int id; // número de identificação para o recurso de
        private String titulo; // titulo do recurso de multimidia
        private String tipo; // qual o tipo de recurso de audio (ex.: CDs, podcast, gravações e etc)
        private String resumo; // um breve resumo sobre o que se trata o recurso de multimidia

        /* construtor da classe interna */

        public Video(int id, String titulo, String tipo, String resumo) {
            this.id = id;
            this.titulo = titulo;
            this.tipo = tipo;
            this.resumo = resumo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public String gettitulo() {
            return titulo;
        }

        public String tipo() {
            return tipo;
        }

        public String resumo() {
            return resumo;
        }
    }

    public class Software {
        private int id; // número de identificação do SW
        private int licenseNumber; // número de licensa do SW
        private String titulo; // "nome" do SW
        private String tipo; // qual o tipo de SW (ex.: SW educacionais, programa de simulação, CAD e etc)
        private String resumo; // um breve resumo sobre o que se trata e para que serve o SW

        /* construtor da classe interna */

        public Software(int id, int licenseNumber, String titulo, String tipo, String resumo) {
            this.id = id;
            this.licenseNumber = licenseNumber;
            this.titulo = titulo;
            this.tipo = tipo;
            this.resumo = resumo;
        }

        /* getters da classe interna */

        public int getid() {
            return id;
        }

        public int getlicenseNumber() {
            return licenseNumber;
        }

        public String gettitulo() {
            return titulo;
        }

        public String tipo() {
            return tipo;
        }

        public String resumo() {
            return resumo;
        }
    }

    public enum FormatoMultimidia {
        AUDIO,
        VIDEO,
        SOFTWARE
    }
}
