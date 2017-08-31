/**
 * Various static functions for dealing with strings
 *
 * @author Joshua Nelson
 * @version 0.1 (2017-08-30)
 * @email jyn514@gmail.com
 * Copyright (C) 2017  Joshua Nelson
 *
 */
package readonly;

import java.util.Arrays;
import java.util.List;

public final class StringManipulation {

    private static final List<java.lang.Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    private static final List<String> VOWEL_EXCEPTIONS = Arrays.asList("university", "one", "once");

    private static final List<String> CONSONANT_EXCEPTIONS = Arrays.asList("hour");

    public static final boolean shouldBeAn(String s) {
	if (VOWELS.contains(s.charAt(0))) { // starts with a vowel
	    if (VOWEL_EXCEPTIONS.contains(s)) {
		return false;
	    } 
	    return true;
	} else {
	    if (CONSONANT_EXCEPTIONS.contains(s)) {
		return true;
	    }
	    return false;
	}
    }
}
