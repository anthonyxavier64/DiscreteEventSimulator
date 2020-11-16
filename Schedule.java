import java.util.PriorityQueue;
import java.util.Iterator;

/**
 * Represents the schedule which contains 
 * all the events.
 *
 * @author Anthony Xavier
 */
public class Schedule {
    private PriorityQueue<Event> pq;
   
    /**
     * Creates the schedule.
     * @param pq Represents the queue that will be added
     *           into the schedule.
     */
    Schedule(PriorityQueue<Event> pq) {
        this.pq = pq;
    }

    /**
     * Updates the schedule with a new event.
     * @param e Represents the new event.
     */
    public void updateSchedule(Event e) {
        pq.poll();
        pq.add(e);
    }

    public void removeFromSchedule() {
        pq.poll();
    }

    /**
     * Gets the schedule.
     * @return Returns a string representation of 
     *         the schedule.
     */
    @Override 
    public String toString() {
        String str = "";
        Iterator<Event> value = pq.iterator();
        while (value.hasNext()) {
            str += value.next();
            str += "\n";
        }
        return str;
    }
}
