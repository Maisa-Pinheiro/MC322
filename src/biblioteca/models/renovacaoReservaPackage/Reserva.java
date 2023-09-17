package biblioteca.models.renovacaoReservaPackage;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.multimidiaPackage.Multimidia;

public class Reserva {

    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int idReserva; // identificação das reservas
    private static List<Reserva> listaReserva = new ArrayList<>(); // lista de reservas
    private Multimidia multimidiaReserva; // mutimidia que será reservada

    public Reserva(Multimidia multimidiaReserva) {
        this.idReserva = proximoId++;
        this.multimidiaReserva = multimidiaReserva;
        listaReserva.add(this); 
    }

    public int getidReserva() {
        return idReserva;
    }

    public Multimidia getmultimidiaReserva() {
        return multimidiaReserva;
    }
    
}
