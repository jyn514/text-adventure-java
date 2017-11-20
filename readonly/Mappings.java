package readonly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import adventure.Command;
import adventure.Item;
import adventure.Location;
import adventure.Room;

public final class Mappings {

    public static final Map<Location, Room> rooms = createRooms();

    public static final Map<Location, String> roomDescriptions = createDescriptions();

    static final Map<Set<String>, Command> locationBasedSynonyms = createLocationSynonyms();

    static final Map<Set<String>, Command> synonyms = createSynonyms();

    private static final Map<Location, Room> createRooms() {

	Map<Location, Room> tempRooms = new HashMap<Location, Room>();

	tempRooms.put(Location.ROOM1, createRoomOne());
	tempRooms.put(Location.CORRIDOR, createCorridor());
	tempRooms.put(Location.BASEMENT, createBasement());
	tempRooms.put(Location.ROOM1_REVISITED, createRoomOneRevisited());

	return tempRooms;

    }

    private static final Room createRoomOne() {
	String DARK = "You find yourself in a dimly lit room. You can make out a closed door, where light is "
		+ "creeping through.";

	String LIGHT = "Your flashlight is brighter than you expected in the dim room. The room is made of wood planks, "
		+ "and the ceiling is sloped. There is a chest in the middle of the room.";

	Set<Command> COMMANDS = new HashSet<>(
		Arrays.asList(Command.CHEST, Command.DOOR, Command.NEXT));

	Set<Item> ITEMS = new HashSet<>(Arrays.asList(new Item("door",
		"It's a heavy wooden door. It's partly open, and you see a glint of light shining through."),
		new Item("chest",
			"A solid wooden chest hidden in the corner. It's old, and slightly damp. You can see an ornate lock on the front.")));
	return new Room(DARK, LIGHT, COMMANDS, ITEMS);
    }

    private static final Room createCorridor() {
	String DARK = "There's a hole in the roof. There's a ton of snow all over the passageway, and even with the light of the "
		+ "moon, you can't see to the end of the corridor.";
	String LIGHT = "This whole corridor looks ready to collapse. The room has already caved in, and there's snow  "
		+ "all over the passageway. Broken planks stick out here and there amongst the wreckage. At the end of "
		+ "the passage, you can just make out a closed door.";
	Set<Command> COMMANDS = new HashSet<>(
		Arrays.asList(Command.DOOR, Command.PREVIOUS, Command.SNOW));
	Set<Item> ITEMS = null; // TODO
	return new Room(DARK, LIGHT, COMMANDS, ITEMS);
    }

    private static final Room createBasement() {
	String DARK = "The snow is everywhere down here. The corners are dark and musty, although a harsh wind is quickly sweeping "
		+ "the smell away.\nYou've got to get out of here, but you can't see an exit in this accursed snow.";

	String LIGHT = "The snow above is nothing compared to the snow here, which fills the room. "
		+ "It looks like this was a basement in another time. There's a broom in the corner and some kitchen supplies. "
		+ "\nThere's a ladder up to the corridor above, if you're careful you might be able to climb it. ";

	Set<Command> COMMANDS = new HashSet<>(
		Arrays.asList(Command.CLIMB, Command.NEXT, Command.SNOW));

	Set<Item> ITEMS = null; // TODO

	return new Room(DARK, LIGHT, COMMANDS, ITEMS);
    }

    private static final Room createRoomOneRevisited() {
	String DARK = "This is the room you woke up in. The door is ajar and you can see the remains of the"
		+ "collapsed corridor through it.";
	String LIGHT = DARK
		+ " It held up surprisingly well to the snow, which spills in from the "
		+ "door. There's a non-descript chest in the center of the room.";

	Set<Command> COMMANDS = null; // TODO
	Set<Item> ITEMS = null; // TODO

	return new Room(DARK, LIGHT, COMMANDS, ITEMS);
    }

