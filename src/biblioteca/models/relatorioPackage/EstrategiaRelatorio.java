package biblioteca.models.relatorioPackage;

import java.time.LocalDate;

/* Interface para definir métodos que todas as estratégias de relatório devem implementar */

public interface EstrategiaRelatorio {
    int contarEventosNoPeriodo(LocalDate inicio, LocalDate fim);
    float calcularTotalNoPeriodo(LocalDate inicio, LocalDate fim);
}