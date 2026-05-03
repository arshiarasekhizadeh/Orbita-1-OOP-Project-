package it.unime.orbita1.entity.module;



/**
 * Represents a module on the space station. Each module has a name, integrity level, and operational status. Modules can take damage and be repaired, which affects their integrity and operational status. The onTick() method is abstract and must be implemented by subclasses to define specific behavior that occurs each game tick.
 * OOP concepts:
 * - Encapsulation: Module properties are private and accessed through public methods.
 * - Inheritance: This is an abstract class that will be extended by specific module types.
 * - Polymorphism: The onTick() method is abstract, allowing different module types to implement it in their own way.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public abstract class StationModule
{
    private final String name;

    private int integrity = 100; 

    private boolean isOperational = true; 

    /**
     * Constructs a StationModule with the specified name.
     * OOP concept: Constructor — initializes the module's name and sets default values for integrity and operational status.
     * @param name the name of the module
     */
    public StationModule(final String name) {
        java.util.Objects.requireNonNull(name, "Module name cannot be null");
        this.name = name;
    }


    /**
     * Applies damage to the module, reducing its integrity. If integrity drops to 0 or below, the module becomes non-operational.
     * OOP concept: Method — this method modifies the state of the module based on the damage taken.
     * @param damage the amount of damage to apply
     * @throws IllegalArgumentException if damage is negative
     */
    public void applyDamage(final int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        integrity -= damage;
        if (integrity <= 0) {
            integrity = 0;
            isOperational = false; 
        }
    }

    /**
     * Repairs the module, increasing its integrity. If integrity exceeds 0, the module becomes operational again.
     * OOP concept: Method — this method modifies the state of the module based on the repair amount.
     * @param amount the amount of repair to apply
     * @throws IllegalArgumentException if repair amount is negative
     */
    public void repair(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Repair amount cannot be negative");
        }
        integrity += amount;
        if (integrity > 100) {
            integrity = 100; 
        }
        if (integrity > 0) {
            isOperational = true; 
        }
    }

    /**
     * Returns the name of the module.
     * OOP concept: Getter — this method provides controlled access to the module's name.
     * @return the name of the module
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current integrity level of the module.
     * OOP concept: Getter — this method provides controlled access to the module's integrity.
     * @return the integrity level of the module
     */
    public int getIntegrity() {
        return integrity;
    }

    /**
     * Returns whether the module is currently operational.
     * OOP concept: Getter — this method provides controlled access to the module's operational status.
     * @return true if the module is operational, false otherwise
     */
    public boolean isOperational() {
        return isOperational;
    }

    /**
     * Abstract method to define behavior that occurs each game tick. Subclasses must implement this method to specify what happens to the module on each tick.
     * OOP concept: Abstract Method — this method must be implemented by subclasses, allowing for polymorphic behavior based on the specific type of module.
     */
    public abstract void onTick();

    /**
     * Override toString() to return the module's name for easier identification in logs and UI.
     * OOP concept: Method Overriding — this method overrides the default toString() method to provide a more meaningful string representation of the module.\
     * @return the name of the module
     */
    @Override
    public String toString() {
        return name;
    }


}