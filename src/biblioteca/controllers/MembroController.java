package biblioteca.controllers;

import java.util.List;

import biblioteca.models.pessoasPackage.Pessoa;
//import biblioteca.models.pessoasPackage.Professor;
//import biblioteca.models.pessoasPackage.AlunoGraduacao;
//import biblioteca.models.pessoasPackage.AlunoPosGraduacao;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
//import biblioteca.views.MembroView;

public interface MembroController {
    List<Pessoa> listarMembros();
    Pessoa buscarMembroPorIdentificacao(int registro);
    void addMembro(Pessoa pessoa);
}