package games.ani.fbsender.exeption;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException() {}
}
