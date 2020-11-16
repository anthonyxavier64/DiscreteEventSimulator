/**
 * Represents a WAITS event.
 *
 * @author Anthony Xavier
 */
public class WaitEvent extends Event {

    /**
     * Creates a WAITS event.
     * @param cus Represents customer of WAITS event.
     * @param state Represents state of WAITS event.
     * @param ser Represents server of WAITS event.
     */
    public WaitEvent(Customer cus, State state, Server ser) {
        super(cus, state, ser);
    }

    /**
     * Gets a WAITS event.
     * @return Returns a string representation of a WAITS event.
     */
    @Override
    public String toString() {
        return String.format("%.3f", this.cus.getTime()) + " " + 
            this.cus + " waits to be served by " + this.ser;
    }
}
