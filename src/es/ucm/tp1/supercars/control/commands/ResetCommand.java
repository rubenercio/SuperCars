package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {
	
	private static final String NAME = "reset";
	
	private static final String SHORTCUT = "r";

	private static final String DETAILS = "[r]eset";

	private static final String HELP = "reset game";
	
	private static final String WRONG_LVL_MSG = "Level must be one of: TEST, EASY, HARD, ADVANCED";
	
	private static final String WRONG_SEED_MSG = "the seed is not a proper long number";
	
	private static final String SEED_INFO_MSG = "Random generator initialized with seed: ";
	
	private static Level newLevel;
	
	private static int newSeed;
	
	private static boolean basicReset = false;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length == 1) {
				basicReset = true;
				return this;
			}
			else if (words.length == 3) {
				String levelStr = words[1].toUpperCase();
				if (levelStr.equals("TEST") || levelStr.equals("EASY") || levelStr.equals("HARD") || 
						levelStr.equals("ADVANCED")) {
					newLevel = Level.valueOf(levelStr);
					try {
						newSeed = Integer.parseInt(words[2]);
					} catch (NumberFormatException e) {
						throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name, 
						                                               WRONG_SEED_MSG));
					}
					return this;
				}
				else {
					throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name,
							WRONG_LVL_MSG));
				}
								
			} else {				
				throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			}
		}
		return null;
	}

	@Override
	public boolean execute(Game game) {
		if (basicReset) {
			game.resetGame(game.getSeed(), game.getLevel());
		}
		else {
			game.resetGame(newSeed, newLevel);
			System.out.println("Level: " + newLevel.name());
			System.out.println(SEED_INFO_MSG + newSeed);
		}
		return true;
	}

}
