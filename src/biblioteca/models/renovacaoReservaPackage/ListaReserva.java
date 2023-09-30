package biblioteca.models.renovacaoReservaPackage;

import java.util.ArrayList;
import java.util.List;

// classe genérica com a lista de reservas, quando for declacar o objeto na main, a pessoa pode escolher se será uma lista de reserva de itens ou de salas
public class ListaReserva<T> {

    private static int proximoId = 1; // Variável estática para rastrear o próximo ID
    private int idReserva; // identificação das reservas
    private List<T> listaReserva = new ArrayList<>(); // lista de reservas

    public ListaReserva() {
        this.idReserva = proximoId++;
    }

    public int getidReserva() {
        return idReserva;
    }

    /* Metodo para adicionar reserva */
    public void addreserva(T reserva) {
        listaReserva.add(reserva);
    }

    /* Metodo para remover reserva */
    public void removereserva(T reserva) {
        listaReserva.remove(reserva);
    }

    /* Metodo para listar reservas */
    public List<T> getlistareserva() {
        return listaReserva;
    }

}
