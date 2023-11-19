package biblioteca.models.relatorioPackage;

import java.time.LocalDate;
import java.util.List;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.emprestimoPackage.GerenciadorEmprestimos;

public class EmprestimosRelatorio implements EstrategiaRelatorio {
    @Override
    public int contarEventosNoPeriodo(LocalDate inicio, LocalDate fim) {
        int contador = 0;
        List<Emprestimo> emprestimos = GerenciadorEmprestimos.obterTodosEmprestimos();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getdataEmprestimo().isAfter(inicio) && emprestimo.getdataEmprestimo().isBefore(fim)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public float calcularTotalNoPeriodo(LocalDate inicio, LocalDate fim) {
        // EmprestimosRelatorio não precisa calcular multas, então retorna 0
        return 0;
    }
}
