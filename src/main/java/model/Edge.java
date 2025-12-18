package com.example.dsaproject.model;

import java.util.List;

public class Edge {
    private String targetNode;
    private double distance;
    private int time;
    private List<String> busNumbers;

    public Edge(String targetNode, double distance, int time, List<String> busNumbers) {
        this.targetNode = targetNode;
        this.distance = distance;
        this.time = time;
        this.busNumbers = busNumbers;
    }

    public String getTargetNode() { return targetNode; }
    public double getDistance() { return distance; }
    public int getTime() { return time; }
    public List<String> getBusNumbers() { return busNumbers; }
}
