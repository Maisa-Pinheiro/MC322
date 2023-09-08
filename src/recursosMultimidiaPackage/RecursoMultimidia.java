package recursosMultimidiaPackage;

public class RecursoMultimidia {

    /* definição das classes internas */
    public class Audio {
        private int id; // número de identificação para o recurso de multimidia
        private String tipo; // qual o tipo de recurso de audio (ex.: CDs, podcast, gravações e etc)
        private String resumo; // um breve resumo sobre o que se trata o recurso de multimidia

        /* construtor da classe interna */

        public Audio(int id, String tipo, String resumo) {
            this.id = id;
            this.tipo = tipo;
            this.resumo = resumo;
        }

        /* getters da classe interna */

        public int getid(){
            return id;
        }

        public String tipo(){
            return tipo;
        }

        public String resumo(){
            return resumo;
        }
    }

    public class Video {
        private int ID; // número de identificação para o recurso de multimidia
        private String tipo; // qual o tipo de recurso de audio (ex.: CDs, podcast, gravações e etc)
        private String resumo; // um breve resumo sobre o que se trata o recurso de multimidia
    }

}
