package biblioteca.controllers;

import java.util.List;

import biblioteca.models.multimidiaPackage.Multimidia;
//import biblioteca.models.multimidiaPackage.CD_Audio;
//import biblioteca.models.multimidiaPackage.Capa;
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

    boolean emprestarItem(Pessoa membro, Multimidia item);

    boolean devolverItem(Pessoa membro, Multimidia item);
}