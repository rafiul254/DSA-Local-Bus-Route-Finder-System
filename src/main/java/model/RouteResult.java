package com.example.dsaproject.model;

import java.util.List;

public class RouteResult {
    private List<String> path;
    private List<StepDetail> details;
    private double totalDistance;
    private int totalTime;
    private int totalStops;
    private String algorithm;

    public RouteResult(List<String> path, List<StepDetail> details,
                       double totalDistance, int totalTime, String algorithm) {
        this.path = path;
        this.details = details;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.totalStops = path.size();
        this.algorithm = algorithm;
    }

    public List<String> getPath() { return path; }
    public List<StepDetail> getDetails() { return details; }
    public double getTotalDistance() { return totalDistance; }
    public int getTotalTime() { return totalTime; }
    public int getTotalStops() { return totalStops; }
    public String getAlgorithm() { return algorithm; }

    public static class StepDetail {
        private BusStop from;
        private BusStop to;
        private double distance;
        private int time;
        private List<String> busNumbers;

        public StepDetail(BusStop from, BusStop to, double distance,
                          int time, List<String> busNumbers) {
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.time = time;
            this.busNumbers = busNumbers;
        }

        public BusStop getFrom() { return from; }
        public BusStop getTo() { return to; }
        public double getDistance() { return distance; }
        public int getTime() { return time; }
        public List<String> getBusNumbers() { return busNumbers; }
    }
}
