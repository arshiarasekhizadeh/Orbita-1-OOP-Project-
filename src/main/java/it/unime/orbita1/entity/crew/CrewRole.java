package it.unime.orbita1.entity.crew;


/**
 * Enumeration representing the various roles that a crew member can have on the station.
 *
 * Each role has a display name for user-friendly representation. This enum can be
 * used to assign specific responsibilities and tasks to crew members based on their
 * role, and to display their role in the UI.
 * 
 * OOP concept: Enumeration — this is a fixed set of constants representing crew roles,
 * each with an associated display name.
 *
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public enum CrewRole {
    /** Roles for the crew members on the space station  
    *PILOT: Responsible for navigation and piloting the station.    
    */
    PILOT ("Pilot"),
    /**ENGINEER: Handles maintenance and repairs of station systems.    
    */
    ENGINEER ("Engineer"),
    /**DOCTOR: Provides medical care to the crew.    
    */
    DOCTOR ("Doctor"),
    /**LIFE_SUPPORT_TECHNICIAN: Manages life support systems and ensures the station's environment is safe for the crew.
     */
    LIFE_SUPPORT_TECHNICIAN ("Life Support Technician"),
    /**COMMANDER: Overall leader of the crew, responsible for decision-making and coordination of all activities on the station.
     */
    COMMANDER ("Commander");

    private final String displayName;

    CrewRole(final String displayName) {
        this.displayName = displayName;
    }


    /**
     * Returns the display name of the crew role.
     *
     * @return the display name of the crew role
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}


