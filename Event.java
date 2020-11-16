/**
 * Represents an event.
 * 
 * @author Anthony Xavier
 */
public class Event implements Comparable<Event> {
    protected final Customer cus;
    protected final State state;
    private static double waitTime = 0;
    protected Server ser;
    private boolean hasServer = false;
   
    /**
     * Creates an event.
     * @param cus Represents customer of event.
     * @param state Represents state of event.
     * @param ser Represents server of event.
     */
    public Event(Customer cus, State state, Server ser) {
        this.cus = cus;
        this.state = state;
        this.ser = ser;
    }

    public Customer getCus() {
        return this.cus;
    }
    
    public Server getServer() {
        return this.ser;
    }

    /**
     * Changes hasServer to true as event now has
     * a server.
     */
    public void serverTrue() {
        this.hasServer = true;
    }

    /**
     * Get the value of hasServer.
     * @return Returns true if event has a server, else
     *       returns false.
     */
    public boolean hasServer() {
        return this.hasServer;
    }

    /**
     * Check state of event.
     * @return Returns true if state of event is DONE,
     *      else returns false.
     */
    public boolean isDone() {
        if (this.state.equals(State.DONE)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check state of event.
     * @return Returns true if state of event is ARRIVES,
     *      else returns false.
     */
    public boolean isArrives() {
        if (this.state.equals(State.ARRIVES)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check state of event.
     * @return Returns true if state of event is LEAVES,
     *      else returns false.
     */
    public boolean isLeaves() {
        if (this.state.equals(State.LEAVES)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check state of event.
     * @return Returns true if state of event is WAITS,
     *      else returns false.
     */
    public boolean isWaits() {
        if (this.state.equals(State.WAITS)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check state of event.
     * @return Returns true if state of event is SERVED,
     *      else returns false.
     */
    public boolean isServed() {
        if (this.state.equals(State.SERVED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase the number of customer served.
     */
    public void countServed() {
        this.cus.cusServed();
    }

    /**
     * Increase the number of customer not served.
     */
    public void countNotServed() {
        this.cus.cusNotServed();
    }

    public int getCountServed() {
        return this.cus.getCusServed();
    }

    public int getCountNotServed() {
        return this.cus.getCusNotServed();
    }

    /**
     * Compares this event with specified event for order.
     * @param other Represents specified event to be compared with.
     * @return Returns a negative integer, zero, or a positive integer
     *      as this event is less than, equal to, or greater than the specified event.
     */
    @Override
    public int compareTo(Event other) {
        return this.cus.compare(other.cus);
    }

    /**
     * Get an event.
     * @return Returns a string representation of event.
     */
    @Override
    public String toString() {
        return String.format("%.3f", this.cus.getTime()) + " " + 
            this.cus + " unspecified state";    
    }
}
