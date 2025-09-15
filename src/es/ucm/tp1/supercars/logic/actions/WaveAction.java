package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Collider;

public class WaveAction implements InstantAction {

	@Override
	public void execute(Game game) {
		for (int x = game.getPlayerX() + game.getVisibility() - 1; x >= game.getPlayerX(); x--) {
			for (int y = 0; y < game.getRoadWidth(); y++) {
				Collider other = game.getObjectInPosition(x, y);
				if (other != null && game.getObjectInPosition(x + 1, y) == null)
					other.receiveWave();
			}
		}
	}

}
