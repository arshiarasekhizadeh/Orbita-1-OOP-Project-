package it.unime.orbita1.entity.module;

/**
 * BRIDGE MODULE
 * The Bridge is the central command module of the space station, responsible for navigation, communication,
 * and overall station management. It is a critical module that provides essential functions for the operation of the station. The Bridge can be damaged by various events, which can affect its integrity and operational status. If the Bridge is damaged, it may impact the station's ability to navigate, communicate, and manage resources effectively.
 * OOP concepts:
 * - Encapsulation: The Bridge module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The Bridge class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the Bridge's behavior.
 * - Polymorphism: The Bridge class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class Bridge extends StationModule
{
    /**
     * Constructs a Bridge module with the name "Bridge".
     * OOP concept: Constructor — initializes the Bridge module with a specific name.
     */
    public Bridge() {
        super("Bridge");
    }
        
    /**
     * Defines the specific behavior for the Bridge module on each game tick. This could include monitoring station status, providing bonuses to crew members, or other unique functionalities related to the Bridge.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick() {
    //TODO: Implement specific behavior for the Bridge module on each game tick, such as monitoring station status or providing bonuses to crew members.
    }
}