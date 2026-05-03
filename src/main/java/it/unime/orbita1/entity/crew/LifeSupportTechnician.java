package it.unime.orbita1.entity.crew;

/**
 * Represents a Life Support Technician crew member on the space station.
 *
 * Life Support Technicians are responsible for maintaining the station's life support systems. They have
 * specific duties related to ensuring the station's environment remains safe and habitable for the crew. They may have
 * unique interactions with certain events or emergencies in the simulation.
 *
 * OOP concept: Inheritance — this class extends CrewMember, inheriting common
 * properties and behaviors of all crew members while allowing for role-specific
 * implementations.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class LifeSupportTechnician extends CrewMember {

    /**
     * Constructs a Life Support Technician with the specified name.
     *
     * The role is set to LIFE_SUPPORT_TECHNICIAN by default, as this class represents life support technicians specifically.
     *
     * @param name the name of the life support technician crew member
     */
    public LifeSupportTechnician(final String name) {
        super(name, CrewRole.LIFE_SUPPORT_TECHNICIAN);
    }

    /**
     * Performs the life support technician's specific duties on the station.
     *
     * This method should contain the logic for what a life support technician does during their turn in the simulation, such as monitoring and repairing life support systems or managing environmental controls. The actual implementation will depend on the mechanics of the simulation and how life support technicians interact with events and station systems.
     *
     * OOP concept: Polymorphism — this method overrides the abstract performDuty() method from CrewMember, allowing life support technicians to have their own specific behavior while still being treated as a generic crew member when necessary.
     */
    @Override
    public void performDuty() {
        //TODO: Implement life support technician duty
    }
}