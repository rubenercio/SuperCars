package es.ucm.tp1.supercars.control.exceptions;

public class CommandExecuteException extends GameException {

	public CommandExecuteException(String message) {
		super(message);
	}

	public CommandExecuteException(String message, Exception cause) {
		super(message, cause);
	}

}
