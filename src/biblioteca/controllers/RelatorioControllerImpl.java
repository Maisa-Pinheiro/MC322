package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.models.CReflectionPackage.CReflection;
import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.views.RelatorioView;

public class RelatorioControllerImpl implements RelatorioController {
    private List<Emprestimo> historicoEmprestimo; 

    public void RelatorioController(){
        this.historicoEmprestimo = new ArrayList<>();
    }

    @Override
    public void addhistorico(Emprestimo emprestimo){
        historicoEmprestimo.add(emprestimo);
    }

    @Override
    public List<Emprestimo> gethistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    @Override
    public void gerarRelatorioAtividadesMembros(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioAtividadesMembros'");
    }

    @Override
    public void gerarRelatorioUsoItens(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioUsoItens'");
    }

    @Override
    public void gerarRelatorioMultas(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioMultas'");
    }

    @Override
    public void gerarRelatorioDisponibilidadeItens(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioDisponibilidadeItens'");
    }

    @Override
    public void gerarEstatisticasUsoPorPerfil(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarEstatisticasUsoPorPerfil'");
    }

    @Override
    public void gerarRelatorioItensPopulares(RelatorioView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioItensPopulares'");
    }
    @Override
    public void chamarmetodo(Scanner scanner, BibliotecaController biblioteca, MembroController membro) {
    CReflection reflection = new CReflection();
    System.out.println("Escolha uma classe:");
    System.out.println("1.Multimidia");
    System.out.println("2.Membros");
    int opcao = scanner.nextInt();
    scanner.nextLine();
    if (opcao == 1) {
        System.out.println("Escolha um método:");
        List<Multimidia> lista = biblioteca.consultarItensDisponiveis();
        if (!lista.isEmpty()) {
            Object objeto = lista.get(0);
            reflection.listMethods(objeto.getClass()); // Obtém a classe do primeiro elemento da lista
            String metodo = scanner.nextLine();
            Object resultado = reflection.invokeMethod(objeto, metodo);
            System.out.println("Resultado do método: " + resultado); // Exibe o resultado
        } else {
            System.out.println("A lista de itens multimídia está vazia.");
        }
    } else if (opcao == 2) {
        System.out.println("Escolha um método:");
        List<Pessoa> lista = membro.listarMembros();
        if (!lista.isEmpty()) {
            Object objeto = lista.get(0);
            reflection.listMethods(objeto.getClass()); // Obtém a classe do primeiro elemento da lista
            String metodo = scanner.nextLine();
            Object resultado = reflection.invokeMethod(objeto, metodo);
            System.out.println("Resultado do método: " + resultado); // Exibe o resultado
        } else {
            System.out.println("A lista de membros está vazia.");
        }
    }
}

    
    
    
    // Lógica para geração de relatórios
}