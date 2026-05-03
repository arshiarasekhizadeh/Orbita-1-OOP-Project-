package it.unime.orbita1.entity.crew;

/**
 * Represents a crew member on the spaceship.
 * Each crew member has a name, a role, health, stress level, and an alive status. Crew members can take damage, heal, add stress, and reduce stress. They also have an abstract method performDuty() that must be implemented by subclasses to define their specific duties on the station.
 * OOP concepts:
 * - Encapsulation: Crew member properties are private and accessed through public methods.
 * - Inheritance: This is an abstract class that will be extended by specific crew member types
 * - Polymorphism: The performDuty() method is abstract, allowing different crew member types to implement it in their own way.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)  
 */
public abstract class CrewMember
{
    private final String name;

    private final CrewRole role;

    private int health = 100; // Health starts at 100 and can decrease due to events

    private int stressLevel = 0; // Stress level starts at 0 and can increase due to events

    private boolean isAlive = true; // Crew member is alive at the start

    /**
     * Constructs a CrewMember with the specified name and role.
     * OOP concept: Constructor — initializes the crew member's name and role, and sets default values for health, stress level, and alive status.
     * @param name
     * @param role
     */
    public CrewMember(final String name, final CrewRole role) {
        java.util.Objects.requireNonNull(name, "Crew member name cannot be null");
        java.util.Objects.requireNonNull(role, "Crew member role cannot be null");
        this.name = name;
        this.role = role;

    }
    /**
     * Applies damage to the crew member, reducing their health. If health drops to 0 or below, the crew member dies.
     * OOP concept: Method — this method modifies the state of the crew member based on the damage taken.
     * @param damage the amount of damage to apply
     * @throws IllegalArgumentException if damage is negative
     */
    public void takeDamage(final int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        health -= damage;
        if (health <= 0) {
            health = 0;
            isAlive = false; // Crew member dies if health drops to 0 or below
        }
    }
    /**
     * Increases the crew member's stress level by the specified amount.
     * OOP concept: Method — this method modifies the state of the crew member based on the stress added.
     * @param stress the amount of stress to add
     * @throws IllegalArgumentException if stress is negative
     */
    public void addStress(final int stress) {
        if (stress < 0) {
            throw new IllegalArgumentException("Stress increase cannot be negative");
        }
        stressLevel += stress;
    }
    /**
     * Heals the crew member by the specified amount, increasing their health. Health cannot exceed 100.
     * OOP concept: Method — this method modifies the state of the crew member based on the healing received.
     * @param amount the amount of healing to apply
     * @throws IllegalArgumentException if amount is negative
     */
    public void heal(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative");
        }
        if (isAlive) {
            health += amount;
            if (health > 100) {
                health = 100; // Cap health at 100
            }
        }
    }
    /**
     * Reduces the crew member's stress level by the specified amount. Stress level cannot go below 0.
     * OOP concept: Method — this method modifies the state of the crew member based on the stress reduction received.
     * @param amount the amount of stress to reduce
     * @throws IllegalArgumentException if amount is negative
     */
    public void reduceStress(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Stress reduction cannot be negative");
        }
        if (isAlive) {
            stressLevel -= amount; // Reduce stress by the specified amount
            if (stressLevel < 0) {
                stressLevel = 0; // Stress level cannot go below 0
            }
        }
    }
    /**
     * Abstract method to perform the crew member's specific duties on the station. Each subclass will implement this method to define their role-specific behavior.
     * OOP concept: Polymorphism — this method is abstract, allowing different crew member types to implement it in their own way based on their role.
     */
    public abstract void performDuty(); // Each crew member will implement this method to perform their specific duties

    /**
     * Returns the name of the crew member.
     * OOP concept: Method — this method provides access to the name attribute of the crew member.
     * @return the name of the crew member
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the role of the crew member.
     * OOP concept: Method — this method provides access to the role attribute of the crew member.
     * @return the role of the crew member
     */
    public CrewRole getRole() {
        return role;
    }

    /**
     * Returns the current health of the crew member.
     * OOP concept: Method — this method provides access to the health attribute of the crew member.
     * @return the current health of the crew member
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the current stress level of the crew member.
     * OOP concept: Method — this method provides access to the stressLevel attribute of the crew member.
     * @return the current stress level of the crew member
     */
    public int getStressLevel() {
        return stressLevel;
    }

    /**
     * Returns whether the crew member is alive.
     * OOP concept: Method — this method provides access to the isAlive attribute of the crew member.
     * @return true if the crew member is alive, false otherwise
     */
    public boolean isAlive() {
        return isAlive;
    }
    
    /**
     * Returns a string representation of the crew member, including their name and role.
     * OOP concept: Method — this method overrides the default toString() method to provide a meaningful string representation of the crew member.
     * @return a string representation of the crew member
     */
    @Override
    public String toString() {
        return name + " (" + role.getDisplayName() + ")";
    }
}