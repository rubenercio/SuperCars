package es.ucm.tp1.supercars.control.exceptions;

public class GameException extends Exception {
	
	public GameException(String message) {
		super(message);
	}

	public GameException(String message, Exception cause) {
		super(message, cause);
	}
}
