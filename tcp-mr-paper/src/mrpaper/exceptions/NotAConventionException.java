package mrpaper.exceptions;

public class NotAConventionException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

    public NotAConventionException(String message) {
        super(message);
    }
}