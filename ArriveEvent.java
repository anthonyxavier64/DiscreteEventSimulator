/**
 * Represents an ARRIVES event.
 * 
 * @author Anthony Xavier
 */
public class ArriveEvent extends Event {
    
    /**
     * Constructor of ArriveEvent.
     * @param cus Represents customer of ARRIVES event.
     * @param state Represents state of ARRIVES event.
     */
    public ArriveEvent(Customer cus, State state) {
        super(cus, state, null);
    }

    /**
     * Gets the ARRIVES event.
     * @return Returns a string representation of the ARRIVES event.
     */
    @Override 
    public String toString() {
        return String.format("%.3f", this.cus.getTime()) + " " + this.cus + " arrives";
    }
}
