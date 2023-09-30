package biblioteca.controllers;

import java.util.List;
import java.util.Set;

import biblioteca.models.multimidiaPackage.Multimidia;
//import biblioteca.models.multimidiaPackage.DVD_Video;
//import biblioteca.models.multimidiaPackage.LivroEletronico;
//import biblioteca.models.multimidiaPackage.LivroFisico;
//import biblioteca.models.multimidiaPackage.Outros;
import biblioteca.models.emprestimoPackage.*;
import biblioteca.models.equipamentosPackage.Equipamentos;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.manutencaoPackage.Manutencao;
//import biblioteca.models.pessoasPackage.Professor;
//import biblioteca.models.pessoasPackage.AlunoGraduacao;
//import biblioteca.models.pessoasPackage.AlunoPosGraduacao;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
//import biblioteca.views.BibliotecaView;
import biblioteca.models.reservaSalaPackage.ReservaSala;

public interface BibliotecaController {
    List<Multimidia> consultarItensDisponiveis();

    void emprestarItem(Pessoa membro, Multimidia item)throws BloqueioMembroException;
    //void emprestarItem(Pessoa membro, Multimidia item);

    void reservaritem(Pessoa membro, Multimidia item);

    void reservarEquipamento(Equipamentos equipamento);

    void reservarSala(ReservaSala sala);

    void renovaremprestimo(Pessoa membro,Emprestimo emprestimo);

    void devolverItem(Pessoa membro, Multimidia item, boolean dano) throws ItemDanificadoException;

    void addItemDisponivel(Multimidia item);

    void addemprestimo(Emprestimo emprestimo);

     void addmanutencao(Manutencao manutencao);

    void liberacao(Pessoa pessoa);

    void removerItemDispoinvel(int id);

    void removeremprestimo(int id);

    Multimidia retornaritem(int id);

    Emprestimo retornaremprestimo(int id);
    
    Set<Multimidia.Categoria> getCategoriasUsadas();
}
