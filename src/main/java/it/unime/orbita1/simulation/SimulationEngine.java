package it.unime.orbita1.simulation;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import it.unime.orbita1.exception.SimulationException;
import it.unime.orbita1.entity.crew.CrewMember;
import it.unime.orbita1.entity.module.StationModule;
import it.unime.orbita1.event.EventContext;
import it.unime.orbita1.event.SimulationEvent;



/****
 * The SimulationEngine class is responsible for managing the simulation of the space station management game. It maintains the simulation clock, processes scheduled events, updates the state of station modules and crew members, and provides an interface for scheduling new events. The engine runs in a separate thread, allowing it to advance the simulation over time while ensuring that events are executed in the correct order based on their trigger ticks.
 * OOP concepts:
 * - Encapsulation: The SimulationEngine class encapsulates the logic for managing the simulation, including event processing and state updates, while providing a clear interface for interacting with the simulation.
 * - Inheritance: The SimulationEngine class implements the Runnable interface to allow it to run in a separate thread, enabling concurrent execution of the simulation.
 * - Polymorphism: The use of SimulationEvent allows for different types of events to be scheduled and executed without needing to know their specific implementations, as long as they adhere to the SimulationEvent interface.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class SimulationEngine implements EventContext, Runnable {

    private final SimulationClock clock = new SimulationClock();
    private final PriorityQueue<SimulationEvent> eventQueue = new PriorityQueue<>();
    private final List<StationModule> modules;
    private final List<CrewMember> crewMembers;
    private final long missionDurationTicks;
    private final AtomicBoolean running = new AtomicBoolean(false);

    /**
     * Constructs a SimulationEngine with the specified mission duration, station modules, and crew members. The constructor initializes the simulation engine with the provided parameters and validates that the mission duration is positive. The station modules and crew members are stored in lists for later use during the simulation.
     * OOP concept: Constructor — initializes the simulation engine's state based on the provided parameters
     * @param missionDurationTicks the total duration of the mission in ticks; must be positive
     * @param modules the list of station modules to be included in the simulation
     * @param crewMembers the list of crew members to be included in the simulation
     * @throws IllegalArgumentException if missionDurationTicks is not positive
     */
    public SimulationEngine(final long missionDurationTicks, final List<StationModule> modules, final List<CrewMember> crewMembers) {
        if (missionDurationTicks <= 0) {
            throw new IllegalArgumentException("Mission duration must be positive");
        }
        this.missionDurationTicks = missionDurationTicks;
        this.modules = modules;
        this.crewMembers = crewMembers;
    }


    /** Returns all station modules.
     * @return list of station modules
    */
    @Override
    public List<StationModule> getModules() { return modules; }
    /** Returns all crew members.
     * @return list of crew members
    */
    @Override
    public List<CrewMember> getCrew() { return crewMembers; }
    /** Returns the current tick of the simulation clock.
     * @return the current tick of the simulation
    */
    @Override
    public long getCurrentTick() { return clock.getCurrentTick(); }
    /** Logs a message related to the simulation. This method can be used by events, modules, or crew members to output information about their actions or the state of the simulation. The specific implementation of the logging mechanism is left as a TODO, allowing for flexibility in how logging is handled (e.g., console output, file logging, etc.).
     * OOP concept: Method — this method provides an interface for logging messages related to the simulation, which can be implemented in various ways depending on the needs of the application
     * @param message the message to be logged
    */
    @Override
    public void log(final String message) { /* TODO */ }

    /** Processes all events that are scheduled to occur at the current tick of the simulation. This method checks the event queue for any events whose trigger tick is less than or equal to the current tick and executes them in order. After processing an event, it is removed from the queue. This ensures that events are executed at the correct time during the simulation.
     * OOP concept: Method — this method encapsulates the logic for processing scheduled events based on their trigger ticks
    */
    private void processEvents() {
        while (!eventQueue.isEmpty() && eventQueue.peek().getTriggerTick() <= clock.getCurrentTick()) {
            SimulationEvent event = eventQueue.poll();
            event.execute(this);
        }
    }

    /** Updates the state of all station modules by calling their onTick() method. This method is called once per tick during the simulation to allow each module to perform any necessary updates or actions based on the passage of time. The specific behavior of each module's onTick() method will depend on the implementation of the module, allowing for polymorphic behavior across different types of modules.
     * OOP concept: Method — this method encapsulates the logic for updating the state of station modules based on the passage of time
    */
    private void updateModules() {
        for (StationModule module : modules) {
            module.onTick();
        }
    }
    /** Updates the state of all crew members by calling their performDuty() method. This method is called once per tick during the simulation to allow each crew member to perform their specific duties based on their role and the current state of the station. The specific behavior of each crew member's performDuty() method will depend on the implementation of the crew member, allowing for polymorphic behavior across different types of crew members.
     * OOP concept: Method — this method encapsulates the logic for updating the state of crew members based on their duties and the passage of time
    */
    private void updateCrewMembers() {
        for (CrewMember crewMember : crewMembers) {
            crewMember.performDuty();
        }
    }


    /** Schedules a new event to be executed at its specified trigger tick. This method checks if the event's trigger tick is valid (not in the past) and adds it to the event queue. If an attempt is made to schedule an event in the past, a SimulationException is thrown to signal the error. This method allows other components of the simulation to schedule events that will be processed at the appropriate time during the simulation.
     * OOP concept: Method — this method provides an interface for scheduling new events while ensuring that they are scheduled correctly based on their trigger ticks
    */
    @Override
    public void scheduleEvent(final SimulationEvent event) {
        if (event.getTriggerTick() < clock.getCurrentTick()) {
            throw new SimulationException("Cannot schedule event in the past. Current tick: " + clock.getCurrentTick() + ", event tick: " + event.getTriggerTick());
        }
        eventQueue.add(event); 
    }


    /** Starts the simulation by running the SimulationEngine in a separate thread. This method checks if the simulation is already running and throws a SimulationException if it is. If the simulation is not already running, it sets the running flag to true and starts a new thread that executes the run() method of the SimulationEngine. This allows the simulation to advance over time while processing events and updating the state of modules and crew members concurrently.
     * OOP concept: Method — this method manages the lifecycle of the simulation, allowing it to be started and stopped as needed
    */
    public void start() {
        if (running.get()) {
            throw new SimulationException("Simulation is already running");
        }
        running.set(true);
        new Thread(this).start();
    }
    /**
     * Stops the simulation by setting the running flag to false. This method can be called to gracefully stop the simulation, allowing the run() method to exit its loop and terminate the simulation thread. Once this method is called, the simulation will no longer advance or process events, effectively pausing or ending the simulation as needed.
     * OOP concept: Method — this method manages the lifecycle of the simulation, allowing it to be stopped gracefully when desired
     */
    public void stop() {
        running.set(false);
    }


    /** The main loop of the simulation engine, which advances the simulation over time. This method is executed in a separate thread when the simulation is started. It continuously processes events, updates the state of modules and crew members, and advances the simulation clock until the mission duration is reached or the simulation is stopped. The method includes error handling for InterruptedException to ensure that the thread can be interrupted gracefully if needed.
     * OOP concept: Method — this method encapsulates the core logic of advancing the simulation over time while managing events and state updates
     * @throws InterruptedException if the thread is interrupted while sleeping, allowing for graceful shutdown of the simulation 
     */
    @Override
    public void run() {
        try {
            while (running.get() && clock.getCurrentTick() < missionDurationTicks) {
                Thread.sleep(50);
                processEvents();
                updateModules();
                updateCrewMembers();
                clock.advanceTo(clock.getCurrentTick() + 1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            running.set(false); 
        }
    }
    
}