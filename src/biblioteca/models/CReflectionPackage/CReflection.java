package biblioteca.models.CReflectionPackage;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CReflection {

    public static void listMethods(Class<?> classe) {
        Method[] metodos = classe.getDeclaredMethods();
        System.out.println("Métodos da classe " + classe.getSimpleName() + ":");
        for (Method metodo : metodos) {
            System.out.println(metodo.getName());
        }
        System.out.println("\n");
    }

    public static void listFields(Class<?> classe) {
        Field[] campos = classe.getDeclaredFields();
        System.out.println("Atributos da classe " + classe.getSimpleName() + ":");
        for (Field campo : campos) {
            System.out.println(campo.getName());
        }
        System.out.println("\n");
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
