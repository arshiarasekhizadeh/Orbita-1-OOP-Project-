package it.unime.orbita1.exception;


/**
 * Exception thrown when a station is destroyed during the simulation.
 *
 * This is a specific type of SimulationException that indicates a critical
 * failure in the simulation, such as a station being destroyed. It can be
 * used to trigger specific error handling or recovery mechanisms in the engine.
 *
 * OOP concept: Inheritance — this class extends SimulationException, making it
 * part of the exception hierarchy and allowing it to be caught as either a
 * StationDestroyedException or a more general SimulationException.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class StationDestroyedException extends SimulationException {
    /**
     * Constructs a StationDestroyedException with a detail message.
     *
     * @param message description of what went wrong
     */
    public StationDestroyedException(final String message) {
        super("STATION DESTROYED — " + message);
    }

    /**
     * Constructs a StationDestroyedException that wraps a lower-level cause.
     *
     * @param message description of what went wrong
     * @param cause   the underlying exception
     */
    public StationDestroyedException(final String message, final Throwable cause) {
        super("STATION DESTROYED — " +  message, cause);
    }
}