package es.ucm.tp1.supercars.logic.gameobjects;

public interface Collider {

	boolean receiveCollision(Player player);
	
	boolean receiveShot();
	
	boolean receiveThunder();
	
	boolean receiveWave();
	
	boolean receiveExplosion();
}
