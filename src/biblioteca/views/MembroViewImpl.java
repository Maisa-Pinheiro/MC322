package biblioteca.views;

import java.util.List;

import biblioteca.controllers.MembroController;
import biblioteca.models.pessoasPackage.Pessoa;

public class MembroViewImpl implements MembroView {
    private MembroController membroController;

    public MembroViewImpl(MembroController controller) {
        membroController = controller;
    }

    @Override
    public void mostrarListaMembros(List<Pessoa> membros) {
        for (Pessoa pessoa : membros) {
            System.out.println(pessoa.getnome() + " " + pessoa.getid() + " " + pessoa.getperfil());
            System.out.println("\n");
        }
    }

    @Override
    public void mostrarDetalhesMembro(Pessoa membro) {
        // Implementação da exibição dos detalhes de um membro
    }
}
