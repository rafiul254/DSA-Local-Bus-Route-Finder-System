package com.example.dsaproject;

import com.example.dsaproject.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import java.util.Arrays;

public class BusRouteController {
    @FXML private ComboBox<BusStop> sourceComboBox;
    @FXML private ComboBox<BusStop> destinationComboBox;
    @FXML private ComboBox<String> algorithmComboBox;
    @FXML private Label distanceLabel;
    @FXML private Label timeLabel;
    @FXML private Label stopsLabel;
    @FXML private VBox routeDetailsBox;
    @FXML private Label statusLabel;

    private Graph graph;

    @FXML
    public void initialize() {
        graph = createSampleNetwork();

        // Populate combo boxes
        sourceComboBox.setItems(FXCollections.observableArrayList(graph.getAllStops()));
        destinationComboBox.setItems(FXCollections.observableArrayList(graph.getAllStops()));

        algorithmComboBox.setItems(FXCollections.observableArrayList(
                "BFS (Minimum Stops)",
                "DFS (Path Finding)",
                "Dijkstra (Shortest Distance)",
                "Dijkstra (Fastest Time)"
        ));
        algorithmComboBox.setValue("Dijkstra (Shortest Distance)");
    }

    @FXML
    private void onFindRoute() {
        BusStop source = sourceComboBox.getValue();
        BusStop destination = destinationComboBox.getValue();
        String algorithm = algorithmComboBox.getValue();

        if (source == null || destination == null) {
            showAlert("Please select both source and destination");
            return;
        }

        if (source.getId().equals(destination.getId())) {
            showAlert("Source and destination cannot be the same");
            return;
        }

        RouteResult result = null;

        try {
            if (algorithm.startsWith("BFS")) {
                result = graph.bfs(source.getId(), destination.getId());
            } else if (algorithm.startsWith("DFS")) {
                result = graph.dfs(source.getId(), destination.getId());
            } else if (algorithm.contains("Distance")) {
                result = graph.dijkstra(source.getId(), destination.getId(), "distance");
            } else {
                result = graph.dijkstra(source.getId(), destination.getId(), "time");
            }

            if (result != null) {
                displayResult(result);
            } else {
                showAlert("No route found between selected stops");
            }
        } catch (Exception e) {
            showAlert("Error finding route: " + e.getMessage());
        }
    }

    private void displayResult(RouteResult result) {
        distanceLabel.setText(String.format("%.1f km", result.getTotalDistance()));
        timeLabel.setText(result.getTotalTime() + " min");
        stopsLabel.setText(String.valueOf(result.getTotalStops()));

        routeDetailsBox.getChildren().clear();

        int step = 1;
        for (RouteResult.StepDetail detail : result.getDetails()) {
            VBox stepBox = new VBox(5);
            stepBox.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-background-radius: 5;");

            Label stepLabel = new Label("Step " + step++);
            stepLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

            Label routeLabel = new Label(detail.getFrom().getName() + " → " + detail.getTo().getName());
            routeLabel.setStyle("-fx-font-size: 13;");

            Label busLabel = new Label("Buses: " + String.join(", ", detail.getBusNumbers()));
            busLabel.setStyle("-fx-text-fill: #0066cc;");

            Label infoLabel = new Label(String.format("%.1f km | %d min",
                    detail.getDistance(), detail.getTime()));
            infoLabel.setStyle("-fx-text-fill: #666666;");

            stepBox.getChildren().addAll(stepLabel, routeLabel, busLabel, infoLabel);
            routeDetailsBox.getChildren().add(stepBox);
        }

        statusLabel.setText("Route found using " + result.getAlgorithm());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Graph createSampleNetwork() {
        Graph g = new Graph();

        // Add stops
        g.addStop("mohakhali", "Mohakhali", "Mohakhali Bus Terminal");
        g.addStop("farmgate", "Farmgate", "Farmgate Intersection");
        g.addStop("shahbag", "Shahbag", "Shahbag Square");
        g.addStop("dhanmondi", "Dhanmondi", "Dhanmondi 27");
        g.addStop("newmarket", "New Market", "New Market Area");
        g.addStop("gulshan", "Gulshan", "Gulshan Circle 1");
        g.addStop("banani", "Banani", "Banani Chairman Bari");
        g.addStop("uttara", "Uttara", "Uttara Sector 7");
        g.addStop("mirpur", "Mirpur", "Mirpur 10");
        g.addStop("motijheel", "Motijheel", "Motijheel Commercial Area");

        // Add routes
        g.addRoute("mohakhali", "farmgate", 2.5, 8, Arrays.asList("9", "12", "25"));
        g.addRoute("farmgate", "shahbag", 1.8, 6, Arrays.asList("9", "12", "28"));
        g.addRoute("shahbag", "dhanmondi", 3.2, 10, Arrays.asList("2", "9", "28"));
        g.addRoute("shahbag", "newmarket", 1.5, 5, Arrays.asList("7", "12", "20"));
        g.addRoute("dhanmondi", "newmarket", 2.0, 7, Arrays.asList("2", "7"));
        g.addRoute("mohakhali", "gulshan", 3.5, 12, Arrays.asList("9", "25", "31"));
        g.addRoute("gulshan", "banani", 2.0, 7, Arrays.asList("25", "31", "33"));
        g.addRoute("banani", "uttara", 8.5, 25, Arrays.asList("25", "31"));
        g.addRoute("mohakhali", "mirpur", 6.0, 20, Arrays.asList("3", "4", "32"));
        g.addRoute("farmgate", "motijheel", 4.5, 15, Arrays.asList("6", "8", "11"));
        g.addRoute("shahbag", "motijheel", 3.0, 10, Arrays.asList("6", "11", "20"));

        return g;
    }
}
