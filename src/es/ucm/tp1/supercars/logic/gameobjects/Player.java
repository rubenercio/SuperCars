/**
 * 
 */
package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	
	private int coinsCaught;
	
	public Player(Game game, int x, int y) {
		super(game, x, y);
		symbol = ">";
		life = 1;
		coinsCaught = 5;
	}
	
	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}
		return "@";
	}
	
	public int getCoinsCaught() {
		return coinsCaught;
	}
	
	public void looseAllCoins() {
		coinsCaught = 0;
	}
	
	public void moveForward() {
		x = x + 1;
	}
	
	public void moveUp() {
		y = y - 1;
	}
	
	public void moveDown() {
		y = y + 1;	
	}
	
	public void executeTurbo() {
		x += 3;
	}
	
	public void earnCoins(int n) {
		coinsCaught += n;
	}

	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) 
			return other.receiveCollision(this);
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}
	
	public boolean receiveShot() {
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		doCollision();
	}

	@Override
	public void onDelete() {
	}


	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}
}
