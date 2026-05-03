package it.unime.orbita1.entity.module;

/**
 *  Medical Bay module
 * The Medical Bay is the hospital of the space station, responsible for healing crew members,
 * OOP concepts:
 * - Encapsulation: The Medical Bay module's properties (name, integrity, operational status) are private and accessed through public methods.
 * - Inheritance: The Medical Bay class extends the abstract StationModule class, inheriting its properties and methods while providing specific implementations for the MedicalBay's behavior.
 * - Polymorphism: The Medical Bay class overrides the onTick() method from the StationModule class to define specific behavior that occurs each game tick, allowing for different module types to have unique functionalities.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public final class MedicalBay extends StationModule{

    /**
     * Constructs a Medical Bay module with the name "MedicalBay".
     * OOP concept: Constructor — initializes the Medical Bay module with a specific name.
     */
    public MedicalBay(){
        super("Medical Bay");
    }
    

    /**
     * Defines the specific behavior for the MedicalBay module on each game tick. This could include monitoring station status, providing bonuses to crew members, or other unique functionalities related to the MedicalBay.
     * OOP concept: Method Override — this method provides a specific implementation of the onTick() method defined in the StationModule class.
     */
    @Override
    public void onTick(){
        //TODO: implemant Medical Bay in game behavior here
    }
     
}