package biblioteca.models.CReflectionPackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import biblioteca.models.pessoasPackage.NovaPessoaException;

public class CReflection {

    /* Listando e imprimindo os metodos */
    public static void listMethods(Class<?> classe) {
        /* Tratamento de tryCatch */
        try {
            Method[] metodos = classe.getDeclaredMethods();

            /* Vefiricando se a classe possui algum metodo */
            if (metodos.length == 0) {
                throw new NovaPessoaException("A classe não possui metodos disponiveis.\n");
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
                throw new NovaPessoaException("A classe não possui atributos disponiveis.\n");
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

    public static void invokeMethod(Class<?> classe, String methodName) {
        try {
            // Obtém o construtor padrão da classe
            var construtor = classe.getDeclaredConstructor();

            // Cria uma instância da classe usando o construtor padrão
            Object objeto = construtor.newInstance();

            // Obtém o método com base no nome fornecido
            Method method = classe.getDeclaredMethod(methodName);

            // Invoca o método no objeto
            method.invoke(objeto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
