package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.ExplosionAction;

public class Grenade extends GameObject {

	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		life = 3;
		setSymbol();
	}

	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveWave() {
		x++;
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		substractLife();
		setSymbol();			
	}

	@Override
	public void onDelete() {
		game.executeInstantAction(new ExplosionAction(x, y, game));
	}

	@Override
	public boolean receiveShot() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setSymbol() {
		symbol = "ð[" + life + "]";
	}
	
	@Override
	public String serialize() {
		return String.format("%s (%s, %s) %s%n", toString(), x, y, life);
	}
 
}
