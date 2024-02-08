import java.util.*;

class Flight {
    int destination;
    int price;

    public Flight(int destination, int price) {
        this.destination = destination;
        this.price = price;
    }
}

class City {
    int id;
    List<Flight> flights;

    public City(int id) {
        this.id = id;
        flights = new ArrayList<>();
    }

    public void addFlight(int destination, int price) {
        flights.add(new Flight(destination, price));
    }
}

public class CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, City> cities = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cities.put(i, new City(i));
        }

        for (int[] flight : flights) {
            int sourceCity = flight[0];
            int destinationCity = flight[1];
            int price = flight[2];
            cities.get(sourceCity).addFlight(destinationCity, price);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, src, k + 1});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int price = current[0];
            int city = current[1];
            int stops = current[2];

            if (city == dst) {
                return price;
            }

            if (stops > 0) {
                City currentCity = cities.get(city);
                for (Flight flight : currentCity.flights) {
                    minHeap.offer(new int[]{price + flight.price, flight.destination, stops - 1});
                }
            }
        }

        return -1; // If destination not reachable within k stops
    }

    public static void main(String[] args) {
        CheapestFlights cheapestFlights = new CheapestFlights();
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int cheapestPrice = cheapestFlights.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price for destination " + dst + " with at most " + k + " stops: " + cheapestPrice);
    }
}
