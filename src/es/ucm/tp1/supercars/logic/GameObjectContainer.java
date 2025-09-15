package es.ucm.tp1.supercars.logic;

import java.util.*;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	public void addNewGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void update(Game game) {
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).update();
		}
	}
	
	public void removeDeadGameObjects(Game game) {
		int i = 0;
		while ( i < gameObjects.size()) {
			if (!gameObjects.get(i).isAlive()) {
				gameObjects.get(i).onDelete();
				gameObjects.remove(i);				
			}
			else 
				i++;
		}
	}
	
	public void killAllGameObjects() {
		for (GameObject gameObject : gameObjects) {
			gameObject.die();
		}
	}
	
	public boolean isObjectInPosition(int x, int y) {
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isInPosition(x, y))
				return true;
		}
		return false;
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isInPosition(x, y))
				return gameObject;
		}
		return null;
	}
	
	public String serializeByPosition(int x, int y) {
		String s = "";
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isInPosition(x, y))
				s += gameObject.serialize();
		}
		return s;
	}
	
	public String toString(int x, int y, boolean notEmpty) {
		String s = "";
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isInPosition(x, y)) {
				if (notEmpty)
					s += " ";
				s += gameObject.toString();
				notEmpty = true;
			}
				
		}
		return s;
	}
}
