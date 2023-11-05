package biblioteca.controllers;

import java.util.Scanner;

import biblioteca.views.RelatorioView;

public interface RelatorioController {
    void gerarRelatorioAtividadesMembros(RelatorioView view);
    void gerarRelatorioUsoItens(RelatorioView view);
    void gerarRelatorioMultas(RelatorioView view);
    void gerarRelatorioDisponibilidadeItens(RelatorioView view);
    void gerarEstatisticasUsoPorPerfil(RelatorioView view);
    void gerarRelatorioItensPopulares(RelatorioView view);
    void chamarmetodo(Scanner scanner, BibliotecaController biblioteca, MembroController membro);
}