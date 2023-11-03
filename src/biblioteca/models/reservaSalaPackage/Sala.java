package biblioteca.models.reservaSalaPackage;

import java.util.ArrayList;
import java.util.List;

/* Classe para controle das salas da biblioteca */

public class Sala {
    private String nomeSala;
    private int idSala;
    private String localSala;
    private static List<Sala> listaSalas;

    public Sala(String nomeSala, int idSala, String localSala) {
        this.nomeSala = nomeSala;
        this.idSala = idSala;
        this.localSala = localSala;

        if (listaSalas == null) {
            Sala.listaSalas = new ArrayList<>();
        }
    }

    /* get metodos */

    public String getnomeSala() {
        return nomeSala;
    }

    public int getidSala() {
        return idSala;
    }

    public String getlocalSala() {
        return localSala;
    }

    /* set metodos */

    public void setnomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public void setlocalSala(String localSala) {
        this.localSala = localSala;
    }

    /* Metodo para adicionar sala a lista */
    public static void addSala(Sala sala) {
        int idsala = sala.getidSala();
        for (Sala salas : listaSalas) {
            if (salas.getidSala() == idsala) {
                System.out.println(
                        "Erro: Não é possivel adicionar essa sala a lista, pois já existe uma sala com o mesmo ID");
                return;
            }
        }
        listaSalas.add(sala);
    }

    /* Metodo para retornar a lista de salas */
    public static List<Sala> listarSalas() {
        return listaSalas;
    }

}
