package it.unime.orbita1.entity.crew;

/**
 * Represents an engineer crew member on the space station.
 *
 * Engineers are responsible for maintaining and repairing station systems. They
 * have specific duties related to the technical operation of the station, and
 * may have unique interactions with certain events or emergencies in the simulation.
 *
 * OOP concept: Inheritance — this class extends CrewMember, inheriting common
 * properties and behaviors of all crew members while allowing for role-specific
 * implementations.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class Engineer extends CrewMember {

    /**
     * Constructs an Engineer with the specified name.
     *
     * The role is set to ENGINEER by default, as this class represents engineers specifically.
     *
     * @param name the name of the engineer crew member
     */
    public Engineer(final String name) {
        super(name, CrewRole.ENGINEER);
        
    }

    /**
     * Performs the engineer's specific duties on the station.
     *
     * This method should contain the logic for what an engineer does during their turn in the simulation, such as repairing systems or performing maintenance tasks. The actual implementation will depend on the mechanics of the simulation and how engineers interact with events and station systems.
     *
     * OOP concept: Polymorphism — this method overrides the abstract performDuty() method from CrewMember, allowing engineers to have their own specific behavior while still being treated as a generic crew member when necessary.
     */
    @Override
    public void performDuty() {
        // TODO: Implement engineer duty
    }
    

}