    private static final Map<Set<String>, Command> createLocationSynonyms() {
	Map<Set<String>, Command> tempSynonyms = new HashMap<Set<String>, Command>();

	Set<String> door = new HashSet<>(
		Arrays.asList("door", "open door", "go through door", "open"));

	Set<String> next = new HashSet<>(Arrays.asList("enter", "next room",
		"forward", "next", "go forward"));

	Set<String> chest = new HashSet<>(Arrays.asList("open chest", "chest",
		"take chest", "take from chest"));

	Set<String> previous = new HashSet<>(Arrays.asList("back", "previous",
		"go back", "return", "backwards", "last room"));

	Set<String> climb = new HashSet<>(Arrays.asList("climb", "climb ladder",
		"ladder", "up", "go up"));

	Set<String> snow = new HashSet<>(Arrays.asList("snow", "clear snow",
		"move snow", "remove snow"));

	tempSynonyms.put(door, Command.DOOR);
	tempSynonyms.put(next, Command.NEXT);
	tempSynonyms.put(chest, Command.CHEST);
	tempSynonyms.put(previous, Command.PREVIOUS);
	tempSynonyms.put(climb, Command.CLIMB);
	tempSynonyms.put(snow, Command.SNOW);

	return tempSynonyms;
    }

    private static final Map<Set<String>, Command> createSynonyms() {
	Map<Set<String>, Command> tempSynonyms = new HashMap<Set<String>, Command>();

	Set<String> yes = new HashSet<>(Arrays.asList("yes", "ye", "y", "yea",
		"ok", "yeah", "why not", "sounds good"));
	Set<String> no = new HashSet<>(
		Arrays.asList("no", "n", "no thanks", "nah", "nope"));
	Set<String> quit = new HashSet<>(Arrays.asList("close", "quit", "q",
		"exit", "quit()", "exit()"));
	Set<String> look = new HashSet<>(
		Arrays.asList("look", "look around", "l"));
	Set<String> help = new HashSet<>(
		Arrays.asList("?", "help", "h", "info", "hint"));
	Set<String> inventory = new HashSet<>(Arrays.asList("inventory",
		"get inventory", "carrying", "show items", "i", "items"));
	Set<String> inspect = new HashSet<>(
		Arrays.asList("inspect", "inspect the", "look at"));
	Set<String> drink = new HashSet<>(
		Arrays.asList("drink", "drink water", "water", "water bottle"));
	Set<String> keys = new HashSet<>(Arrays.asList("shortcuts", "hotkeys",
		"keybindings", "keys", "keyboard", "keymap"));
	Set<String> light = new HashSet<>(Arrays.asList( // please keep
		// this list in
		// order
		"use flashlight", "l", "light", "light flashlight",
		"turn on flashlight", "turn flashlight on", "flashlight on",
		"turn on light", "turn light on", "dim", "dim flashlight",
		"turn off flashlight", "turn flashlight off", "flashlight off",
		"turn off light", "turn light off"));
	Set<String> location = new HashSet<>(Arrays.asList("location",
		"where am i", "where", "room", "map", "loc"));

	tempSynonyms.put(yes, Command.YES);
	tempSynonyms.put(no, Command.NO);
	tempSynonyms.put(quit, Command.QUIT);
	tempSynonyms.put(look, Command.LOOK);
	tempSynonyms.put(light, Command.LIGHT);
	tempSynonyms.put(help, Command.HELP);
	tempSynonyms.put(inventory, Command.INVENTORY);
	tempSynonyms.put(drink, Command.DRINK);
	tempSynonyms.put(keys, Command.KEYS);
	tempSynonyms.put(inspect, Command.INSPECT);
	tempSynonyms.put(location, Command.LOCATION);

	// INSPECT, KEYS, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION,
	// HELP, YES, NO
	return tempSynonyms;
    }

    private static final Map<Location, String> createDescriptions() {
	Map<Location, String> descriptions = new HashMap<>();

	descriptions.put(Location.ROOM1,
		"the small room where you woke up. Ahead you can see a closed door.");
	descriptions.put(Location.CORRIDOR,
		"a long and narrow corridor covered in snow. Behind you is the room where you woke up. Ahead is an open door.");
	descriptions.put(Location.BASEMENT,
		"a small basement. Above, you can see the corridor you fell from. Ahead is a rickety ladder.");
	return descriptions;
    }
}
