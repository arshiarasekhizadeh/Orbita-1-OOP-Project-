package it.unime.orbita1.entity.module;

/**
 * Airlock module
 * The Airlock is the entry and exit point for crew members on the space station. It is responsible for maintaining the station's atmosphere and allowing crew members to safely enter and exit the station. The Airlock can be damaged by various events, which can affect its integrity and operational status. If the Airlock is damaged, it may impact the station's ability to maintain its atmosphere and allow crew members to safely enter and exit.
 * OOP concepts:
 * - Encapsulation: The Airlock module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The Airlock class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the Airlock's behavior.
 * - Polymorphism: The Airlock class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class Airlock extends StationModule{
    /**
     * Constructs an Airlock module with the name "Airlock".
     * OOP concept: Constructor — initializes the Airlock module with a specific name.
     */
    public Airlock() {
        super("Airlock");
    }
    
    /**
     * Defines the specific behavior for the Airlock module on each game tick. This could include monitoring airlock status, providing bonuses to crew members, or other unique functionalities related to the Airlock.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick() {
        //TODO: Implement specific behavior for the Airlock module on each game tick, such as monitoring airlock status or providing bonuses to crew members.
    }   
}