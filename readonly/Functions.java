/**
 * Miscellaneous static functions
 * @author Joshua Nelson
 * @version 0.2 (c. 2017-09-21)
 * @email jyn514@gmail.com
 * Copyright (C) 2017  Joshua Nelson
 */
package readonly;

import java.util.Set;
import adventure.Command;

public final class Functions {
    
    //  If string is somewhere in Mappings.synonyms, it returns the corresponding Command.
    public static final Command parseCommand(String s) {

	for (Set<String> array : Mappings.synonyms.keySet()) {
	    if (array.contains(s)) {
		return Mappings.synonyms.get(array);
	    }
	}

	return null;
    }
    
    public static final Command parseCommand(String s, adventure.Room r) {
	for (Set<String> array : Mappings.locationBasedSynonyms.keySet()) {
	    if (array.contains(s) && r.actions.contains(Mappings.locationBasedSynonyms.get(array))) {
		return Mappings.locationBasedSynonyms.get(array);
	    }
	}
	
	return parseCommand(s);
    }
    
    // return (as string) all synonyms with one letter only
    public static final String getOneLetterKeys() {
	StringBuilder b = new StringBuilder();
	for (Set<String> array : Mappings.synonyms.keySet()) {
	    for (String s : array) {
		if (s.length() == 1) {
		   b.append(String.format("%s maps to the command %s\n", s, Mappings.synonyms.get(array)));
		}
	    }
	}
	return b.toString();
    }
}
