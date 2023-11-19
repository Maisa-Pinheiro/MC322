package biblioteca.models.relatorioPackage;

import java.time.LocalDate;
import java.util.List;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.emprestimoPackage.GerenciadorEmprestimos;

public class MultasRelatorio implements EstrategiaRelatorio {
    @Override
    public int contarEventosNoPeriodo(LocalDate inicio, LocalDate fim) {
        // MultasRelatorio não precisa contar eventos, então retorna 0
        return 0;
    }

    @Override
    public float calcularTotalNoPeriodo(LocalDate inicio, LocalDate fim) {
        float totalMultas = 0.0f;
        List<Emprestimo> emprestimos = GerenciadorEmprestimos.obterTodosEmprestimos();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getdataDevolucao() != null
                    && emprestimo.getdataDevolucao().isAfter(inicio) && emprestimo.getdataDevolucao().isBefore(fim)) {
                totalMultas += emprestimo.getmulta();
            }
        }
        return totalMultas;
    }
}
