package biblioteca.controllers;

public class BloqueioMembroException extends Exception {
     private static final long serialVersionUID = 1L;
    public BloqueioMembroException(String mensagem) {
        super(mensagem);
    }
}
