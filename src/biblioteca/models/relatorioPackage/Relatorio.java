package biblioteca.models.relatorioPackage;

import java.time.LocalDate;
import java.util.List; // Importe a classe List
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.emprestimoPackage.GerenciadorEmprestimos; // Importe a classe GerenciadorEmprestimos


/*ainda não foram implementadas todas as funcionalidades nessa classe */
public class Relatorio {

    private int numeroRelatorio; // número sequencial para controle de geração de relatórios
    private LocalDate dataRelatorio; // data em que o relatório foi gerado

    public Relatorio(int numeroRelatorio, LocalDate dataRelatorio){
        this.numeroRelatorio = numeroRelatorio;
        this.dataRelatorio = dataRelatorio;
    }

    public int getnumeroRelatorio(){
        return numeroRelatorio;
    }
    
    public LocalDate getdataRelatorio(){
        return dataRelatorio;
    }


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
