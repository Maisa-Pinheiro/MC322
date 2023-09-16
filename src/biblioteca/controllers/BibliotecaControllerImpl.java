package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
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
    public void emprestarItem(Pessoa membro, Multimidia item) {
        int qtddisponivel = item.getnumCopiasDisponiveis();

        if(qtddisponivel>0){
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), item, membro);
            item.numCopiasDisponiveis--;
            membro.novoEmprestimo(emprestimo);
        System.ou.println("o item foi emprestado com sucesso");
        }else{
            Renovacao reserva = new Renovacao(false, membro);
            reserva.reservar(item);
            System.ou.println("o item foi reservado com sucesso");
            
        }
    }

    @Override
    public void devolverItem(Pessoa membro, Multimidia item) {
        for (Emprestimo emprestimo : membro.getemprestimos()) {
                if (emprestimo.getMultimidia().equals(item)) {
                    int prazo= emprestimo.getdataDevolucao();
                    LocalDate today = Localdate.now();
                    if(prazo.isbefore(today)){
                        int atraso= ChronoUnit.DAYS.between(today,prazo);
                        
                        membro.setpodemeprestar(false);
                        emprestimo.setmulta(atraso);
                        System.out.println("O membro devolveu o empréstimo com atraso, logo, não pode fazer empréstimos pelos próximos 20 dias, devendo pedir a liberação ao final desse prazo, junto ao pagamento da multa, de R$ " + emprestimo.getmulta());
                         membro.removeremprestimo(emprestimo); 
                        break;
                    } else{
                        membro.removeremprestimo(emprestimo);
                        if(item.listareservas.size==0){
                            item.numCopiasDisponiveis++;
                            System.ou.println("O item foi devolvido com sucesso e emprestado ao membro ");
                    }else{
                            emprestarItem(listareservas.get(0).getpessoa(), item);
                    }
                    System.ou.println("O item foi devolvido com sucesso e emprestado ao membro " +  listareservas.get(0).getpessoa().getnome());  
                    break;
                    }
        }
        }
        
    }

    @Override
    public Set<String> getcategoriasusadas(){
        return categoriasusadas;
    }
}
