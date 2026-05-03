package it.unime.orbita1.entity.crew;

/**
 * Class representing a Pilot crew member on the space station.
 *
 * Pilots are responsible for flying the spacecraft and managing flight systems. They
 * have a specific role that can be used to assign them tasks related to
 * piloting and navigation in the simulation.
 *
 * OOP concept: Inheritance — this class extends CrewMember, inheriting common
 * properties and behaviors of all crew members while adding specific
 * characteristics related to the Pilot role.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class Pilot extends CrewMember {
    /**
     * Constructs a Pilot with the specified name.
     *
     * The role is set to PILOT by default, as this class represents pilots specifically.
     *
     * @param name the name of the pilot crew member
     */
    public Pilot(final String name) {
        super(name, CrewRole.PILOT);
    }

    /**
     * Performs the pilot's specific duties on the station.
     *
     * This method should contain the logic for what a pilot does during their turn in the simulation, such as flying the spacecraft or managing flight systems. The actual implementation will depend on the mechanics of the simulation and how pilots interact with events and station systems.
     *
     * OOP concept: Polymorphism — this method overrides the abstract performDuty() method from CrewMember, allowing pilots to have their own specific behavior while still being treated as a generic crew member when necessary.
     */
    @Override
    public void performDuty() {
        // TODO: Implement pilot duty
    }
}