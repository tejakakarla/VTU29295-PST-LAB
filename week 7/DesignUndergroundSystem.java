/*
 * WEEK 7 - TASK 3
 * Problem: Design Underground System
 * Platform: LeetCode 1396
 *
 * Question:
 * Design an underground transit system that records check-ins and check-outs
 * and returns the average travel time between two stations.
 *
 * Solution:
 * Store each customer's active check-in station and time. On checkout, compute
 * the journey duration and add it to a route's total time and trip count.
 */

import java.util.*;

class UndergroundSystem {
    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class Route {
        double totalTime;
        int trips;

        void addTrip(int duration) {
            totalTime += duration;
            trips++;
        }
    }

    private final Map<Integer, CheckIn> active = new HashMap<>();
    private final Map<String, Route> routes = new HashMap<>();

    public UndergroundSystem() { }

    public void checkIn(int id, String stationName, int t) {
        active.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = active.remove(id);
        String key = checkIn.station + "#" + stationName;
        routes.computeIfAbsent(key, k -> new Route())
              .addTrip(t - checkIn.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = routes.get(startStation + "#" + endStation);
        return route.totalTime / route.trips;
    }
}
