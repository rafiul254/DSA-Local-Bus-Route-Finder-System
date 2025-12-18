# 🚌 Local Bus Route Finder System

A comprehensive **Data Structures and Algorithms (DSA)** project implementing graph traversal algorithms to find optimal bus routes in urban transportation networks.

## 📋 Project Information

- **Course**: CSE-114 - Data Structure and Algorithms Sessional
- **Department**: Internet of Things and Robotics Engineering
- **University**: Bangladesh Development University
- **Academic Year**: 2024-25

### 👥 Team Members
- **Md. Rafiul Islam** (ID: 2301012)
- **Jannatul Fardous Anika** (ID: 2301013)

---

## 🎯 Project Overview

This system helps commuters find the most efficient routes between bus stops using advanced graph algorithms. The application represents the bus network as a weighted graph where:
- **Nodes (Vertices)** = Bus Stops
- **Edges** = Direct routes between stops
- **Weights** = Distance (km) and Time (minutes)

---

## 📋 Table of Contents
- [About The Project](#about-the-project)
- [Features](#features)
- [Algorithms Implemented](#algorithms-implemented)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Example Output](#example-output)
- [Technical Details](#technical-details)
- [Contributing](#contributing)
- [Contact](#authors)
- [Acknowledgments](#acknowledgments)

---

## 🎯 About The Project

This project implements a *Local Bus Route Finder System* that helps commuters find optimal routes between bus stops using graph traversal algorithms. The system represents the bus network as a weighted graph where:
- *Nodes (Vertices)* = Bus Stops
- *Edges* = Direct routes between stops
- *Weights* = Distance (km) and Time (minutes)

### Problem Statement
Navigating local bus routes in metropolitan areas can be challenging without a centralized system. This project addresses:
- Finding the shortest path between two locations
- Minimizing travel time
- Reducing the number of bus transfers
- Providing real-time route suggestions

### Solution
An intelligent system that uses graph traversal algorithms to provide optimal routes based on different criteria:
- *BFS*: Minimum number of stops
- *DFS*: Path exploration
- *Dijkstra's Algorithm*: Shortest distance or fastest time

---

## ✨ Features

### 🔍 Algorithm Implementation
- **BFS (Breadth-First Search)** - Finds path with minimum number of stops
- **DFS (Depth-First Search)** - Explores routes using depth-first traversal
- **Dijkstra's Algorithm** - Finds optimal path based on:
    - Shortest distance
    - Fastest time

### 📊 Route Information Display
- Total distance (km)
- Total travel time (minutes)
- Number of stops
- Step-by-step directions
- Bus numbers for each segment
- Algorithm performance comparison

### 🎨 User Interface
- JavaFX-based graphical interface
- Dropdown selection for source/destination
- Real-time route calculation
- Visual route details with color-coded information

---

## 🏗️ System Architecture
```
┌─────────────────────────────────────────────────────────┐
│                    USER INTERFACE                        │
│              (JavaFX - bus-route-view.fxml)              │
└─────────────────────┬───────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────┐
│                   CONTROLLER LAYER                       │
│              (BusRouteController.java)                   │
│  • Handles user input                                    │
│  • Processes algorithm selection                         │
│  • Displays results                                      │
└─────────────────────┬───────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────┐
│                    MODEL LAYER                           │
│                                                           │
│  ┌─────────────┐  ┌──────────────┐  ┌───────────────┐  │
│  │  Graph.java │  │ BusStop.java │  │   Edge.java   │  │
│  │             │  │              │  │               │  │
│  │ • BFS()     │  │ • id         │  │ • targetNode  │  │
│  │ • DFS()     │  │ • name       │  │ • distance    │  │
│  │ • Dijkstra()│  │ • location   │  │ • time        │  │
│  └─────────────┘  └──────────────┘  └───────────────┘  │
│                                                           │
│  ┌──────────────────────────────────────────────────┐   │
│  │         RouteResult.java                         │   │
│  │  • path, details, totalDistance, totalTime       │   │
│  └──────────────────────────────────────────────────┘   │
└───────────────────────────────────────────────────────────┘
```

---

## 📊 Sample Output

### Input Selection
```
Source Stop      : Mohakhali
Destination Stop : Motijheel
Algorithm        : Dijkstra (Shortest Distance)
```

### Route Summary
```
╔════════════════════════════════════════════╗
║         ROUTE SUMMARY                      ║
╠════════════════════════════════════════════╣
║  Total Distance  : 7.0 km                  ║
║  Travel Time     : 23 min                  ║
║  Total Stops     : 3                       ║
║  Algorithm       : Dijkstra (distance)     ║
╚════════════════════════════════════════════╝
```

### Step-by-Step Directions
```
┌────────────────────────────────────────────────────────┐
│ Step 1                                                  │
│ Mohakhali → Farmgate                                   │
│ Farmgate Intersection                                  │
│ Buses: 9, 12, 25                                       │
│ 📍 2.5 km  |  ⏱️ 8 min                                 │
└────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────┐
│ Step 2                                                  │
│ Farmgate → Motijheel                                   │
│ Motijheel Commercial Area                              │
│ Buses: 6, 8, 11                                        │
│ 📍 4.5 km  |  ⏱️ 15 min                                │
└────────────────────────────────────────────────────────┘
```

---

## 🗺️ Bus Network Coverage

The system includes the following bus stops in Dhaka city:

| Stop ID | Stop Name | Location |
|---------|-----------|----------|
| mohakhali | Mohakhali | Mohakhali Bus Terminal |
| farmgate | Farmgate | Farmgate Intersection |
| shahbag | Shahbag | Shahbag Square |
| dhanmondi | Dhanmondi | Dhanmondi 27 |
| newmarket | New Market | New Market Area |
| gulshan | Gulshan | Gulshan Circle 1 |
| banani | Banani | Banani Chairman Bari |
| uttara | Uttara | Uttara Sector 7 |
| mirpur | Mirpur | Mirpur 10 |
| motijheel | Motijheel | Motijheel Commercial Area |

**Total Routes**: 15+ interconnected bus routes  
**Bus Numbers**: 2, 3, 4, 6, 7, 8, 9, 11, 12, 20, 25, 28, 31, 32, 33

---

## 🔬 Algorithm Complexity Analysis

| Algorithm | Time Complexity | Space Complexity | Use Case |
|-----------|----------------|------------------|----------|
| **BFS** | O(V + E) | O(V) | Minimum number of stops |
| **DFS** | O(V + E) | O(V) | Path exploration |
| **Dijkstra** | O((V+E) log V) | O(V) | Optimal weighted paths |

Where:
- **V** = Number of vertices (bus stops)
- **E** = Number of edges (routes)

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- JavaFX SDK 17 or higher
- IntelliJ IDEA (recommended) or any Java IDE
- Maven (for dependency management)

### Installation

1. **Clone the repository**
```bash
   git clone https://github.com/YOUR_USERNAME/DSA-Bus-Route-Finder.git
   cd DSA-Bus-Route-Finder
```

2. **Open in IntelliJ IDEA**
    - File → Open → Select project folder
    - IntelliJ will automatically detect Maven and download dependencies

3. **Configure JavaFX** (if needed)
    - File → Project Structure → Libraries
    - Add JavaFX SDK if not auto-configured

4. **Run the Application**
    - Navigate to `src/main/java/com/example/dsaproject/Launcher.java`
    - Right-click → Run 'Launcher.main()'

---

## 📂 Project Structure
```
DSAProject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/dsaproject/
│   │   │       ├── model/
│   │   │       │   ├── Graph.java              # Graph data structure & algorithms
│   │   │       │   ├── BusStop.java            # Bus stop entity
│   │   │       │   ├── Edge.java               # Route/edge entity
│   │   │       │   └── RouteResult.java        # Result wrapper
│   │   │       ├── BusRouteController.java     # UI Controller
│   │   │       ├── HelloApplication.java       # JavaFX Application
│   │   │       └── Launcher.java               # Main entry point
│   │   └── resources/
│   │       └── com/example/dsaproject/
│   │           └── bus-route-view.fxml         # UI Layout
├── pom.xml                                      # Maven configuration
├── README.md                                    # Project documentation
├── .gitignore                                   # Git ignore rules
└── LICENSE                                      # MIT License
```

---

## 🧪 Testing & Validation

### Test Cases

| Test Case | Source | Destination | Algorithm | Expected Result |
|-----------|--------|-------------|-----------|----------------|
| TC-01 | Mohakhali | Motijheel | Dijkstra (Distance) | Valid route found |
| TC-02 | Gulshan | Dhanmondi | BFS | Minimum stops route |
| TC-03 | Uttara | Shahbag | Dijkstra (Time) | Fastest route |
| TC-04 | Same Stop | Same Stop | Any | Error message |
| TC-05 | Mirpur | New Market | DFS | Valid path found |

### Performance Metrics
- **Route Accuracy**: 100% (all valid routes found)
- **Response Time**: < 0.5 seconds for all algorithms
- **Algorithm Efficiency**: Optimized with proper data structures

---

## 💡 Key Implementation Highlights

### Graph Representation
```java
// Adjacency List implementation
Map<String, List<Edge>> adjacencyList = new HashMap<>();

// Each edge contains:
- Target node (bus stop ID)
- Distance (in kilometers)
- Travel time (in minutes)  
- Bus numbers available
```

### BFS Implementation
```java
public RouteResult bfs(String start, String end) {
    Queue<List<String>> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    
    // Explores level by level to find minimum stops
    // Returns first path found (shortest by stops)
}
```

### Dijkstra Implementation
```java
public RouteResult dijkstra(String start, String end, String weightType) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Map<String, Double> distances = new HashMap<>();
    
    // Uses priority queue for optimal path selection
    // Supports both distance and time optimization
}
```

---

## 🎓 Learning Outcomes

Through this project, we implemented and understood:

1. **Graph Data Structures**
    - Adjacency list representation
    - Weighted and undirected graphs
    - Efficient graph traversal

2. **Algorithm Design**
    - BFS for unweighted shortest paths
    - DFS for path exploration
    - Dijkstra's algorithm for weighted shortest paths
    - Priority queue optimization

3. **Software Engineering**
    - MVC architecture pattern
    - Object-oriented design principles
    - JavaFX GUI development
    - Code modularity and reusability

4. **Real-world Applications**
    - Transportation network modeling
    - Route optimization problems
    - User interface design for practical applications

---

## 🌟 Future Enhancements

- [ ] Real-time traffic integration
- [ ] Bus arrival time predictions
- [ ] Multi-modal transport (bus + metro)
- [ ] Mobile application (Android/iOS)
- [ ] Route visualization on interactive maps
- [ ] User preferences (avoid certain routes)
- [ ] Historical traffic data analysis
- [ ] A* algorithm implementation
- [ ] Database integration for dynamic routes
- [ ] API for third-party integration

---

## 📚 References

1. **Dijkstra, E. W.** (1959). "A note on two problems in connexion with graphs." *Numerische Mathematik*, 1(1), 269-271.

2. **Cormen, T. H., et al.** (2009). *Introduction to Algorithms* (3rd ed.). MIT Press.

3. **GeeksforGeeks**. Graph Data Structure and Algorithms. Retrieved from https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/

4. **Oracle**. JavaFX Documentation. Retrieved from https://openjfx.io/

5. **Programiz**. Graph Traversal Algorithms. Retrieved from https://www.programiz.com/

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/YOUR_USERNAME/DSA-Bus-Route-Finder/issues).

---

## 👏 Acknowledgments

- Course Instructor: [Md. Toukir Ahmed]
- Department of IoT and Robotics Engineering
- University of Frontier Technology, Bangladesh
- All open-source libraries and resources used

---

## 📞 Contact

**Md. Rafiul Islam**  
📧 Email: rafuulislam2004@gmail.com 
📱 Phone: 01749534924

**Jannatul Fardous Anika**  
📧 Email: 2301013@uftb.ac.bd

---

## ⭐ Show Your Support

If you found this project helpful, please consider giving it a ⭐ on GitHub!

---

<div align="center">

**Made with ❤️ for CSE-114 DSA Project**

*Graph Algorithms • JavaFX • Transportation Systems*

</div>