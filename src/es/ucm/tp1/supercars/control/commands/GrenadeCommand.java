package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable {

	private static final String NAME = "grenade";
	
	private static final String SHORTCUT = "g";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String HELP = "add a grenade in position x, y";
	
	private static final String FAILED_MSG = "Failed to add grenade";
	
	private static int x, y;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			if (game.isObjectInPosition(x, y) || !game.isPositionValid(x, y)) 
				throw new InvalidPositionException("Invalid position.");
			if (!buy(game))
				throw new NotEnoughCoinsException("Not enough coins");
			x += game.getPlayerX();
			game.update();
			game.forceAddObject(new Grenade(game, x, y));
			return true;
		}
		catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 3) {
				throw new CommandParseException(String.format("[ERROR]:	Command %s: %s", name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				try {
					x = Integer.parseInt(words[1]);
					y = Integer.parseInt(words[2]);
					return this;
				} catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					throw new CommandParseException(String.format("[ERROR]: %s", FAILED_MSG), e);
				}
			}
		}
		return null;
	}

	@Override
	public int cost() {
		return 3;
	}
}