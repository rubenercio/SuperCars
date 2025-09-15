package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.WaveAction;

public class WaveCommand extends Command implements Buyable {

private static final String NAME = "wave";
	
	private static final String SHORTCUT = "w";

	private static final String DETAILS = "[w]ave";

	private static final String HELP = "do a wave";
	
	private static final String FAILED_MSG = "Failed to do a wave";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			if (!buy(game))
				throw new NotEnoughCoinsException("Not enough coins");
			game.executeInstantAction(new WaveAction());
			game.update();
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
			
		return true;
	}

	@Override
	public int cost() {
		return 5;
	}
}