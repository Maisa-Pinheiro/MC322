package biblioteca.models.recursosMultimidiaPackage;

import java.time.LocalDate;


public class RecursoMultimidia {

    private int id; // número de identificação para o recurso de multimidia
    private String titulo; // titulo do recurso de multimidia
    private String tipo; // qual o tipo de recurso de multimidia
    private String resumo; // um breve resumo sobre o que se trata o recurso de multimidia

    /* construtor da classe externa */

    public RecursoMultimidia(int id, String titulo, String tipo, String resumo) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.resumo = resumo;
    }

    /* getters da classe externa */

    public int getid() {
        return id;
    }

    public String gettitulo() {
        return titulo;
    }

    public String gettipo() {
        return tipo;
    }

    public String getresumo() {
        return resumo;
    }

    /* definição das classes internas */
    public class Audio implements ItemMultimidia {
        private String categoria; // qual a categoria do item de Audio (Ex.: infantil, adulto, estudos, etc.)
        private String programa; // se necessitar, qual é o programa usado para acessar o recurso de Audio
        private LocalDate data; // data de gravação do recurso

        /* construtor da classe interna */

        public Audio(String categoria, String programa, LocalDate data) {
            this.categoria = categoria;
            this.programa = programa;
            this.data = data;
        }

        /* getters da classe interna */

        public String getcategoria() {
            return categoria;
        }

        public String getprograma() {
            return programa;
        }

        public LocalDate getdata() {
            return data;
        }

        @Override
        public String getCategoria() {
            throw new UnsupportedOperationException("Unimplemented method 'getCategoria'");
        }

        @Override
        public String getPrograma() {
            throw new UnsupportedOperationException("Unimplemented method 'getPrograma'");
        }
    }

    public class Video implements ItemMultimidia{
        private String categoria; // qual a categoria do item de Video (Ex.: infantil, adulto, estudos, etc.)
        private String programa; // se necessitar, qual é o programa usado para acessar o recurso de Video
        private String qualidadeImagem; // qualidade da imagem do recurso de video

        /* construtor da classe interna */

        public Video(String categoria, String programa, String qualidadeImagem) {
            this.categoria = categoria;
            this.programa = programa;
            this.qualidadeImagem = qualidadeImagem;
        }

        /* getters da classe interna */

        public String getcategoria() {
            return categoria;
        }

        public String getprograma() {
            return programa;
        }

        public String getqualidadeImagem() {
            return qualidadeImagem;
        }

        @Override
        public String getCategoria() {
            throw new UnsupportedOperationException("Unimplemented method 'getCategoria'");
        }

        @Override
        public String getPrograma() {
            throw new UnsupportedOperationException("Unimplemented method 'getPrograma'");
        }
    }

    public class Software {
        private int licenseNumber; // número de licensa do SW
        private int version; // versão de SW
        private String licenseType; // se a licenca e do tipo perpetua ou se necessita de renovação, ne necessitar
                                    // de renovação qual é a data de renovação
        private String compatibilidade; // qual tipo de sistema operacional e configurações de computador exige o SW

        /* construtor da classe interna */

        public Software(int licenseNumber, int version, String licenseType, String compatibilidade) {
            this.licenseNumber = licenseNumber;
            this.version = version;
            this.licenseType = licenseType;
            this.compatibilidade = compatibilidade;
        }

        /* getters da classe interna */

        public int getlicenseNumber() {
            return licenseNumber;
        }

        public int getversion() {
            return version;
        }

        public String getlicenseType() {
            return licenseType;
        }

        public String getcompatibilidade() {
            return compatibilidade;
        }
    }

    public enum FormatoMultimidia {
        AUDIO,
        VIDEO,
        SOFTWARE
    }
}
