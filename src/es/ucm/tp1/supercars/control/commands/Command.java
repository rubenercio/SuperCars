package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {
	
	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new MoveUpCommand(),
		new MoveDownCommand(),
		new ExitCommand(),
		new ResetCommand(),
		new TestCommand(),
		new ShootCommand(),
		new WaveCommand(),
		new GrenadeCommand(),
		new SerializeCommand(),
		new SaveCommand(),
		new ShowRecordCommand(),
		new DumpCommand(),
		new ClearCommand(),
		new CheatCommand(),
	};
	/* @formatter:on */

	protected final String name;

	protected final String shortcut;

	protected final String details;

	protected final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game)  throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				return this;
			}
		}
		return null;
	}
	
	public static Command getCommand(String[] commandWords)	throws CommandParseException {
		for (Command c : AVAILABLE_COMMANDS) {
			if (c.parse(commandWords) != null) {
				return c.parse(commandWords);
			}
		}
		throw new CommandParseException(String.format("[ERROR]: %s", UNKNOWN_COMMAND_MSG));
	}
}
