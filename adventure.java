
/**
 * Main file
 *
 * @author Joshua Nelson
 * @version 2017-8-14
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class adventure
{
    private static final Map<List<String>, Command> synonyms = createSynonyms();

    
    public static void main()
    {
    }
    
    private static final Map<List<String>, Command> createSynonyms() 
    {
        Map<List<String>, Command> tempSynonyms = new HashMap<List<String>, Command>();
        
        List<String> yes = Arrays.asList(new String[] {"yes", "y", "ok"});
        List<String> no =  Arrays.asList(new String[] {"no", "n"});
        List<String> quit = Arrays.asList(new String[] {"close", "quit", "q", "exit", "quit()", "exit()"});
        List<String> look =  Arrays.asList(new String[] {"look", "look around", "l", "look at", "inspect", "inspect the"});
        List<String> help = Arrays.asList(new String[] {"?", "help", "h", "info", "hint"});
        List<String> inventory = Arrays.asList(new String[] {"inventory", "get inventory", "carrying", "show items", "i", "items"});
        List<String> drink = Arrays.asList(new String[] {"drink", "drink water", "water", "water bottle"});
        List<String> keys = Arrays.asList(new String[] {"shortcuts", "hotkeys", "keybindings", "keys", "keyboard", "keymap"});
        List<String> light =  Arrays.asList(new String[] 
        {   // please keep this list in order
            "use flashlight", "l",
            "light", "light flashlight", "turn on flashlight",  "turn flashlight on",  "flashlight on", "turn on light", "turn light on", 
            "dim",   "dim flashlight",   "turn off flashlight", "turn flashlight off", "flashlight off","turn off light", "turn light off"
        });
        
        tempSynonyms.put(yes, Command.YES);
        tempSynonyms.put(no, Command.NO);
        tempSynonyms.put(quit, Command.QUIT);
        tempSynonyms.put(look, Command.LOOK);
        tempSynonyms.put(light, Command.LIGHT);
        tempSynonyms.put(help, Command.HELP);
        tempSynonyms.put(inventory, Command.INVENTORY);
        tempSynonyms.put(drink, Command.DRINK);
        tempSynonyms.put(keys, Command.KEYS);
        
        // INSPECT, KEYS, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION, HELP, YES, NO
        return tempSynonyms;
    }

    private static final Command parseCommand(String s)
    {
        for (List<String> array : synonyms.keySet()) 
        {
            if (array.contains(s)) {
                return synonyms.get(array);
            }
        }
        return null;
    }

}
