package biblioteca.controllers;

import java.util.List;
import java.util.Scanner;

import biblioteca.models.CReflectionPackage.CReflection;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.views.RelatorioView;

public class RelatorioControllerImpl implements RelatorioController {

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
    public void chamarmetodo(Scanner scanner, BibliotecaController biblioteca, MembroController membro){
        CReflection reflection = new CReflection();
        System.out.println("Escolha uma classe:");
        System.out.println("1.Membros");
        System.out.println("2.Multimidia");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if(opcao == 1){
            System.out.println("Escolha um método:");
            reflection.listMethods(Pessoa.class);
            String metodo = scanner.nextLine();
            List<Multimidia> lista = biblioteca.consultarItensDisponiveis();
            Object objeto = lista.get(0);
            reflection.invokeMethod(objeto, metodo);
            
        }else if(opcao == 2){
            System.out.println("Escolha um método:");
            reflection.listMethods(Multimidia.class);
            String metodo = scanner.nextLine();
            List<Pessoa> lista= membro.listarMembros();
            Object objeto = lista.get(0);
            reflection.invokeMethod(objeto,metodo);
        }

    }
    // Lógica para geração de relatórios
}