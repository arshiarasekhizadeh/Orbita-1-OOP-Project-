package it.unime.orbita1.entity.module;

/**
 * ENGINE ROOM MODULE
 * The Engine Room is responsible for powering the space station and maintaining its propulsion systems. It is a critical module that ensures the station can maneuver and maintain its orbit. The Engine Room can be damaged by various events, which can affect its integrity and operational status. If the Engine Room is damaged, it may impact the station's ability to maneuver and maintain its orbit effectively.
 * OOP concepts:
 * - Encapsulation: The Engine Room module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The Engine Room class extends the abstract StationModule class, inheriting
 * its properties and methods while providing specific implementations for the Engine Room's behavior.
 * - Polymorphism: The Engine Room class overrides the onTick() method from the Station
 *  Module class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class EngineRoom extends StationModule
{
    /**
     * Constructs an Engine Room module with the name "Engine Room".
     * OOP concept: Constructor — initializes the Engine Room module with a specific name.
     */
    public EngineRoom() {
        super("Engine Room");
    }
        
    /**
     * Defines the specific behavior for the Engine Room module on each game tick. This could include monitoring engine status, providing bonuses to crew members, or other unique functionalities related to the Engine Room.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick() {
        //TODO: Implement specific behavior for the Engine Room module on each game tick, such as monitoring engine status or providing bonuses to crew members.
    }
}