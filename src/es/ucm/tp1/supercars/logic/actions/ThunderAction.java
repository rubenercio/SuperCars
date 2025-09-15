package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction {

	@Override
	public void execute(Game game) {
		int x = game.getRandomColumn() + game.getPlayerX(), y = game.getRandomLane();
		GameObject gameObject = game.getObjectInPosition(x, y);
		System.out.print("Thunder hit position: (" + (x - game.getPlayerX()) + " , " + y + ")");
		if (gameObject != null) {
			String symbol = gameObject.toString();
			if (gameObject.receiveThunder())
				System.out.print(" -> " + symbol);
		}
		System.out.println();
	}
}
