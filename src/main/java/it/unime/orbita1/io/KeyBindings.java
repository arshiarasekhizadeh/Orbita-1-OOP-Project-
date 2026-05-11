package it.unime.orbita1.io;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * The KeyBindings class manages the mapping of actions to specific keys for user input in the application. It allows for retrieving the key associated with a given action, setting new key bindings, and saving/loading key bindings to/from a file. This class encapsulates the key binding functionality, providing a simple interface for managing user input configurations.
 * OOP concepts:
 * - Encapsulation: The KeyBindings class encapsulates the mapping of actions to keys, providing methods to interact with this mapping without exposing the underlying data structure directly.
 * - Abstraction: The KeyBindings class abstracts the concept of key bindings, allowing users to set and retrieve key mappings without needing to understand how they are stored or managed internally.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class KeyBindings{
    private final Map<String, String> bindings = new HashMap<>();

    /** Initializes the KeyBindings instance with default key bindings for various actions. This constructor populates the bindings map with predefined key mappings for selecting crew members, giving commands, interacting, and pausing the game. These default bindings can be modified later using the setKey method or by loading from a file. 
     * The default key bindings are as follows:
     * - SELECT_CREW_1: "1"
     * - SELECT_CREW_2: "2"
     * - SELECT_CREW_3: "3"
     * - SELECT_CREW_4: "4"
     * - GIVE_COMMAND: "MOUSE_LEFT"
     * - INTERACT: "E"
     * - PAUSE: "P"
    */

    public KeyBindings(){
        this.bindings.put("SELECT_CREW_1", "1");
        this.bindings.put("SELECT_CREW_2", "2");
        this.bindings.put("SELECT_CREW_3", "3");
        this.bindings.put("SELECT_CREW_4", "4");
        this.bindings.put("GIVE_COMMAND", "MOUSE_LEFT");
        this.bindings.put("INTERACT", "E");
        this.bindings.put("PAUSE", "P");
        
    }

    /** Retrieves the key associated with a given action. This method checks if the specified action has a key binding in the bindings map and returns it. If the action is not found, it returns "UNBOUND" to indicate that there is no key assigned to that action. 
     * @param action the name of the action for which to retrieve the key binding
     * @return the key associated with the specified action, or "UNBOUND" if no binding exists
    */
    public String getKey(final String action){
        return bindings.get(action) != null ? bindings.get(action) : "UNBOUND";
    }

    /** Sets a new key binding for a specified action. This method updates the bindings map with the provided action and key, allowing users to customize their key bindings as needed. If the action already has a key binding, it will be overwritten with the new key. 
     * @param action the name of the action for which to set the key binding
     * @param key the key to associate with the specified action
    */
    public void setKey(final String action, final String key){
        bindings.put(action, key);
    }

    /** Retrieves an unmodifiable view of the current key bindings. This method returns a read-only map of the action-to-key mappings, allowing users to view the current key bindings without being able to modify them directly. This promotes encapsulation by preventing external code from altering the internal state of the KeyBindings instance. 
     * @return an unmodifiable map containing the current action-to-key bindings
    */
    public Map<String, String> getBindings() {
        return java.util.Collections.unmodifiableMap(bindings);
    }


    /** Saves the current key bindings to a file. This method writes the contents of the bindings map to a specified file, with each line containing an action and its associated key in the format "action=key". It handles potential IO exceptions that may occur during file writing and ensures that the writer is properly closed after the operation. 
     * @param filePath the path to the file where the key bindings should be saved
    */
    public void saveToFile(final String filePath){
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : bindings.entrySet()) {
            writer.write(entry.getKey() + "=" + entry.getValue());
            writer.newLine();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            }
        }

    /**
     * load key bindings from a file. This method reads key bindings from a specified file, where each line is expected to be in the format "action=key". It populates a new KeyBindings instance with the loaded key bindings and returns it. The method handles potential IO exceptions that may occur during file reading and ensures that the reader is properly closed after the operation.
     * @param filePath the path to the file from which to load the key bindings
     * @return keybinings from the file 
     */
    public static KeyBindings loadFromFile(final String filePath){
        KeyBindings keyBindings = new KeyBindings();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyBindings.setKey(parts[0], parts[1]);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return keyBindings;
    }
}
