package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends Obstacle {

	public Truck(Game game, int x, int y) {
		super(game, x, y);
		life = 1;
		symbol = "←";
	}
	
	public void move() {
		x--;
	}
	
	@Override
	public void update() {
		move();
	}
}
