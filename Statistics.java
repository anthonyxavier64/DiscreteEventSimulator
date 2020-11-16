/**
 * Represents the statistics of the queue.
 *
 * @author Anthony Xavier
 */
public class Statistics {
    private static int numCusServed = 0;
    private static int numCusNotServed = 0;
    private static double avgWaitTime = 0;

    /**
     * Creates Statistics.
     */
    public Statistics() {
    }

    /**
     * Creates Statistics by taking in number of customers served,
     * number of customers not served, and total waiting time.
     * @param numCusServed Represents the number of customer served.
     * @param numCusNotServed Represents the number of customer not served.
     * @param waitTime Represents the total waiting time.
     */
    public Statistics(int numCusServed, int numCusNotServed, double waitTime) {
        Statistics.numCusServed = numCusServed;
        Statistics.numCusNotServed = numCusNotServed;
        Statistics.avgWaitTime = waitTime / numCusServed;
    }

    /**
     * Get Statistics.
     * @return Returns a string representation of the statistics of the queue.
     */
    @Override
    public String toString() {
        return "[" + String.format("%.3f", Statistics.avgWaitTime) + " " + 
                Statistics.numCusServed + " " + numCusNotServed + "]";
    }
}
