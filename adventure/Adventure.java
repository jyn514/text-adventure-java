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

import readonly.ReadOnly;

public class Adventure {

    private Scanner scanner = new Scanner(System.in);
    private Character character;
    private String lastInput;

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
	    System.out.println(character.location.descriptionWhenLight);
	} else {
	    System.out.println(character.location.descriptionWhenDark);
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
	} else if (command == Command.LOOK_AT_ITEM) {
	    printLookAtItemResult();
	} else if (command == Command.INVENTORY) {
	    printInventory();
	} else {
	    throw new readonly.NotImplementedException(
		    "This command is meant to be used, however it has not been programmed yet.");
	}
    }

    private void printLookAtItemResult() {
	String i = lastInput.split(" ")[-1];
	for (Item item : character.inventory) {
	    if (item.name == i) {
		System.out.println(item.description);
	    }
	}
	for (Item item : character.location.items) {
	    if (item.name == i) {
		System.out.println(item.description);
	    }
	}
    }
    
    private Command getCommand() {
	Command c;
	while (true) {
	    lastInput = scanner.nextLine();
	    c = ReadOnly.parseCommand(lastInput);
	    if (c != null) {
		return c;
	    } else {
		System.out.println(
			"Command not recognized. Please try again, or type 'help'.");
	    }
	}

    }

    private boolean getBool() {
	Command tempCommand = ReadOnly.parseCommand(scanner.next());
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
