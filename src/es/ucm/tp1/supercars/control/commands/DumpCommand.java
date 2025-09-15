package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command {

	private static final String NAME = "dump";
	
	private static final String SHORTCUT = "d";

	private static final String DETAILS = "[d]ump <filename>";

	private static final String HELP = "shows the content of a saved file";
	
	private String filename;

	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			System.out.println("Super cars 3.0\n");
			String str;
			while ((str = reader.readLine()) != null) {    
                System.out.println(str);  
            }
	    } catch (IOException e) {
			System.out.println("An error ocurred on reading a file");
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
