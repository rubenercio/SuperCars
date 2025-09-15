package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class InfoCommand extends Command {

	private static final String NAME = "info";
	
	private static final String SHORTCUT = "i";

	private static final String DETAILS = "[i]nfo";

	private static final String HELP = "prints gameobject info";
	
	private static final String[] INFO_TEXT = new String[] {
			"Available objects:",
			"[Car] the racing car",
			"[Coin] gives 1 coin to the player",
			"[Obstacle] hits car",
			"[GRENADE] Explodes in 3 cycles, harming everyone around",
			"[WALL] hard obstacle",
			"[TURBO] pushes the car: 3 columns",
			"[SUPERCOIN] gives 1000 coins",
			"[TRUCK] moves towards the player",
			"[PEDESTRIAN] person crossing the road up and down",
		};

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		for (String s : INFO_TEXT)
			System.out.println(s);
		return false;
	}
}