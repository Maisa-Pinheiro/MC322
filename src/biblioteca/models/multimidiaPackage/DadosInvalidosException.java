package biblioteca.models.multimidiaPackage;
public class DadosInvalidosException extends RuntimeException {
private static final long serialVersionUID = 1L;
    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
