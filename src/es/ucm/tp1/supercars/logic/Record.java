package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.Level;

public class Record {
	
	public static int loadRecord(Level level) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader("record.txt"))) {
			String str;
			boolean set = false;
			while ((str = reader.readLine()) != null && !set) {
				String[] words = str.split(":");
				if (level == Level.valueOfIgnoreCase(words[0])) {
					return Integer.parseInt(words[1]);
				}
            }
			if (!set)
				return 22340;
			
	    } catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
