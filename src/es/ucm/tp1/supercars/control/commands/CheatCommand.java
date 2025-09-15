package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class CheatCommand extends Command {
	
	private static final String NAME = "cheat";
	
	private static final String SHORTCUT = "[1..5]";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";
	
	private int objChosen;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected boolean matchCommandName(String name) {
		if (name.equals("1") || name.equals("2") || name.equals("3") || 
				name.equals("4") || name.equals("5")) {
			objChosen = Integer.parseInt(name);
			for (int i = 1; i < 6; i++) {
				if (objChosen == i)
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean execute(Game game) {
		GameObject go;
		int relativeX = game.getPlayerX() + game.getVisibility() - 1;
		for (int y = 0; y < game.getRoadWidth(); y++) {
			if (game.isObjectInPosition(relativeX, y)) {
				go = game.getObjectInPosition(relativeX, y);
				go.die();
				game.removeDeadGameObjs();
			}
		}
		GameObjectGenerator.forceAdvanceObject(game, objChosen, relativeX);
		return true;
	}

}
