package biblioteca.models.CReflectionPackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import biblioteca.models.emprestimoPackage.Emprestimo;
import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.reservaSalaPackage.Sala;

public class CReflection {

    /* Listando e imprimindo os metodos */
    public static void listMethods(Class<?> classe) {
        /* Tratamento de tryCatch */
        try {
            Method[] metodos = classe.getDeclaredMethods();

            /* Vefiricando se a classe possui algum metodo */
            if (metodos.length == 0) {
                throw new listMethodsException("A classe não possui metodos disponiveis.\n");
            }

            /* Se houver metodos disponiveis, imprime eles */
            else {
                System.out.println("\nMétodos da classe " + classe.getSimpleName() + ":");
                for (Method metodo : metodos) {
                    System.out.println(metodo.getName());
                }
                System.out.println("\n");
            }
        } catch (listMethodsException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    /* Listando e imprimindo os atributos */
    public static void listFields(Class<?> classe) {
        /* Tratamento de tryCatch */
        try {
            Field[] campos = classe.getDeclaredFields();

            /* Vefiricando se a classe possui algum metodo */
            if (campos.length == 0) {
                throw new listFieldsException("A classe não possui atributos disponiveis.\n");
            }
            /* Se houver atributos disponiveis, imprime eles */
            else {
                System.out.println("\nAtributos da classe " + classe.getSimpleName() + ":");
                for (Field campo : campos) {
                    System.out.println(campo.getName());
                }
                System.out.println("\n");
            }
        } catch (listFieldsException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    /* Utilização do metodo invoke para instanciar um objeto em tempo de execução */
    public Object invokeMethod(Object objeto, String methodName) {
        try {
            // Obtém o método com base no nome fornecido
            Method method = objeto.getClass().getDeclaredMethod(methodName);
    
            // Invoca o método no objeto e retorna o resultado
            return method.invoke(objeto);
    
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Você pode retornar um valor padrão ou null em caso de erro
        }
    }

    /*
     * Função para imprimir itens de uma lista qualquer
     * é capaz de aceitar imprimir itens da lista de membros,
     * sala de estudos e lista de emprestimos
     */

    public static void printListaGenerica(List<?> lista) {
        for (Object item : lista) {
            /* se a lista desejada for de membros */
            if (item instanceof Pessoa) {
                Pessoa membro = (Pessoa) item;
                System.out.println("\nInformações do Membro:");
                System.out.println("\nNome: " + membro.getnome());
                System.out.println("\nNumero de identiciação da biblioteca: " + membro.getid());
                System.out.println("\n");
            }
            /* se a lista desejada for de Multimidia */
            else if (item instanceof Multimidia) {
                Multimidia multi = (Multimidia) item;
                System.out.println("\nInformações do item Multimidia:");
                System.out.println("\nDescrição do item: " + multi.gettitulo());
                System.out.println("\nNumero de identiciação da biblioteca: " + multi.getid());
                System.out.println("\n");
            }
            /* se a lista desejada for de Salas de Estudos */
            else if (item instanceof Sala) {
                Sala sala = (Sala) item;
                System.out.println("\nInformações da Sala de Estudos:");
                System.out.println("\nDescrição da sala: " + sala.getnomeSala());
                System.out.println("\nNumero de identiciação da sala: " + sala.getidSala());
                System.out.println("\nLocal da sala: " + sala.getlocalSala());
                System.out.println("\n");
            }
            /* se a lista desejada for de Emprestimos */
            else if (item instanceof Emprestimo) {
                Emprestimo emprestimo = (Emprestimo) item;
                System.out.println("\nInformações sobre o emprestimo:");
                System.out.println("\nDescrição do item emprestado: " + emprestimo.getMultimidia().gettitulo());
                System.out.println("\nNome e identificação da pessoa que realizou o emprestimo: " + emprestimo.getpessoa().getnome() + " " + emprestimo.getpessoa().getid());
                System.out.println("\nNumero de registro do emprestimo: " + emprestimo.getregistro());
            }
        }
    }

}


