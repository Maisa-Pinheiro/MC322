package biblioteca.controllers;

import java.util.List;
import java.util.Set;

import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.renovacaoReservaPackage.Renovacao;
//import biblioteca.models.multimidiaPackage.DVD_Video;
//import biblioteca.models.multimidiaPackage.LivroEletronico;
//import biblioteca.models.multimidiaPackage.LivroFisico;
//import biblioteca.models.multimidiaPackage.Outros;

import biblioteca.models.pessoasPackage.Pessoa;
//import biblioteca.models.pessoasPackage.Professor;
//import biblioteca.models.pessoasPackage.AlunoGraduacao;
//import biblioteca.models.pessoasPackage.AlunoPosGraduacao;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
//import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    List<Multimidia> consultarItensDisponiveis();

    void emprestarItem(Pessoa membro, Multimidia item);

    void devolverItem(Pessoa membro, Multimidia item);
    
    void liberacao(Pessoa pessoa);

    Set<Multimidia.Categoria> getTodasAsCategorias();
    
    Set<String> getCategoriasUsadas();
}
