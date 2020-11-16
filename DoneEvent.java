/**
 * Represents a Done event.
 * 
 * @author Anthony Xavier
 */
public class DoneEvent extends Event {

    /**
     * Creates a DONE event.
     * @param cus Represents customer of DONE event.
     * @param state Represents state of DONE event.
     * @param ser Represents server of DONE event.
     */
    public DoneEvent(Customer cus, State state, Server ser) {
        super(cus, state, ser);
    }

    /**
     * Gets a DONE event.
     * @return Returns a string representation of a DONE event.
     */
    @Override 
    public String toString() {
        return String.format("%.3f", this.cus.getTime()) + " " + 
            this.cus + " done serving by " + this.ser;
    }
}
