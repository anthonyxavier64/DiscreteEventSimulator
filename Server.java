/**
 * Represents a server.
 *
 * @author Anthony Xavier
 */
public class Server {
    private double serveTime;
    private int servingNum;
    private static int count = 1;
    private int id;
   
    /**
     * Creates a server.
     */
    public Server() {
        this.serveTime = 0;
        this.id = count;
        count++;
    }

    /**
     * Checks if server can serve customer.
     * @param cus Represents the customer.
     * @return Returns true if server can serve customer, else
     *         returns false.
     */
    public boolean canServe(Customer cus) {
        if (serveTime <= cus.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Changes the number of customer that the server
     * is handling.
     * @param num Represents the number of customer that
     *            the server is handling.
     */
    public void servingNumOfCus(int num) {
        this.servingNum = num;
    }

    /**
     * Changes the server next available service time.
     * @param cus Represents the customer which contains the
     *            current service time of the server.
     */
    public void serve(Customer cus) {
        this.serveTime = cus.getTime() + 1;
    }

    /**
     * Increase the server next available service time by
     * 1.
     */
    public void serveWaitingCus() {
        this.serveTime += 1;
    }

    public int getServingNumOfCus() {
        return this.servingNum;
    }

    public double getServeTime() {
        return this.serveTime;
    }

    /**
     * Gets the server.
     * @return Returns a string representation of server's ID.
     */
    @Override 
    public String toString() {
        return "" + this.id;
    }
}
