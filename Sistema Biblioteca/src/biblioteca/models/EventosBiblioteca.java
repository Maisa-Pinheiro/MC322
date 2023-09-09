package eventosPackage;

import java.time.LocalTime;
import java.time.LocalDate;

public class EventosBiblioteca {
    private int id; // número de identificação da palestra
    public String local; // local da palestra

    public EventosBiblioteca(int id, String local){
        this.id = id;
        this.local = local;
    }

    public int getid(){
        return id;
    }
    public String getlocal(){
        return local;
    }

    /* definição das classes internas */
    public class Palestra {//atributos públicos estão sujeitos à possíveis mudanças
        
        private String palestrante; // nome do palestrante
        private String topico; // tema principal da palestra
        public LocalTime hora; // horario de inicio da palestra
        private int duracao; // duração, em horas, da palestra
        public LocalDate data; // data da palestra

        /* construtor da classe interna */

        public Palestra( String palestrante, String topico, LocalTime hora, int duracao, LocalDate data) {
            this.palestrante = palestrante;
            this.topico = topico;
            this.hora = hora;
            this.duracao = duracao;
            this.data = data;
        }

        /* getters dos atributos privados classe interna, eles não possuem setters pois, se mudasses, seria outra palestra */

      

        public String getpalestrante() {
            return palestrante;
        }

        public String gettopico() {
            return topico;
        }

        public int getduracao() {
            return duracao;
        }
    }

    public class Workshop {//atributos públicos estão sujeitos à possíveis mudanças
    
        private String instrutor; // nome do instrutor
        private String topico; // tema principal do workshop
        public LocalTime hora; // horario de inicio do workshop
        private int duracao; // duração, em horas, do workshop
        public LocalDate data; // data do workshop
        private String materiaisNecessarios; // materiais necessários para a realização do workshop

        /* construtor da classe interna */

        public Workshop( String instrutor, String topico,  LocalTime hora, int duracao, LocalDate data, String materiaisNecessarios) {
            this.instrutor = instrutor;
            this.topico = topico;
            this.hora = hora;
            this.duracao = duracao;
            this.data = data;
            this.materiaisNecessarios = materiaisNecessarios;
        }

        /* getters dos atributos privados classe interna, eles não possuem setters pois, se mudasses, seria outro workshop */

        public String getinstrutor() {
            return instrutor;
        }

        public String gettopico() {
            return topico;
        }

        public int getduracao() {
            return duracao;
        }
        public String getmateriais() {
            return materiaisNecessarios;
        }
    }

    public class Exposicao {//atributos públicos estão sujeitos à possíveis mudanças
        private String expositor; // nome da empresa ou das pessoas responsáveis pela exposição
        private String topico; // tema principal da exposição
        public LocalTime horainicio; // horario de inicio da exposição
        public LocalTime horafim; // horario de encerramento da exposição
        public int duracao; // duração, em dias, da exposição
        public LocalDate data; // data da exposição
        private String detalhes; // detalhes sobre o tema

        /* construtor da classe interna */

        public Exposicao( String expositor, String topico, LocalTime horainicio , LocalTime horafim, int duracao, LocalDate data, String detalhes) {
            this.expositor = expositor;
            this.topico = topico;
            this.horainicio = horainicio;
            this.horafim = horafim;
            this.duracao = duracao;
            this.data = data;
            this.detalhes = detalhes;
        }

        /* getters dos atributos privados classe interna, eles não possuem setters pois, se mudasses, seria outro workshop */

        public String getexpositor() {
            return expositor;
        }

        public String gettopico() {
            return topico;
        }

        public String getdetalhes() {
            return detalhes;
        }
        
    }

    public enum TipoDeEvento {
        PALESTERA,
        WORKSHOP,
        EXPOSICAO
    }
}
