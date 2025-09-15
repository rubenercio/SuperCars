package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends Obstacle {
	
	String way;

	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		life = 1;
		symbol = "☺";
		way = "up";
	}
	
	public void move() {
		if (way == "up") {
			if (y > 0) {
				y--;
			}
			else {
				way = "down";
				y++;
			}
		}
		else if (way == "down") {
			if (y < game.getRoadWidth() - 1) {
				y++;
			}
			else {
				way = "up";
				y--;
			}
		}
	}
	

	@Override
	public void update() {
		move();		
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		if (isAlive()) {
			player.die();
			substractLife();
			return true;
		}
		return false;
	}


	@Override
	public boolean receiveExplosion() {
		game.playerDamagesPedestrian();
		substractLife();
		return false;
	}
	
	@Override
	public boolean receiveShot() {
		game.playerDamagesPedestrian();
		substractLife();
		return false;
	}
	
	@Override
	public String serialize() {
		return String.format("%s (%s, %s) %s%n", toString(), x, y, way);
	}
}
