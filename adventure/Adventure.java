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

import java.util.Scanner;

public class Adventure {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	System.out.println("Adventure  Copyright (C) 2017 Joshua Nelson");
	System.out.println("This program comes with ABSOLUTELY NO WARRANTY.");
	System.out
		.println("This is free software, and you are welcome to redistribute it");
	System.out
		.println("under certain conditions; see LICENSE for details.\n\n");

	System.out.println("Welcome to adventure!");
	/*
	 * System.out.print("Choose a name for your character: "); Character
	 * character = new Character(scanner.next());
	 */
	System.out.print("Would you like to read the intro? (y/n): ");
	if (parseBoolWithErrorHandling()) {
	    ReadOnly.Intro();
	} else {
	    System.out.println("Skipping all loading sequences.");
	}
	throw new NotImplementedException();

    }

    private static boolean parseBoolWithErrorHandling() {
	Command tempCommand;

	try {
	    tempCommand = ReadOnly.parseCommand(scanner.next());
	} catch (IllegalArgumentException e) {
	    System.out.print("Please type yes or no.");
	    return parseBoolWithErrorHandling();
	}

	if (tempCommand == Command.YES) {
	    return true;
	} else if (tempCommand == Command.NO) {
	    return false;
	} else {
	    throw new IllegalStateException();
	}
    }

    private static final class NotImplementedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7481020976662341249L;

	NotImplementedException() {
	    super("This area of the game has not yet been implemented.");
	}
	
    }
}
