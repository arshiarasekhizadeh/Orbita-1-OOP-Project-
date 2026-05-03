package it.unime.orbita1.entity.crew;


/**
 * Represents a doctor crew member on the space station.
 *
 * Doctors are responsible for providing medical care to the crew. They have
 * specific duties related to health and wellness, and may have unique
 * interactions with certain events or emergencies in the simulation.
 *
 * OOP concept: Inheritance — this class extends CrewMember, inheriting common
 * properties and behaviors of all crew members while allowing for role-specific
 * implementations.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class Doctor extends CrewMember {


    /**
     * Constructs a Doctor with the specified name.
     *
     * The role is set to DOCTOR by default, as this class represents doctors specifically.
     *
     * @param name the name of the doctor crew member
     */
    public Doctor(final String name) {
        super(name, CrewRole.DOCTOR);
    }


    /**
     * Performs the doctor's specific duties on the station.
     *
     * This method should contain the logic for what a doctor does during their turn in the simulation, such as treating injured crew members or managing medical supplies. The actual implementation will depend on the mechanics of the simulation and how doctors interact with events and station systems.
     *
     * OOP concept: Polymorphism — this method overrides the abstract performDuty() method from CrewMember, allowing doctors to have their own specific behavior while still being treated as a generic crew member when necessary.
     */
    @Override
    public void performDuty() {
        // TODO: Implement doctor duty
    }

}