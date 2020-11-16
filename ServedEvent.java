/**
 * Represents a SERVED event.
 *
 * @author Anthony Xavier
 */
public class ServedEvent extends Event {

    /**
     * Creates a SERVED event.
     * @param cus Represents customer of SERVED event.
     * @param state Represents state of SERVED event.
     * @param ser Represents server of SERVED event.
     */
    public ServedEvent(Customer cus, State state, Server ser) {
        super(cus, state, ser);
    }

    /**
     * Gets a SERVED event.
     * @return Returns a string representation of a SERVED event.
     */
    @Override 
    public String toString() {
        return String.format("%.3f", cus.getTime()) + " " + 
            this.cus + " " + "served by " + this.ser;
    }
}
