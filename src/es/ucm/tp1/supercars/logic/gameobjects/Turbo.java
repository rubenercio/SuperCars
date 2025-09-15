package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject {

	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		symbol = ">>>";
		life = 1;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.executeTurbo();
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
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

	@Override
	public boolean receiveShot() {
		// TODO Auto-generated method stub
		return false;
	}

}
