package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin {

	private static boolean isPresent = false;
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		life = 1;
		symbol = "$";
	}
	
	public static boolean hasSuperCoin() {
		if (isPresent)
			return true;
		else
			return false;
	}
	
	public static String superCoinMsg() {
		return "Supercoin is present";
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.earnCoins(1000);
		onDelete();
		return false;
	}

	@Override
	public void onEnter() {
		isPresent = true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDelete() {
		die();
		isPresent = false;		
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
}
