package it.unime.orbita1.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import it.unime.orbita1.entity.crew.CrewMember;
import it.unime.orbita1.entity.module.StationModule;

/**
 * The GameStateWriter class is responsible for writing the current state of the game to a file. It takes a list of station modules, a list of crew members, the current tick of the simulation, and a file path as input, and writes this information in a structured format to the specified file. This allows for saving the game state at any point in time, which can be useful for debugging, logging, or implementing a save/load feature in the game.
 * OOP concepts:
 * - Encapsulation: The GameStateWriter class encapsulates the functionality of writing the game state
 * to a file, providing a single method that takes all necessary information as parameters and handles the file writing process internally.
 * - Abstraction: The GameStateWriter class abstracts the details of how the game state is written to a file, allowing other parts of the code to simply call the write method without needing to understand the specifics of file handling or the format of the output.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class GameStateWriter {

    /**
     * Writes the current state of the game to a file. This method takes a list of station modules, a list of crew members, the current tick of the simulation, and a file path as input. It writes the current tick, the state of each station module (including its name, integrity, and operational status), and the state of each crew member (including their name, role, health, stress level, and alive status) to the specified file in a structured format. The method handles potential IO exceptions that may occur during file writing and ensures that the writer is properly closed after the operation. 
     * @param modules the list of station modules to be written to the file
     * @param crew the list of crew members to be written to the file
     */
    public static void write(
            final List<StationModule> modules,
            final List<CrewMember> crew,
            final long currentTick,
            final String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("TICK=" + currentTick);
            writer.newLine();

            for (StationModule module : modules) {
                writer.write("MODULE=" + module.getName() + "," + module.getIntegrity() + "," + module.isOperational());
                writer.newLine();
            }

            for (CrewMember member : crew) {
                writer.write("CREW=" + member.getName() + "," + member.getRole() + "," + member.getHealth() + "," + member.getStressLevel() + "," + member.isAlive());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}