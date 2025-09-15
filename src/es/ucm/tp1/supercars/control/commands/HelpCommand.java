package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class HelpCommand extends Command {

	private static final String NAME = "help";
	
	private static final String SHORTCUT = "h";

	private static final String DETAILS = "[h]elp";

	private static final String HELP = "show this help";
	
	private static final String[] HELP_TEXT = new String[] {
			"Available commands:",
			"[h]elp: show this help",
			"[i]nfo: prints gameobject info",
			"[n]one | []: update",
			"[q]: go up",
			"[a]: go down",
			"[e]xit: exit game",
			"[r]eset [<level> <seed>]: reset game",
			"[t]est: enables test mode",
			"[s]hoot: shoot bullet",
			"[g]renade <x> <y>: add a grenade in position x, y",
			"[w]ave: do wave",
			"Clear [0]: Clears the road",
			"Cheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object",			
		};

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		for (String s : HELP_TEXT)
			System.out.println(s);
		return false;
	}
}
