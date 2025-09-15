package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	private static int numberOfObstacles = 0;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = "░";
		life = 1;
	}
	
	public static int getNumberOfObstacles() {
		return numberOfObstacles;
	}
	
	public void onEnter() {
		numberOfObstacles++;
	}

	public void update() {
		
	}
	
	public void onDelete() {
		numberOfObstacles--;
	}

	@Override
	public boolean receiveCollision(Player player) {
		if (isAlive()) { 
			player.substractLife();
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveThunder() {
		die();
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		die();
		return true;
	}
	
	public boolean receiveWave() {
		x++;
		return true;
	}

	@Override
	public boolean receiveShot() {
		substractLife();
		return true;
	}
}
