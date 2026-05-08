package it.unime.orbita1.event;

/**
 * Provides a base class for all simulation events in the space station management game. Each event has a trigger tick, which indicates when the event should occur in the simulation timeline, and a name for identification.
 * The SimulationEvent class implements the Comparable interface to allow events to be sorted based on their trigger tick, ensuring that events are executed in the correct order during the simulation. Subclasses of SimulationEvent will implement the execute method to define the specific actions that occur when the event is triggered.
 * OOP concepts:
 * - Abstraction: SimulationEvent is an abstract class that defines a common structure for all events
 * - Inheritance: Specific event types will inherit from SimulationEvent and implement the execute method to provide their unique behavior.
 * 
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public abstract class SimulationEvent implements Comparable<SimulationEvent> {

    /** The tick at which the event should be triggered in the simulation timeline. */
    private final long triggerTick ;
    private final String name;


    /**
     * Constructs a SimulationEvent with the specified trigger tick and name.
     *
     * @param triggerTick the tick at which the event should be triggered; must be non-negative
     * @param name the name of the event; must not be null or empty
     * @throws IllegalArgumentException if triggerTick is negative or if name is null or empty
     */
    public SimulationEvent(final long triggerTick, final String name) {
        if (triggerTick < 0) {
            throw new IllegalArgumentException("Trigger tick cannot be negative.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be null or empty.");
        }
        this.name = name;
        this.triggerTick = triggerTick;
        
    }
    /**
     * Executes the event's actions based on the provided context. This method must be implemented by all subclasses to define the specific behavior of the event when it is triggered.
     *
     * @param context the context in which the event is executed, providing necessary information and resources for the event's actions
     */
    public abstract void execute(EventContext context);

    /** Returns the tick at which the event is scheduled to be triggered.
     * This method allows other components of the simulation to determine when the event should occur and to manage the scheduling of events accordingly.
     * @return the trigger tick of the event
     */
    public long getTriggerTick() {
        return triggerTick;
    } 

    /** Returns the name of the event. 
     * This method provides a way to identify the event, which can be useful for logging, debugging, or displaying information about the event in the user interface.
     * @return the name of the event
    */
    public String getName() {
        return name;
    }


    /** Compares this event with another event based on their trigger ticks for sorting purposes.
     * This method allows events to be ordered in a priority queue or sorted list, ensuring that events are executed in the correct sequence according to their scheduled trigger times.
     * @param other the other SimulationEvent to compare against
     * @return a negative integer, zero, or a positive integer as this event's trigger tick is less than, equal to, or greater than the other event's trigger tick
     * @throws NullPointerException if the other event is null
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(SimulationEvent other) {
        return Long.compare(this.triggerTick, other.triggerTick);
    }

    /** Returns a string representation of the event, including its name and trigger tick. 
     * This method provides a human-readable description of the event, which can be useful for logging, debugging, or displaying information about the event in the user interface.
     * @return a string representation of the event
    */
    @Override
    public String toString() {
        return String.format("Event{name='%s', triggerTick=%d}", name, triggerTick);
    }

}