/**
 * Represents a customer.
 * 
 * @author Anthony Xavier
 */
public class Customer {
    private final int id;
    private static int cusSer = 0;
    private static int cusNSer = 0;
    private static int numCus = 0;
    private double time;
    private static double waitTime = 0;
   
    /**
     * Creates a customer with an ID and time of arrival.
     * @param time Represents the time of arrival of the customer.
     */
    public Customer(double time) {
        Customer.numCus++;
        this.id = Customer.numCus;
        this.time = time;
    }

    /**
     * Compares two customers.
     * @param other Represents customer being compared to.
     * @return Returns a negative integer, zero, or a positive integer
     *      as this customer is less than, equal to, or greater than the specified customer.
     */
    public int compare(Customer other) {
        if (this.time == other.time) {
            return this.id - other.id;
        } else {
            if (this.time > other.time) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public double getTime() {
        return this.time;
    }

    /**
     * Updates the timing of the customer to the specified time.
     * @param newTime Represents the new timing to be updated for the
     *                customer.
     */
    public void updateTime(double newTime) {
        this.time = newTime;
    }

    /**
     * Adds waiting time to total waiting time.
     * @param time Represents the time that the customer is served.
     */
    public void addWaitTime(double time) {
        Customer.waitTime += time - this.time;
    }

    public double getWaitTime() {
        return Customer.waitTime;
    }

    /**
     * Increase the number of customer being 
     * served by 1.
     */ 
    public void cusServed() {
        Customer.cusSer++;
    }

    /**
     * Increase the number of customer not being
     * served by 1.
     */
    public void cusNotServed() {
        Customer.cusNSer++;
    }

    public int getCusServed() {
        return Customer.cusSer;
    }

    public int getCusNotServed() {
        return Customer.cusNSer;
    }

    /**
     * Get a customer.
     * @return Returns a string representation of customer's ID.
     */
    @Override 
    public String toString() {
        return this.id + "";
    }
}
