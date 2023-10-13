package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.pessoasPackage.Pessoa;

public class MembroControllerImpl implements MembroController {
    private List<Pessoa> membros;

    public MembroControllerImpl() {
        membros = new ArrayList<>();
    }

    @Override
    public List<Pessoa> listarMembros() {
        return Pessoa.listarPessoas();
    }

    @Override
    public Pessoa buscarMembroPorIdentificacao(int registro) {
        for (Pessoa membro : membros) {
            if (membro.getid() == registro) {
                return membro; // Retorna a pessoa encontrada
            }
        }
        return null; // Retorna null se a pessoa não for encontrada
    }

    @Override
    /* metodo para adicionar novo membro a lista */
    public void addMembro(Pessoa pessoa) {
        Pessoa.addPessoa(pessoa);
        membros = Pessoa.listarPessoas();
    }
}
