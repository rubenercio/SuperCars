package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	
	private static int numberOfCoins = 0;
	
	public Coin(Game game, int x, int y) {
		super(game, x, y);
		symbol = "¢";
		life = 1;
	}
	
	public static int getNumberOfCoins() {
		return numberOfCoins;
	}
	
	public void onEnter() {
		numberOfCoins++;
	}

	public void update() {
		
	}
	
	public void onDelete() {
		numberOfCoins--;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.earnCoins(1);
		substractLife();
		return false;
	}
	
	
	public boolean receiveShot() {
		return false;
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveWave() {
		x++;
		return true;
	}
}
