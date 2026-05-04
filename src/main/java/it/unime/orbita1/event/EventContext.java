package it.unime.orbita1.event;
import java.util.List;

import it.unime.orbita1.entity.crew.CrewMember;
import it.unime.orbita1.entity.module.StationModule;


/**
 * EventContext interface
 * The EventContext interface provides the necessary context for handling events within the space station simulation. It allows event handlers to access the current state of the station, including its modules and crew members, as
 * well as to schedule new events and log messages. This interface is crucial for implementing the event-driven architecture of the simulation, enabling dynamic interactions and responses to various events that may occur.
 * OOP concepts:
 * - Interface: The EventContext is an interface that defines a contract for event handling, allowing different implementations to provide the necessary context for events without being tied to a specific class hierarchy.
 * - Abstraction: The EventContext abstracts away the details of how the station's state is managed and accessed, providing a simplified interface for event handlers to interact with the station's modules and crew
 * members, as well as to schedule events and log messages, without needing to know the underlying implementation details.
 * 
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public interface EventContext {

    /**
     * Returns a list of the station's modules, allowing event handlers to access and interact with the various modules present in the station. This method is essential for events that may affect specific modules or require information about the station's current configuration.
     * @return
     */
    List<StationModule> getModules();

    /**
     * Returns a list of the station's crew members, allowing event handlers to access and interact with the crew members present in the station. This method is crucial for events that may affect specific crew members or require information about the crew's current status.
     * @return
     */
    List<CrewMember> getCrew();

    /**
     * Schedules a new event to be processed by the simulation. This method allows event handlers to create and schedule new events in response to the current event being handled, enabling dynamic interactions and responses within the simulation.
     * @param event The SimulationEvent to be scheduled.
     */
    void scheduleEvent(SimulationEvent event);

    /**
     * Logs a message to the simulation's log.
     * @param message The message to be logged.
     */
    void log(String message);

    /**
     * Returns the current tick of the simulation.
     * @return The current tick.
     */
    long getCurrentTick();

}