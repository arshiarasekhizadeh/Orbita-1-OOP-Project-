package it.unime.orbita1.simulation;
import it.unime.orbita1.exception.SimulationException;



/**
 * The SimulationClock class manages the
 * current tick of the simulation, allowing it to advance to a specific tick, reset to the initial state, and provide a string representation of the current tick. It also includes error handling to prevent moving back in time and to signal invalid operations.
 * OOP concepts:
 * - Encapsulation: The SimulationClock class encapsulates the current tick and provides methods to manipulate
 *  it, ensuring that the internal state is protected and can only be modified through defined methods.
 * - Abstraction: The SimulationClock class abstracts the concept of time in the simulation, providing
 *  a simple interface for advancing time and resetting the clock without exposing the underlying implementation details.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class SimulationClock{

    /** The current tick of the simulation, representing the current point in time within the simulation timeline. */
    private long currentTick = 0;

    /** Returns the current tick of the simulation. This method allows other components of the simulation to query the current time and make decisions based on it. 
     * @return the current tick of the simulation
    */
    public long getCurrentTick() {
        return currentTick;
    }

    /** Advances the simulation clock to the specified tick. This method checks if the provided tick is valid (not in the past) and updates the current tick accordingly. If an attempt is made to move back in time, an IllegalArgumentException is thrown to signal the error. 
     * @param tick the tick to which the simulation clock should be advanced; must be greater than or equal to the current tick
     * @throws IllegalArgumentException if the provided tick is less than the current tick
    */
    public void advanceTo(final long tick) {
        if (tick < currentTick) {
            throw new SimulationException("Cannot move back in time. Current tick: " + currentTick + ", attempted tick: " + tick);
        }
        currentTick = tick;
    }

    

    /** Resets the simulation clock to the initial state (tick 0). This method can be used to restart the simulation or to return to a known starting point. 
     * After calling this method, the current tick will be set back to 0, allowing the simulation to begin anew.
    */
    public void reset() {
        currentTick = 0;
    }


    /** Returns a string representation of the simulation clock, including the current tick. This method provides a human-readable description of the simulation clock's state, which can be useful for logging, debugging, or displaying information about the current time in the user interface. 
     * @return a string representation of the simulation clock
    */
    @Override
    public String toString() {
        return String.format("T+%05d", currentTick);
    }
} 