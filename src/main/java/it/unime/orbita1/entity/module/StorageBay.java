package it.unime.orbita1.entity.module;

/**
 * StorageBay module
 * The StorageBay is where supplies and equipment are stored on the space station. It is important for maintaining the station's inventory and ensuring that crew members have access to necessary resources. The StorageBay can be damaged by various events, which can affect its integrity and operational status. If the StorageBay is damaged, it may impact the station's ability to store and distribute supplies.
 * OOP concepts:
 * - Encapsulation: The StorageBay module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The StorageBay class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the StorageBay's behavior.
 * - Polymorphism: The StorageBay class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class StorageBay extends StationModule{
    /**
     * Constructs a StorageBay module with the name "StorageBay".
     * OOP concept: Constructor — initializes the StorageBay module with a specific name.
     */
    public StorageBay() {
        super("Storage Bay");
    }           

    /**
     * Defines the specific behavior for the StorageBay module on each game tick. This could include monitoring storage status, providing bonuses to crew members, or other unique functionalities related to the StorageBay.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */    
    @Override
    public void onTick(){
        //TODO: Implement specific behavior for the StorageBay module on each game tick, such as monitoring storage status or providing bonuses to crew members.
    }
}