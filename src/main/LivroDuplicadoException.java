package main;
public class LivroDuplicadoException extends RuntimeException {
private static final long serialVersionUID = 1L;
    public LivroDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
