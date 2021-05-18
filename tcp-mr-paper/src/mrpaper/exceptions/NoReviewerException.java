package mrpaper.exceptions;

public class NoReviewerException extends RuntimeException {
	
    private static final long serialVersionUID = 1;

    public NoReviewerException(String message) {
        super(message);
    }
}