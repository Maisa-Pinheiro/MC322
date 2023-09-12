package biblioteca.views;

import java.util.List;

import biblioteca.models.pessoasPackage.Pessoa;

public interface MembroView {
    void mostrarListaMembros(List<Pessoa> membros);
    void mostrarDetalhesMembro(Pessoa membro);
}