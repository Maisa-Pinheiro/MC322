package biblioteca.views;

import java.util.List;

import biblioteca.models.multimidiaPackage.Multimidia;

public interface BibliotecaView {
    void mostrarItensDisponiveis(List<Multimidia> itens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}