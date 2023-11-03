package biblioteca.models.CReflectionPackage;

/* Exceção personalizada para tratar caso o programa não consiga exibir a lista de atributos */
public class listFieldsException extends RuntimeException{
    public listFieldsException(String mensagem) {
        super(mensagem);
    } 
}
