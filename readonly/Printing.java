/**
 * Description TODO
 *
 * @author Joshua Nelson
 * @version TODO
 * @email jyn514@gmail.com
 * Copyright (C) 2017  Joshua Nelson
 *
 */
package readonly;

import java.util.Arrays;
import java.util.List;

import adventure.Command;

public final class Printing {

    public static final void getHelp() {
	final List<Command> GLOBAL_HELP_OPTIONS = Arrays.asList(Command.INSPECT,
		Command.DRINK, Command.QUIT, Command.LIGHT, Command.INVENTORY,
		Command.LOOK, Command.LOCATION, Command.HELP);

	System.out.println("Actions: (not case-sensitive)");
	for (Command command : GLOBAL_HELP_OPTIONS) {
	    System.out.print(command + " ");
	}
	System.out.println(); // empty line
    }

    public static final void Intro() {
	System.out.print(
		"You can't remember how you got here. The last thing you remember is hiking with your dog, Fido, in");
	printLoadingSequence(5);
	printDelay(
		"Where were you hiking? God, your head hurts. Maybe a glass of water would do you good. \n"
			+ "You reach into your backpack.");
	printDelay(
		"It's beaten up, as if it had been left in mud and marched on. What in the world "
			+ "happened?");
	printDelay(
		"You get out your water bottle. The water inside is lukewarm, but it's better than nothing. ");
	// printDelay("(hint: type 'backpack' or 'inventory' to check what's
	// inside your backpack.)\n");
	System.out.print(
		"Where's Fido? Hopefully he wasn't killed in the avalance");
	printLoadingSequence(3);
	printDelay(" -- an avalanche! ");
	printDelay(
		"You remember now. You were hiking in Alaska, near Anchorage, when an avalanche, "
			+ "threw you off the path and into the air. \nYou need to find Fido and get out of here, "
			+ "wherever 'here' is.");
    }

    public static final void printCopyright() {
	System.out.println("Adventure  Copyright (C) 2017 Joshua Nelson");
	System.out.println("This program comes with ABSOLUTELY NO WARRANTY.");
	System.out.println(
		"This is free software, and you are welcome to redistribute it");
	System.out.println(
		"under certain conditions; see LICENSE for details.\n");
    }

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
}
