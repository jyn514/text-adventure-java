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

import java.util.Set;
import adventure.Command;

public final class Functions {
    public static final Command parseCommand(String s) {

	s = s.toLowerCase();

	for (Set<String> array : Mappings.synonyms.keySet()) {
	    if (array.contains(s)) {
		return Mappings.synonyms.get(array);
	    }
	}
	return null;
    }
}
