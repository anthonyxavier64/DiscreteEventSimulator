/**
 * Represents a LEAVES event.
 *
 * @author Anthony Xavier
 */
public class LeavesEvent extends Event {
   
    /**
     * Creates a LEAVES event.
     * @param cus Represents customer of LEAVES event.
     * @param state Represents state of LEAVES event.
     */
    public LeavesEvent(Customer cus, State state) {
        super(cus, state, null);
    }

    /**
     * Gets a LEAVES event.
     * @return Returns a string representation of a LEAVES event.
     */
    @Override 
    public String toString() {
        return String.format("%.3f", this.cus.getTime()) + " " + this.cus + " leaves";
    }
}
