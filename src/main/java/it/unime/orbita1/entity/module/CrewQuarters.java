package it.unime.orbita1.entity.module;

/**
 * CrewQuarters module
 * The CrewQuarters are the living quarters for the crew members on the space station. They provide a comfortable living environment and can be damaged by various events, which can affect the crew's well-being and operational status.
 * OOP concepts:
 * - Encapsulation: The CrewQuarters module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The CrewQuarters class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the CrewQuarters' behavior.
 * - Polymorphism: The CrewQuarters class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class CrewQuarters extends StationModule{
    /**
     * Constructs a CrewQuarters module with the name "CrewQuarters".
     * OOP concept: Constructor — initializes the CrewQuarters module with a specific name.
     */
    public CrewQuarters() {
        super("Crew Quarters");
    }

    /**
     * Defines the specific behavior for the CrewQuarters module on each game tick. This could include monitoring crew quarters status, providing bonuses to crew members, or other unique functionalities related to the CrewQuarters.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick() {
        //TODO: Implement specific behavior for the CrewQuarters module on each game tick, such as monitoring crew quarters status or providing bonuses to crew members.
    }
}