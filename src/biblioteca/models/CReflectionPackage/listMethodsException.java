package biblioteca.models.CReflectionPackage;

/* Exceção personalizada para tratar caso o programa não consiga exibir a lista de metodos */
public class listMethodsException extends RuntimeException{
    public listMethodsException(String mensagem) {
        super(mensagem);
    } 
}
