package biblioteca.controllers;

import java.util.List;
import java.util.Scanner;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.views.RelatorioView;

public interface RelatorioController {
    void gerarRelatorioAtividadesMembros(RelatorioView view);
    void gerarRelatorioUsoItens(RelatorioView view);
    void addhistorico(Emprestimo emprestimo);
    List<Emprestimo> gethistoricoEmprestimo();
    void gerarRelatorioMultas(RelatorioView view);
    void gerarRelatorioDisponibilidadeItens(RelatorioView view);
    void gerarEstatisticasUsoPorPerfil(RelatorioView view);
    void gerarRelatorioItensPopulares(RelatorioView view);
    void chamarmetodo(Scanner scanner, BibliotecaController biblioteca, MembroController membro);
}