/**
 * Exception for anything I want to include but haven't yet
 * @author Joshua Nelson
 * @version 0.2 (2017-09-21)
 * @email jyn514@gmail.com
 * Copyright (C) 2017  Joshua Nelson
 */
package readonly;

public final class NotImplementedException extends RuntimeException {
    private static final long serialVersionUID = 7481020976662341249L;
    private static final String notImplemented = "This area of the game has not yet been implemented.\n"
	    + "File a complaint here: https://github.com/jyn514/text-adventure-java/issues\n";

    public NotImplementedException() {
	super(notImplemented);
    }

    public NotImplementedException(String message) {
	super(notImplemented + message);
    }
}