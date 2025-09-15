package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ExplosionAction implements InstantAction {
	
	private int x, y;
	
	public ExplosionAction(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		execute(game);
	}
	@Override
	public void execute(Game game) {
		GameObject gameObject;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (game.isObjectInPosition(i, j)) {
					gameObject = game.getObjectInPosition(i, j);
					gameObject.receiveExplosion();
				}	
			}
		}
	}

}
