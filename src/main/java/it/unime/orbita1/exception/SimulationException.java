package it.unime.orbita1.exception;

/**
 * Base exception for all errors that occur inside the Orbita-1 simulation.
 *
 * Extends RuntimeException so it does not need to be declared in every
 * method signature, while still being clearly distinct from a generic
 * RuntimeException.
 *
 * All other simulation exceptions extend this class, forming a typed
 * exception hierarchy that the engine can catch selectively.
 *
 * OOP concept: Inheritance — this class is the root of the exception
 * hierarchy. StationDestroyedException extends this class.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public class SimulationException extends RuntimeException {

    /**
     * Constructs a SimulationException with a detail message.
     *
     * @param message description of what went wrong
     */
    public SimulationException(final String message) {
        super(message);
    }

    /**
     * Constructs a SimulationException that wraps a lower-level cause.
     *
     * @param message description of what went wrong
     * @param cause   the underlying exception
     */
    public SimulationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}