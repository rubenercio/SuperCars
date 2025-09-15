package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class GameSerializer {
	
	private Game game;
	
	private boolean playerShown = false;
	
	public GameSerializer(Game game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		String s = String.format("---- ROAD FIGHTER SERIALIZED ----%nLevel: %s%nCycles: %s%nCoins: %s%n",
				game.getLevel(), game.getNumberOfCycles(), game.getCoinsCaught());
		if (game.canShowTime())
			s += game.showElapsedTime() + "\n";
		s += "Game Objects: \n";
		for (int x = 0; x < game.getRoadLength(); x++) {
			for (int y = 0; y < game.getRoadWidth(); y++) {
				if (!playerShown && game.getPlayerX() == x && game.getPlayerY() == y) {
					Player p = game.getPlayer();
					s += p.serialize();
					playerShown = true;
				}
				s += game.serializeGameObjectsByPos(x, y);
			}
		}
		return s;
	}
}
