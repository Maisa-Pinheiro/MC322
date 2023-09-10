package reservaSalaPackage;

import java.time.LocalTime;
import java.time.LocalDate;

public class ReservaSala {
    private int id;// numero de identificação de reserva da sala
    private LocalDate data;
    private LocalTime horaInicio;
    private int duracao;

     public ReservaSala( int id, LocalDate data, LocalTime horaInicio, int duracao) {
            this.id = id;
            this.data = data;
            this.horaInicio = horaInicio;
            this.duracao =duracao;
            
        }

    public int getid() {
        return id;
    }
    public LocalDate getdata() {
        return data;
    }

    public LocalTime gethoraInicio() {
        return horaInicio;
    }

    public int getduracao() {
        return duracao;
    }

    /* definição das classes internas */
    public class SalaIndividual {
        private int numsala; // numero da sala
        private boolean  computadorDisponivel; // a sala tem ou não um computador disponível
      
        

        /* construtor da classe interna */

        public SalaIndividual( int numsala, boolean computadorDisponivel) {
            this.numsala = numsala;
            this.computadorDisponivel = computadorDisponivel;
            
        }

        /* getters dos atributos privados classe interna, eles não possuem setters pois, se mudasses, seria outra palestra */

        public int getnumsala() {
            return numsala;
        }

        public boolean getcomputadorDisponivel() {
            return computadorDisponivel;
        }
        
    }

    public class SalaGrupo {//atributos públicos estão sujeitos à possíveis mudanças
        private int capacidade; // capacidade maxima de pessoas
        private int numsala; // numero da sala
        private boolean  apresentacao; // a sala tem ou não equipamento de apresentação disponível
      
        

        /* construtor da classe interna */

        public SalaGrupo(int capacidade,  int numsala, boolean apresentacao) {
            this.capacidade = capacidade;
            this.numsala = numsala;
            this.apresentacao = apresentacao;
            
        }

        /* getters dos atributos privados classe interna */

        public int getnumsala() {
            return numsala;
        }

         public int getcapacidade() {
            return capacidade;
        }

        public boolean getapresentacao() {
            return apresentacao;
        }
        
    }

    public class SalaSilenciosa {//atributos públicos estão sujeitos à possíveis mudanças
       
        private int assentos; // capacidade maxima de pessoas/numero de assentos
        private int numsala; // numero da sala
        private boolean  cabines; // a sala tem ou não cabines individuais
      
        

        /* construtor da classe interna */

        public SalaSilenciosa(int assentos,  int numsala, boolean cabines) {
            this.assentos = assentos;
            this.numsala = numsala;
            this.cabines = cabines;
            
        }

        /* getters dos atributos privados classe interna */

        public int getnumsala() {
            return numsala;
        }

         public int getassentos() {
            return assentos;
        }

        public boolean getcabines() {
            return cabines;
        }
        
    }

   public class SalaMultimidia {//atributos públicos estão sujeitos à possíveis mudanças
    private int capacidade; // capacidade maxima de pessoas
    private int numsala; // numero da sala
    private int computadores;//quantidade de computadores disponíveis para uso
    private boolean apresentacao; // a sala tem ou não equipamento de apresentação disponível
    private String recursos; // quais recursos multimidia adicionais a Sala tem

    /* construtor da classe interna */
    public SalaMultimidia(int capacidade, int numsala, int computadores, boolean apresentacao, String recursos) {
        this.capacidade = capacidade;
        this.numsala = numsala;
        this.computadores = computadores;
        this.apresentacao = apresentacao;
        this.recursos = recursos;
    }

    /* getters dos atributos privados classe interna */

    public int getcapacidade() {
        return capacidade;
    }

    public int getnumsala() {
        return numsala;
    }

    public int getcomputadores() {
        return computadores;
    }

    public boolean getapresentacao() {
        return apresentacao;
    }

    public String getrecursos() {
        return recursos;
    }
}
    public enum StatusReserva {
        PENDENTE,
        CONFIRMADA,
        CANCELADA
    }
}