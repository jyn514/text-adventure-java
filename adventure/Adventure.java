package adventure;
/**
 * Main file
 *
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14)
 * @email jyn514@gmail.com
 * Copyright (C) 2017  Joshua Nelson
 *
 *    This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program, in [main directory]/LICENSE.  If not, see
 *  <http://www.gnu.org/licenses/>.
 *  
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Adventure
{
    private static final class Functions {

	private static final Map<List<String>, Command> createSynonyms() 
	{
	    Map<List<String>, Command> tempSynonyms = new HashMap<List<String>, Command>();
	    
	    List<String> yes = Arrays.asList(new String[] {"yes", "y", "ok"});
	    List<String> no =  Arrays.asList(new String[] {"no", "n"});
	    List<String> quit = Arrays.asList(new String[] {"close", "quit", "q", "exit", "quit()", "exit()"});
	    List<String> look =  Arrays.asList(new String[] {"look", "look around", "l", "look at", "inspect", "inspect the"});
	    List<String> help = Arrays.asList(new String[] {"?", "help", "h", "info", "hint"});
	    List<String> inventory = Arrays.asList(new String[] {"inventory", "get inventory", "carrying", "show items", "i", "items"});
	    List<String> drink = Arrays.asList(new String[] {"drink", "drink water", "water", "water bottle"});
	    List<String> keys = Arrays.asList(new String[] {"shortcuts", "hotkeys", "keybindings", "keys", "keyboard", "keymap"});
	    List<String> light =  Arrays.asList(new String[] 
	    {   // please keep this list in order
	        "use flashlight", "l",
	        "light", "light flashlight", "turn on flashlight",  "turn flashlight on",  "flashlight on", "turn on light", "turn light on", 
	        "dim",   "dim flashlight",   "turn off flashlight", "turn flashlight off", "flashlight off","turn off light", "turn light off"
	    });
	    
	    tempSynonyms.put(yes, Command.YES);
	    tempSynonyms.put(no, Command.NO);
	    tempSynonyms.put(quit, Command.QUIT);
	    tempSynonyms.put(look, Command.LOOK);
	    tempSynonyms.put(light, Command.LIGHT);
	    tempSynonyms.put(help, Command.HELP);
	    tempSynonyms.put(inventory, Command.INVENTORY);
	    tempSynonyms.put(drink, Command.DRINK);
	    tempSynonyms.put(keys, Command.KEYS);
	    
	    // INSPECT, KEYS, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION, HELP, YES, NO
	    return tempSynonyms;
	}
	

	private static final Command parseCommand(String s)
	{
	    for (List<String> array : synonyms.keySet()) 
	    {
	        if (array.contains(s)) {
	            return synonyms.get(array);
	        }
	    }
	    return null;
	}

    }

    private static final Map<List<String>, Command> synonyms = Functions.createSynonyms();

    public static void main()
    {
	System.out.println("Adventure  Copyright (C) 2017 Joshua Nelson");
	System.out.println("This program comes with ABSOLUTELY NO WARRANTY.");
	System.out.println("This is free software, and you are welcome to redistribute it");
    	System.out.println("under certain conditions; see LICENSE for details.\n\n");
	System.out.println("In development. Come back later :)"); // todo
	
    	Character character = new Character();
    }

}
