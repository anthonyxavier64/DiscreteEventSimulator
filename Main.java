import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

/**
 * A discrete event simulator.
 *
 * @author Anthony Xavier
 */
public class Main {
   
    /**
     * Takes in a queue and a list of servers,
     * and check if the customers in
     * the queue can be served by the list of servers
     * until the queue is empty.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Server> servers = createServers(sc);
        PriorityQueue<Event> pq = createQueue(sc);
        Schedule sd = new Schedule(pq);
        goThroughQueue(pq, sd, servers);
    }

    /**
     * Creates a queue.
     * @param sc Represents the Scanner object.
     * @return Returns a queue.
     */
    public static PriorityQueue<Event> createQueue(Scanner sc) {
        PriorityQueue<Event> pq = new PriorityQueue<>();
        while (sc.hasNext()) {
            pq.add(new ArriveEvent(new Customer(sc.nextDouble()), State.ARRIVES));
        }
        return pq;
    }

    /**
     * Checks through a queue until the queue is empty, and prints 
     * the statistics of the queue.
     * @param pq Represents the queue to be checked.
     * @param sd Represents the schedule of the queue.
     * @param servers Represents the list of servers to serve the customers in the queue.
     */
    public static void goThroughQueue(PriorityQueue<Event> pq, Schedule sd, List<Server> servers) {
        while (pq.size() > 0) {
            Event e = pq.peek();
            System.out.println(e);
            EventManager manage = new EventManager(e, sd, servers);
            sd = manage.checkEvent();
        }
        Statistics stats = new Statistics();
        System.out.println(stats);
    }

    /**
     * Creates a list of specified number of servers.
     * @param sc Represents the Scanner object.
     * @return Returns a list of servers.
     */
    public static List<Server> createServers(Scanner sc) {
        int numServers = sc.nextInt();
        List<Server> serverList = new ArrayList<>();
        for (int i = 0; i < numServers; i++) {
            serverList.add(new Server());
        }
        return serverList;
    }
}
