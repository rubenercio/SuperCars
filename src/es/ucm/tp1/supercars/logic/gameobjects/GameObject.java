package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;

	protected Game game;

	protected String symbol;
	
	protected int life;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}
	
	public boolean isAlive() {
		if (life > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}
		return "";
	}
	
	public void die() {
		life = 0;
	}
	
	public void substractLife() {
		life--;
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String serialize() {
		return String.format("%s (%s, %s)%n", toString(), x, y);
	}
	
	public abstract void onEnter();
	
	public abstract void update();
	
	public abstract void onDelete();
	
	public abstract boolean receiveCollision(Player player);
	
	public abstract boolean receiveShot();
	
	public abstract boolean receiveThunder();
	
	public abstract boolean receiveWave();
	
	public abstract boolean receiveExplosion();
}
