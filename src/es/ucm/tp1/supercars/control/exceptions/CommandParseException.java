package es.ucm.tp1.supercars.control.exceptions;

public class CommandParseException extends GameException{

	public CommandParseException(String message) {
		super(message);
	}

	public CommandParseException(String message, Exception cause) {
		super(message, cause);
	}

}
