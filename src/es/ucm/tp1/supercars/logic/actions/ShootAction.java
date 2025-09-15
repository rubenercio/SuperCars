package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ShootAction implements InstantAction {
	
	@Override
	public void execute(Game game) {
		GameObject gameObject;
		boolean done = false;
		int x = 0;
		while (x < game.getVisibility() && !done) {
			if (game.isObjectInPosition(x + game.getPlayerX(), game.getPlayerY())) {
				gameObject = game.getObjectInPosition(x + game.getPlayerX(), game.getPlayerY());
				done = gameObject.receiveShot();
			}
			x++;
		}
	}
	
}