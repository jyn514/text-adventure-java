package adventure;

/**
 * Enumeration class Commands - inputs player can legally give
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */
public enum Command {
    // global 
    INSPECT, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION, HELP, YES, NO, KEYS,
    // location based
    DOOR, CHEST, TAKE, NEXT, PREVIOUS, SNOW, CLIMB
}
