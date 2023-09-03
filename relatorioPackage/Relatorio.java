package relatorioPackage;

import java.time.LocalDate;
import java.util.List; // Importe a classe List
import emprestimoPackage.Emprestimo;
import emprestimoPackage.GerenciadorEmprestimos; // Importe a classe GerenciadorEmprestimos

public class Relatorio {
    // Resto do código

    public int contarEmprestimosNoPeriodo(LocalDate inicio, LocalDate fim) {
        int contador = 0;
        List<Emprestimo> emprestimos = GerenciadorEmprestimos.obterTodosEmprestimos(); // Obtenha a lista de empréstimos
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getdataEmprestimo().isAfter(inicio) && emprestimo.getdataEmprestimo().isBefore(fim)) {
                contador++;
            }
        }
        return contador;
    }

    public int contarDevolucoesNoPeriodo(LocalDate inicio, LocalDate fim) {
        int contador = 0;
        List<Emprestimo> emprestimos = GerenciadorEmprestimos.obterTodosEmprestimos(); // Obtenha a lista de empréstimos
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getdataDevolucao() != null
                    && emprestimo.getdataDevolucao().isAfter(inicio) && emprestimo.getdataDevolucao().isBefore(fim)) {
                contador++;
            }
        }
        return contador;
    }

    public float calcularMultasNoPeriodo(LocalDate inicio, LocalDate fim) {
        float totalMultas = 0.0f;
        List<Emprestimo> emprestimos = GerenciadorEmprestimos.obterTodosEmprestimos(); // Obtenha a lista de empréstimos
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getdataDevolucao() != null
                    && emprestimo.getdataDevolucao().isAfter(inicio) && emprestimo.getdataDevolucao().isBefore(fim)) {
                totalMultas += emprestimo.getmulta();
            }
        }
        return totalMultas;
    }
}
