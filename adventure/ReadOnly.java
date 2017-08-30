package adventure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ReadOnly {

    static final Map<String, Room> rooms = createRooms();

    static final void Intro() {
	System.out.print(
		"You can't remember how you got here. The last thing you remember is hiking with your dog, Fido, in");
	printLoadingSequence(5);
	printDelay("Where were you hiking? God, your head hurts. Maybe a glass of water would do you good. \n"
		+ "You reach into your backpack.");
	printDelay("It's beaten up, as if it had been left in mud and marched on. What in the world "
		+ "happened?");
	printDelay("You get out your water bottle. The water inside is lukewarm, but it's better than nothing. ");
//	printDelay("(hint: type 'backpack' or 'inventory' to check what's inside your backpack.)\n");
	System.out
		.print("Where's Fido? Hopefully he wasn't killed in the avalance");
	printLoadingSequence(3);
	printDelay(" -- an avalanche! ");
	printDelay("You remember now. You were hiking in Alaska, near Anchorage, when an avalanche, "
		+ "threw you off the path and into the air. \nYou need to find Fido and get out of here, "
		+ "wherever 'here' is.");
    }

    static final Command parseCommand(String s) {

	for (List<String> array : synonyms.keySet()) {
	    if (array.contains(s)) {
		return synonyms.get(array);
	    }
	}
	throw new IllegalArgumentException();
    }

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
	List<String> no = Arrays.asList(new String[] { "no", "n", "no thanks",
		"nah", "nope" });
	List<String> quit = Arrays.asList(new String[] { "close", "quit", "q",
		"exit", "quit()", "exit()" });
	List<String> look = Arrays.asList(new String[] { "look", "look around",
		"l", "look at", "inspect", "inspect the" });
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

    private static final Map<String, Room> createRooms() {

	Map<String, Room> tempRooms = new HashMap<String, Room>();

	tempRooms.put("start",	new Room(
		"You find yourself in a dimly lit room. You can make out a closed door, where light is "
		+ "creeping through.",
		"Your flashlight is brighter than you expected in the dim room. The room is made of wood planks, "
		+ "and the ceiling is sloped. There is a chest in the middle of the room.",
		Arrays.asList(new Command[] { Command.CHEST, Command.DOOR, Command.NEXT })));
	
	tempRooms.put("corridor", new Room(
		"There's a hole in the roof. There's a ton of snow all over the passageway, and even with the light of the "
			+ "moon, you can't see to the end of the corridor.",
		"This whole corridor looks ready to collapse. The room has already caved in, and there's snow  "
			+ "all over the passageway. Broken planks stick out here and there amongst the wreckage. At the end of "
			+ "the passage, you can just make out a closed door.",
		Arrays.asList(new Command[] { Command.DOOR, Command.PREVIOUS, Command.SNOW })));
	
	tempRooms.put("basement", new Room(
		"The snow is everywhere down here. The corners are dark and musty, although a harsh wind is quickly sweeping "
                       + "the smell away.\nYou've got to get out of here, but you can't see an exit in this accursed snow.",
                "The snow above is nothing compared to the snow here, which fills the room. "
                       + "It looks like this was a basement in another time. There's a broom in the corner and some kitchen supplies. "
                       + "\nThere's a ladder up to the corridor above, if you're careful you might be able to climb it. ",
                Arrays.asList(new Command[] { Command.CLIMB, Command.NEXT, Command.SNOW })));
	
	tempRooms.put("startRevisited", new Room(
		"This is the room you woke up in. The door is ajar and you can see the remains of the"
			+ "collapsed corridor through it.",
		"This is the room you woke up in. The door is ajar and you can see the remains of the collapsed "
		        + "corridor through it. It held up surprisingly well to the snow, which spills in from the "
			+ "door. There's a non-descript chest in the center of the room.",
		Arrays.asList(new Command[] { Command.CLIMB, Command.CHEST, Command.PREVIOUS })));

	return tempRooms;

    }

}
