package biblioteca.models.relatorioPackage;

import java.time.LocalDate;

public class Relatorio {
    private int numeroRelatorio;
    private LocalDate dataRelatorio;
    private EstrategiaRelatorio estrategia;

    public Relatorio(int numeroRelatorio, LocalDate dataRelatorio, EstrategiaRelatorio estrategia) {
        this.numeroRelatorio = numeroRelatorio;
        this.dataRelatorio = dataRelatorio;
        this.estrategia = estrategia;
    }

    public int getnumeroRelatorio() {
        return numeroRelatorio;
    }

    public LocalDate getdataRelatorio() {
        return dataRelatorio;
    }

    public int contarEventosNoPeriodo(LocalDate inicio, LocalDate fim) {
        return estrategia.contarEventosNoPeriodo(inicio, fim);
    }

    public float calcularTotalNoPeriodo(LocalDate inicio, LocalDate fim) {
        return estrategia.calcularTotalNoPeriodo(inicio, fim);
    }
}
