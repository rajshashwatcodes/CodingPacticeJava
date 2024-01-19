import java.util.ArrayList;
import java.util.List;

class Ticket {
    String source;
    String destination;

    public Ticket(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
}

public class Itinerary {
    public static List<String> findItinerary(List<Ticket> tickets) {
        List<String> itinerary = new ArrayList<>();
        if (tickets == null || tickets.isEmpty()) {
            return itinerary;
        }

        // Create a map to store the destination for each source
        // This is used to find the starting point of the itinerary
        // and to efficiently find the next destination
        // in O(1) time complexity.
        // (Assuming there is no duplicate source in the tickets)
        // Alternatively, you could use a HashMap<String, PriorityQueue<String>>.

        // In this example, I'll use a simple array.
        String[] destinations = new String[tickets.size() + 1];

        for (Ticket ticket : tickets) {
            destinations[itinerary.size()] = ticket.destination;
            itinerary.add(ticket.source);
        }

        // Find the starting point of the itinerary
        String start = null;
        for (String source : itinerary) {
            if (!containsDestination(destinations, source)) {
                start = source;
                break;
            }
        }

        // Reconstruct the itinerary
        List<String> result = new ArrayList<>();
        int index = itinerary.indexOf(start);
        while (index != -1) {
            result.add(itinerary.get(index));
            index = itinerary.indexOf(destinations[index]);
        }

        return result;
    }

    private static boolean containsDestination(String[] destinations, String source) {
        for (String destination : destinations) {
            if (source != null && source.equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("A", "B"));
        tickets.add(new Ticket("B", "C"));
        tickets.add(new Ticket("C", "D"));
        tickets.add(new Ticket("D", "E"));

        List<String> itinerary = findItinerary(tickets);

        System.out.println("Itinerary: " + itinerary);
    }
}
