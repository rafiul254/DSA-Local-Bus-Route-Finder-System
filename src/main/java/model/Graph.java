package com.example.dsaproject.model;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjacencyList;
    private Map<String, BusStop> stops;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.stops = new HashMap<>();
    }

    public void addStop(String id, String name, String location) {
        if (!adjacencyList.containsKey(id)) {
            adjacencyList.put(id, new ArrayList<>());
            stops.put(id, new BusStop(id, name, location));
        }
    }

    public void addRoute(String stop1, String stop2, double distance,
                         int time, List<String> busNumbers) {
        if (!adjacencyList.containsKey(stop1)) addStop(stop1, stop1, "");
        if (!adjacencyList.containsKey(stop2)) addStop(stop2, stop2, "");

        adjacencyList.get(stop1).add(new Edge(stop2, distance, time, busNumbers));
        adjacencyList.get(stop2).add(new Edge(stop1, distance, time, busNumbers));
    }

    // BFS - Shortest path by number of stops
    public RouteResult bfs(String start, String end) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Arrays.asList(start));
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String node = path.get(path.size() - 1);

            if (node.equals(end)) {
                return constructPathDetails(path, "BFS");
            }

            List<Edge> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>());
            for (Edge edge : neighbors) {
                if (!visited.contains(edge.getTargetNode())) {
                    visited.add(edge.getTargetNode());
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(edge.getTargetNode());
                    queue.add(newPath);
                }
            }
        }
        return null;
    }

    // DFS - Find a path
    public RouteResult dfs(String start, String end) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();

        if (dfsHelper(start, end, visited, path)) {
            return constructPathDetails(path, "DFS");
        }
        return null;
    }

    private boolean dfsHelper(String node, String end, Set<String> visited, List<String> path) {
        visited.add(node);
        path.add(node);

        if (node.equals(end)) return true;

        List<Edge> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>());
        for (Edge edge : neighbors) {
            if (!visited.contains(edge.getTargetNode())) {
                if (dfsHelper(edge.getTargetNode(), end, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    // Dijkstra's Algorithm
    public RouteResult dijkstra(String start, String end, String weightType) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.distance));

        for (String node : adjacencyList.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(new Node(start, 0.0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String currentNode = current.id;

            if (currentNode.equals(end)) break;

            List<Edge> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
            for (Edge edge : neighbors) {
                double weight = weightType.equals("distance") ? edge.getDistance() : edge.getTime();
                double distance = distances.get(currentNode) + weight;

                if (distance < distances.get(edge.getTargetNode())) {
                    distances.put(edge.getTargetNode(), distance);
                    previous.put(edge.getTargetNode(), currentNode);
                    pq.add(new Node(edge.getTargetNode(), distance));
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        if (path.isEmpty() || !path.get(0).equals(start)) return null;

        return constructPathDetails(path, "Dijkstra (" + weightType + ")");
    }

    private RouteResult constructPathDetails(List<String> path, String algorithm) {
        List<RouteResult.StepDetail> details = new ArrayList<>();
        double totalDistance = 0;
        int totalTime = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            String currentStop = path.get(i);
            String nextStop = path.get(i + 1);
            List<Edge> neighbors = adjacencyList.getOrDefault(currentStop, new ArrayList<>());

            for (Edge edge : neighbors) {
                if (edge.getTargetNode().equals(nextStop)) {
                    totalDistance += edge.getDistance();
                    totalTime += edge.getTime();
                    details.add(new RouteResult.StepDetail(
                            stops.get(currentStop),
                            stops.get(nextStop),
                            edge.getDistance(),
                            edge.getTime(),
                            edge.getBusNumbers()
                    ));
                    break;
                }
            }
        }

        return new RouteResult(path, details, totalDistance, totalTime, algorithm);
    }

    public List<BusStop> getAllStops() {
        return new ArrayList<>(stops.values());
    }

    private static class Node {
        String id;
        double distance;

        Node(String id, double distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
