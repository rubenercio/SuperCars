package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacle {
	
	public Wall(Game game, int x, int y) {
		super(game, x, y);
		life = 3;
		setWallSymbol();
	}
	
	public void setWallSymbol() {
		switch(life) {
		case 3: 
			symbol = "█"; break;
		case 2: 
			symbol = "▒"; break;
		case 1: 
			symbol = "░"; break;
		}
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		game.addCoins(5);
	}

	@Override
	public boolean receiveShot() {
		substractLife();
		setWallSymbol();
		return true;
	}
	
	@Override
	public String serialize() {
		return String.format("%s (%s, %s) %s%n", toString(), x, y, life);
	}
}
