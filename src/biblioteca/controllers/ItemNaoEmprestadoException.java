package biblioteca.controllers;

public class ItemNaoEmprestadoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ItemNaoEmprestadoException(String message) {
        super(message);
    }
}
