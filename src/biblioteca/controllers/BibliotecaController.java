package biblioteca.controllers;

import java.util.List;
import java.util.Set;

import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.manutencaoPackage.Manutencao;
import biblioteca.models.emprestimoPackage.*;
import biblioteca.models.pessoasPackage.Pessoa;

public interface BibliotecaController {
    List<Multimidia> consultarItensDisponiveis();

    void emprestarItem(Pessoa membro, Multimidia item)throws BloqueioMembroException;
    //void emprestarItem(Pessoa membro, Multimidia item);

    void reservaritem(Pessoa membro, Multimidia item);

    void renovaremprestimo(Pessoa membro,Emprestimo emprestimo);

    void addmanutencao(Manutencao manutencao);

    void devolverItem(Pessoa membro, Multimidia item, boolean dano) throws BloqueioMembroException;

    void addItemDisponivel(Multimidia item);

    void addemprestimo(Emprestimo emprestimo);

    List<Multimidia> getitensDisponiveis();


    void liberacao(Pessoa pessoa);

    void removerItemDispoinvel(int id);

    void removeremprestimo(int id);

    Multimidia retornaritem(int id);

    Emprestimo retornaremprestimo(int id);
    
    Set<Multimidia.Categoria> getCategoriasUsadas();
}
