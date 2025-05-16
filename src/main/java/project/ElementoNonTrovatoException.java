package project;

public class ElementoNonTrovatoException extends RuntimeException {
    public ElementoNonTrovatoException (){}
    public ElementoNonTrovatoException(String message) {
        super(message);
    }
}
