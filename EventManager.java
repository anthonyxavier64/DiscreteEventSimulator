import java.util.List;

/**
 * Represents a manager which manages events.
 *
 * @author Anthony Xavier
 */
public class EventManager {
    private final List<Server> ser;
    private final Event e;
    private final Schedule sd;
   
    /**
     * Creates an EventManager.
     * @param e Represents the event being passed into the EventManager.
     * @param sd Represents the schedule which will be updated with a new event. 
     * @param ser Represents the list of servers being passed into the EventManager.
     */
    public EventManager(Event e, Schedule sd, List<Server> ser) {
        this.e = e;
        this.sd = sd;
        this.ser = ser;
    }

    /**
     * Process an event to be updated in the schedule.
     * @return Returns an updated schedule with the new event.
     */
    public Schedule checkEvent() {
        Customer cus = e.getCus();
        if (e.isArrives()) {
            for (int i = 0; i < ser.size(); i++) {
                if (ser.get(i).canServe(cus)) {
                    ser.get(i).serve(cus);
                    cusIsServed(cus, sd, ser.get(i));
                    e.serverTrue();
                    break;
                }
            }
            if (e.hasServer()) {
                return sd;
            } else {
                for (int i = 0; i < ser.size(); i++) {
                    if (ser.get(i).getServingNumOfCus() == 1) {
                        ser.get(i).servingNumOfCus(2);
                        cus.addWaitTime(ser.get(i).getServeTime());
                        cusIsWaiting(cus, sd, ser.get(i));
                        e.serverTrue();
                        break;
                    }
                }
            } 
            if (e.hasServer()) {
                Statistics stats = new Statistics(e.getCountServed(), 
                    e.getCountNotServed(), cus.getWaitTime());
                return sd;
            } else { 
                e.countNotServed();
                cusIsNotServed(cus, sd);
            }
        } else if (e.isWaits()) {
            cusHasWaited(cus, sd, e.getServer());
            e.getServer().serveWaitingCus();
        } else if (e.isServed()) {
            e.getServer().servingNumOfCus(1);
            e.countServed();
            cusBeenServed(cus, sd, e.getServer());
        } else if (e.isLeaves()) {
            sd.removeFromSchedule();
        } else if (e.isDone()) {
            sd.removeFromSchedule();
        }
        Statistics stats = new Statistics(e.getCountServed(), 
            e.getCountNotServed(), cus.getWaitTime());
        return sd;
    }

    /**
     * Updates the schedule if customer in event can be served.
     * @param cus Represents the customer of the event.
     * @param sd Represents the schedule to be updated.
     * @param ser Represents the server of the event.
     */
    private static void cusIsServed(Customer cus, Schedule sd, Server ser) {
        sd.updateSchedule(new ServedEvent(cus, State.SERVED, ser));
    }

    /**
     * Updates the schedule if customer in event cannot be served.
     * @param cus Represents the customer of the event.
     * @param sd Represents the schedule to be updated.
     */
    private static void cusIsNotServed(Customer cus, Schedule sd) {
        sd.updateSchedule(new LeavesEvent(cus, State.LEAVES));
    }

    /**
     * Updates the schedule if customer in event has been served.
     * @param cus Represents the customer of the event.
     * @param sd Represents the schedule to be updated.
     * @param ser Represents the server of the event.
     */
    private static void cusBeenServed(Customer cus, Schedule sd, Server ser) {
        cus.updateTime(cus.getTime() + 1);
        sd.updateSchedule(new DoneEvent(cus, State.DONE, ser));
    }

    /**
     * Updates the schedule if customer is waiting to be served.
     * @param cus Represents the customer of the event.
     * @param sd Represents the schedule to be updated.
     * @param ser Represents the server who the customer is waiting for.
     */
    private static void cusIsWaiting(Customer cus, Schedule sd, Server ser) {
        sd.updateSchedule(new WaitEvent(cus, State.WAITS, ser));
    }

    /**
     * Updates the schedule if customer has waited and can be served.
     * @param cus Represents the customer of the event.
     * @param sd Represents the schedule to be updated.
     * @param ser Represents the server who will serve the customer.
     */
    private static void cusHasWaited(Customer cus, Schedule sd, Server ser) {
        cus.updateTime(ser.getServeTime());
        sd.updateSchedule(new ServedEvent(cus, State.SERVED, ser));
    }
}
