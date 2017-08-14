package adventure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class ReadOnly {
    
    private static final Map<List<String>, Command> synonyms = createSynonyms();

    private static final void printDelay(String s) {
        System.out.println(s);
        try {
    	Thread.sleep(4000); // measured in ms
        } catch (InterruptedException e) {
    	e.printStackTrace();
        }
    }
    
    private static final void printLoadingSequence(int timeDelay) {
        for (int i = 0; i < timeDelay; i++) {
    	try {
    	    Thread.sleep(i * 1000);
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    	System.out.print(". ");
        }
        System.out.println();
    }
    
    private static final Map<List<String>, Command> createSynonyms() {
        Map<List<String>, Command> tempSynonyms = new HashMap<List<String>, Command>();
    
        List<String> yes = Arrays.asList(new String[] { "yes", "ye", "y",
    	    "yea", "ok", "yeah", "why not", "sounds good" });
        List<String> no = Arrays.asList(new String[] { "no", "n",
    	    "no thanks", "nah", "nope" });
        List<String> quit = Arrays.asList(new String[] { "close", "quit",
    	    "q", "exit", "quit()", "exit()" });
        List<String> look = Arrays.asList(new String[] { "look",
    	    "look around", "l", "look at", "inspect", "inspect the" });
        List<String> help = Arrays.asList(new String[] { "?", "help", "h",
    	    "info", "hint" });
        List<String> inventory = Arrays.asList(new String[] { "inventory",
    	    "get inventory", "carrying", "show items", "i", "items" });
        List<String> drink = Arrays.asList(new String[] { "drink",
    	    "drink water", "water", "water bottle" });
        List<String> keys = Arrays.asList(new String[] { "shortcuts",
    	    "hotkeys", "keybindings", "keys", "keyboard", "keymap" });
        List<String> light = Arrays.asList(new String[] { // please keep
    		    // this list in
    		    // order
    		    "use flashlight", "l", "light", "light flashlight",
    		    "turn on flashlight", "turn flashlight on",
    		    "flashlight on", "turn on light", "turn light on",
    		    "dim", "dim flashlight", "turn off flashlight",
    		    "turn flashlight off", "flashlight off",
    		    "turn off light", "turn light off" });
    
        tempSynonyms.put(yes, Command.YES);
        tempSynonyms.put(no, Command.NO);
        tempSynonyms.put(quit, Command.QUIT);
        tempSynonyms.put(look, Command.LOOK);
        tempSynonyms.put(light, Command.LIGHT);
        tempSynonyms.put(help, Command.HELP);
        tempSynonyms.put(inventory, Command.INVENTORY);
        tempSynonyms.put(drink, Command.DRINK);
        tempSynonyms.put(keys, Command.KEYS);
    
        // INSPECT, KEYS, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION,
        // HELP, YES, NO
        return tempSynonyms;
    }
    
    public static final void Intro() {
        System.out
    	    .print("You can't remember how you got here. The last thing you remember is hiking with your dog, Fido, in");
        printLoadingSequence(5);
        printDelay("Where were you hiking? God, your head hurts. Maybe a glass of water would do you good. \n"
    	    + "You reach into your backpack.");
        printDelay("It's beaten up, as if it had been left in mud and marched on. What in the world "
    	    + "happened?");
        printDelay("You get out your water bottle. The water inside is lukewarm, but it's better than nothing. ");
        printDelay("(hint: type 'backpack' or 'inventory' to check what's inside your backpack.)\n");
        System.out
    	    .print("Where's Fido? Hopefully he wasn't killed in the avalance");
        printLoadingSequence(3);
        printDelay(" -- an avalanche! ");
        printDelay("You remember now. You were hiking in Alaska, near Anchorage, when an avalanche, "
    	    + "threw you off the path and into the air. \nYou need to find Fido and get out of here, "
    	    + "wherever 'here' is.");
    }
    
    public static final Command parseCommand(String s) {
    
        for (List<String> array : synonyms.keySet()) {
    	if (array.contains(s)) {
    	    return synonyms.get(array);
    	}
        }
        throw new IllegalArgumentException();
    }
    
}
