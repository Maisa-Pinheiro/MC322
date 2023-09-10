package biblioteca.controllers;

import java.util.ArrayList;
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

public class BibliotecaControllerImpl implements BibliotecaController {
    private List<Multimidia> itens;

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
    }

    @Override
    public List<Multimidia> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(Pessoa membro, Multimidia item) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverItem(Pessoa membro, Multimidia item) {
        // Lógica de devolução
        return true;
    }
}