package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveDownCommand extends Command {
	
	private static final String NAME = "move down";
	
	private static final String SHORTCUT = "a";

	private static final String DETAILS = "[a]";

	private static final String HELP = "go down";

	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		game.updatePlayer();
		if (game.getPlayerY() < game.getRoadWidth() - 1) {
			game.moveDown();
		}
		game.moveForward();
		game.update();
		return true;
	}
}
