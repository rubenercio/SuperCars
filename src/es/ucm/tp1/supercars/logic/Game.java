package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.actions.InstantAction;

import java.util.Locale;
import java.util.Random;

public class Game {
	
	private long seed;
	private Level level;
	private Player player;
	private GameObjectContainer gameObjects;
	private int numberOfCycles;
	private Random r;
	private double startTime;
	private boolean exitShortcut = false;
	private boolean testToggled = false;

	public Game(long seed, Level level) {
		initGame(seed, level);
	}
	
	public void initGame(long seed, Level level) {
		this.seed = seed;
		this.r = new Random(this.seed);
		this.level = level;
		setRecord();
		player = new Player(this, 0, (level.getWidth() / 2));
		gameObjects = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
		numberOfCycles = 0;
		startTime = System.currentTimeMillis();
	}
	
	public void resetGame(long seed, Level level) {
		this.killAllGameObjects();
		this.removeDeadGameObjs();
		initGame(seed, level);
	}
	
	public void toggleTest() {
		testToggled = true;
	}
	
	public void setRecord() {
		level.setRecord(Record.loadRecord(level));
	}
	
	public String showRecord() {
		double rec = (double) level.getRecord() / 1000;
		return level.toString() + " record is " + String.format(Locale.GERMANY, "%.2f", rec) + " s";
	}
	
	public String getGameStatus() {
		return "";
	}
	
	public boolean getExitShortcut() {
		return exitShortcut;
	}

	public void updatePlayer() {
		player.update();
	}

	public void killAllGameObjects() {
		gameObjects.killAllGameObjects();
	}
	
	public void removeDeadGameObjs() {
		gameObjects.removeDeadGameObjects(this);
	}
	
	public void update() {
		this.updatePlayer();
		gameObjects.update(this);
		GameObjectGenerator.generateRuntimeObjects(this);
		this.removeDeadGameObjs();
		numberOfCycles++;
	}
	
	public long getSeed() {
		return seed;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Player getPlayer() {
		return player;
	}
 	
	public int getRoadLength() {
		return level.getLength();
	}
	
	public int getRoadWidth() {
		return level.getWidth();	
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public void moveForward() {
		player.moveForward();
	}
	
	public void moveUp() {
		player.moveUp();
	}
	
	public void moveDown() {
		player.moveDown();
	}
	
	public void addCoins(int n) {
		player.earnCoins(n);
	}
	
	public void playerDamagesPedestrian() {
		player.looseAllCoins();
	}
	
	public int getRandomLane() {
        return (int) (r.nextDouble() * getRoadWidth());
    }
	
	public int getRandomColumn() {
		return (int) (r.nextDouble() * getVisibility());
	}
 	
	public int getCoinsCaught() {
		return player.getCoinsCaught();
	}
	
	public int getNumberOfCycles() {
		return numberOfCycles;
	}
	
	public int getNumberOfCoins() {
		return Coin.getNumberOfCoins();
	}
	
	public int getNumberOfObstacles() {
		return Obstacle.getNumberOfObstacles();
	}
	
	public void exit() {
		exitShortcut = true;
	}
	
	public void executeInstantAction(InstantAction i) {
		i.execute(this);
	}
 	
	public boolean isFinished() {
		if (!player.isAlive() || (player.getX() > level.getLength()) || exitShortcut)
			return true;
		else return false;
	}
	
	public String printEnd(String crashMsg, String winMsg, String exitMsg) {
		if(!player.isAlive()) {
			return crashMsg;
		}
		else if(player.getX() > level.getLength()) {
			return winMsg;
		}
		else if (exitShortcut) {
			return exitMsg;
		}
		return "";
	}
	
	public boolean isObjectInPosition(int x, int y) {
		return gameObjects.isObjectInPosition(x, y);
	}
 	
	public GameObject getObjectInPosition(int x, int y) {
		return gameObjects.getObjectInPosition(x, y);
	}
	
	public String serializeGameObjectsByPos(int x, int y) {
		return gameObjects.serializeByPosition(x, y);
	}
 
	public String positionToString(int i, int j) {
		boolean notEmpty = false;
		int relativeX = player.getX() + i;
		String s = "";
		if (player.isInPosition(relativeX, j)) {
			s += player.toString();
			notEmpty = true;
		}
		s += gameObjects.toString(relativeX, j, notEmpty);
		if (relativeX == this.getRoadLength()) {
			if (notEmpty) s += " ";
			s += "¦";
		}
		return s;
	}
	
	public boolean isPositionValid(int x, int y) {
		if (x >= 0 && x < this.getVisibility() && y >= 0 && y < this.getRoadWidth())
			return true;
		else 
			return false;
	}
	
	public void tryToAddObject(GameObject gameObject, double objectFrequency) {
		int x = gameObject.getX(), y = gameObject.getY();
		if (r.nextDouble() < objectFrequency && !isObjectInPosition(x, y)) {
			gameObjects.addNewGameObject(gameObject);
			gameObject.onEnter();
		}
	}

	public boolean forceAddObject(GameObject go) {
		if (!isObjectInPosition(go.getX(), go.getY())) {
			gameObjects.addNewGameObject(go);
			go.onEnter();
			return true;
		}
		return false;
	}

	public String showElapsedTime() {
		double time = (System.currentTimeMillis() - startTime) / 1000;
		return "Elapsed Time: " + String.format(Locale.GERMANY, "%.2f", time) + " s";
	}
	
	public boolean canShowTime() {
		return (level != Level.TEST && !testToggled);
	}
  }




