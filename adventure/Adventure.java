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
 *  along with this program, in ./LICENSE.  If not, see
 *  <http://www.gnu.org/licenses/>.
 *  
 */
package adventure;

import java.util.Arrays;
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
	executeCommand(Command.LOOK);
	while (true) {
	    System.out.print(">>> ");
	    try {
		executeCommand(getCommand());
	    } catch (readonly.NotImplementedException e) {
		e.printStackTrace();
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

    private void printInventory() {
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
    }

    private void executeCommand(Command command) {
	if (command == Command.HELP) {
	    readonly.Printing.getHelp();
	} else if (command == Command.LOOK) {
	    printLookResult();
	} else if (command == Command.LOOK_AT_ITEM) { // TODO fails (item not in valid commands)
	    printLookAtItemResult();
	} else if (command == Command.INVENTORY) {
	    printInventory();
	} else if (command == Command.LOCATION) {
	    printLocation();
	} else {
	    throw new readonly.NotImplementedException(
		    "This command is meant to be used, however it has not been programmed yet.");
	}
    }
    
    private void printLocation() {
	String loc = readonly.Mappings.roomDescriptions.get(character.location);
	System.out.println(String.format("You are standing in %s", loc));
    }

    private void printLookAtItemResult() {
	if (!lastInput.contains(" ")) {
	    System.out.println("What do you want to look at?");
	    return;
	}
	String[] words = lastInput.split(" ");
	String chosenItem = words[words.length - 1];
	boolean looked = false;
	
	for (Item item : character.inventory) {
	    if (item.name == chosenItem) {
		System.out.println(item.description);
		looked = true;
	    }
	}
	for (Item item : character.room.items) {
	    if (item.name == chosenItem) {
		System.out.println(item.description);
		looked = true;
	    }
	}
	
	if (looked == false) {
	    System.out.println("What do you want to look at?");
	}
    }

    private Command getCommand() {
	Command c = null;
	lastInput = scanner.nextLine(); // see https://stackoverflow.com/questions/13102045/
	c = readonly.Functions.parseCommand(lastInput);

	while (c == null) {
	    System.out.print("Command not recognized. Please try again, or type 'help'.\n>>>");
	    lastInput = scanner.nextLine();
	    c = readonly.Functions.parseCommand(lastInput);
	}
	return c;

    }

    private boolean getBool() {
	Command tempCommand = readonly.Functions.parseCommand(scanner.nextLine());
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
