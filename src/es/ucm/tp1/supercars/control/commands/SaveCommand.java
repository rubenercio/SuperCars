package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SaveCommand extends Command {
	
	private static final String NAME = "save";
	
	private static final String SHORTCUT = "v";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String HELP = "save the state of the game to a file";
	
	private static final String FAILED_MSG = "Failed to write in the file";
	
	private String filename;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			GameSerializer serializer = new GameSerializer(game);
			writer.write(serializer.toString());
			System.out.println("Game successfully saved to file " + filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
		return false;
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 2) {
				throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				filename = words[1] + ".txt";
				return this;
			}
		}
		return null;
	}
}
