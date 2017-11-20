/**
 * Main file
 * Prints intro, then goes into read -> parse -> exec loop
 *
 * @author Joshua Nelson
 * @version 0.2 (2017-09-21)
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
 *  along with this program, in ./LICENSE.  If not, see
 *  <http://www.gnu.org/licenses/>.
 *  
 */
package adventure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Adventure {

    private Scanner scanner = new Scanner(System.in);
    private Character character;
    private String lastInput = "";

    public Adventure() {

	readonly.Printing.printCopyright();
	System.out.println(
		"Welcome to adventure! Type 'help' at any point for help.");
	System.out.print("Would you like to read the intro? (y/n): ");

	if (getBool()) {
	    readonly.Printing.Intro();
	}

	character = new Character();
	executeCommand(Arrays.asList(Command.LOOK));
	while (true) {
	    try {
		List<Command> c = getCommand();
		if (c.contains(Command.QUIT)) {
		    System.out.println("Quitting.");
		    return;
		}
		executeCommand(c);
	    } catch (readonly.NotImplementedException e) {
		System.out.println(e.getMessage()); // is there a less verbose way to do this?
	    }
	}
    }

    private void printLookResult() {
	if (character.flashlightIsLit) {
	    System.out.println(character.room.descriptionWhenLight);
	} else {
	    System.out.println(character.room.descriptionWhenDark);
	}
    }

    private void executeCommand(List<Command> command) {
	switch (command.get(0)) { // out of date
	case HELP: // TODO: item/room specific help
	    readonly.Printing.getHelp();
	    break;
	case LOOK:
	    if (command.size() == 1) {
		printLookResult();
	    } else {
		printInspectResult();
	    }
	    break;
	case INSPECT:
	    printInspectResult();
	    break;
	case INVENTORY:
	    System.out.println("You are carrying:");
	    for (Item i : character.inventory) {
		System.out.print("\t");
		if (readonly.StringManipulation.shouldBeAn(i.name)) {
		    System.out.print("An ");
		} else {
		    System.out.print("A ");
		}
		System.out.println(i.name);
	    }
	    break;
	case LOCATION:
	    String loc = readonly.Mappings.roomDescriptions
		    .get(character.location);
	    System.out.println(String.format("You are standing in %s", loc));
	    break;
	case LIGHT:
	    character.flashlightIsLit = !character.flashlightIsLit;
	    printLookResult();
	    break;
	case KEYS:
	    System.out.println(readonly.Functions.getOneLetterKeys());
	    break;
	case QUIT:
	    break; // handled in <init> albeit poorly
	case YES:
	    break;
	case NO:
	    break;
	default:
	    throw new readonly.NotImplementedException(
		    "This command is meant to be used, however it has not been programmed yet.\n");
	}
    }

    private void printInspectResult() {
	if (!lastInput.contains(" ")) {
	    System.out.println("What do you want to look at?");
	    return;
	}
	String[] words = lastInput.split(" ");
	String chosenItem = words[words.length - 1];
	boolean looked = false;

	for (Item item : character.inventory) {
	    if (item.name.equals(chosenItem)) {
		System.out.println(item.description);
		looked = true;
	    }
	}
	for (Item item : character.room.items) {
	    if (item.name.equals(chosenItem)) {
		System.out.println(item.description);
		looked = true;
	    }
	}

	if (looked == false) {
	    System.out.println("I don't recognize that item.");
	}
    }

    private List<Command> getCommand() { // function allows recursion
	List<Command> currentCommands = new ArrayList<Command>();

	do {
	    System.out.print(">>> ");
	    lastInput = scanner.nextLine().trim().toLowerCase();
	    for (String s : lastInput.split(" ")) {
		Command c = readonly.Functions.parseCommand(s, character.room);
		if (c != null) {
		    currentCommands.add(c);
		}
	    }

	    if (!lastInput.equals("") && (currentCommands.size() == 0)) {
		System.out.println(
			"Command not recognized. Please try something else, or type 'help'.");
		return getCommand(); // recursion!
	    }

	} while (currentCommands.size() == 0);
	return currentCommands;

    }

    private boolean getBool() {
	Command tempCommand = readonly.Functions
		.parseCommand(scanner.nextLine().trim().toLowerCase());
	if (tempCommand == Command.YES) {
	    return true;
	} else if (tempCommand == Command.NO) {
	    return false;
	} else {
	    System.out.print("Please type yes or no.");
	    return getBool();
	}
    }

}
