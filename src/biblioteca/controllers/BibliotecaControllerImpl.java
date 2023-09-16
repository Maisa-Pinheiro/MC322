package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Multimidia.Categoria> categoriasusadas; /* categorias de itens presentes na biblioteca, o enum categoria
    possui todas as categorias possíveis, mas este atributo reúne as categorias de livros que estão na biblioteca
    pode não ter nenhum item de certa categoria do enum, por exempo*/
    

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
        this.categoriasusadas = new HashSet<>();
        inicializarCategorias();
    }
    @Override
    private void inicializarCategorias() {
        for (Multimidia item : itens) {
            categorias.add(multimidia.getCategoria());
        }
    }

    @Override
    public Set<Multimidia.Categoria> getTodasAsCategorias() {
        return todasAsCategorias;
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

    @Override
    public Set<String> getcategoriasusadas(){
        return categoriasusadas;
    }
}
