package adventure;

/**
 * Enumeration class Commands - input from player
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */
public enum Command {
    // global actions
    KEYS, INSPECT, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION, HELP, YES, NO,
    // room-based actions
    DOOR, CHEST, TAKE, NEXT, PREVIOUS, SNOW, CLIMB
}
