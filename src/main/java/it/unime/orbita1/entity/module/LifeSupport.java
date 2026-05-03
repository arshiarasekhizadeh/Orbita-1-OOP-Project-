package it.unime.orbita1.entity.module;


/** 
 * Life Support module
 * The Life Support is the oxygen provider module of the space station, responsible for providing the oxygen,
 * OOP concepts:
 * - Encapsulation: The Life Support module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The Life Support class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the LifeSupport's behavior.
 * - Polymorphism: The Life Support class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class LifeSupport extends StationModule {
    


    /**
     * Constructs a LifeSupport module with the name "LifeSupport".
     * OOP concept: Constructor — initializes the Bridge module with a specific name.
     */
    public LifeSupport(){
        super("Life Support");
    }


    /**
     * Defines the specific behavior for the LifeSupport module on each game tick. This could include monitoring station status, providing bonuses to crew members, or other unique functionalities related to the LifeSupport.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick(){
        //TODO : implemant on tick functionalty here
    }
}

