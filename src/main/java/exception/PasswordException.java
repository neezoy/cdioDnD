package exception;

public class PasswordException extends Exception {
    String message;

    public PasswordException(String message) {
        // super("Invalid Password: ");
        this.message = message;
    }

    public String toString() {
        return "Invalid Password\n" + message;

    }
}
