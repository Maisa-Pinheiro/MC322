package biblioteca.models.renovacaoReservaPackage;

import biblioteca.models.reservaSalaPackage.*;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.pessoasPackage.*;

// classe genérica com a lista de reservas, quando for declacar o objeto na main, a pessoa pode escolher se será uma lista de reserva de itens ou de salas
public class ListaReserva<T>
{

    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int idReserva; // identificação das reservas
    private List<T> listaReserva = new ArrayList<>(); // lista de reservas

    public ListaReserva() {
        this.idReserva = proximoId++;
    }

    public int getidReserva() {
        return idReserva;
    }

    public void addreserva(T reserva){
        listaReserva.add(reserva);
    }

    public void removereserva(T reserva){
        listaReserva.remove(reserva);
    }
    

    public List<T> getlistareserva(){
        return listaReserva;
    }
    
}
