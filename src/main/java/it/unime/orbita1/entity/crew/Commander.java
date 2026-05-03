package it.unime.orbita1.entity.crew;

/**
 * Represents the commander crew member on the space station.
 *
 * The commander is responsible for overall leadership and decision-making on the station. They coordinate the activities of the crew and ensure that mission objectives are met. The commander may have unique interactions with certain events or emergencies in the simulation, reflecting their role as the leader of the crew.
 *
 * OOP concept: Inheritance — this class extends CrewMember, inheriting common properties and behaviors of all crew members while allowing for role-specific implementations related to command and leadership.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class Commander extends CrewMember {

    /**
     * Constructs a Commander with the specified name.
     *
     * The role is set to COMMANDER by default, as this class represents commanders specifically.
     *
     * @param name the name of the commander crew member
     */
    public Commander(final String name) {
        super(name, CrewRole.COMMANDER);
    }

    /**
     * Performs the commander's specific duties on the station.
     *
     * This method should contain the logic for what a commander does during their turn in the simulation, such as making strategic decisions, coordinating crew activities, and overseeing mission operations. The actual implementation will depend on the mechanics of the simulation and how commanders interact with events and station systems.
     *
     * OOP concept: Polymorphism — this method overrides the abstract performDuty() method from CrewMember, allowing commanders to have their own specific behavior while still being treated as a generic crew member when necessary.
     */
    @Override
    public void performDuty() {
        // Command the crew and oversee mission operations.
    }
}