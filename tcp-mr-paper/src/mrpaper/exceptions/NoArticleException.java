package mrpaper.exceptions;

public class NoArticleException extends RuntimeException{
	private static final long serialVersionUID = 3;

    public NoArticleException(String message) {
        super(message);
    }
}
