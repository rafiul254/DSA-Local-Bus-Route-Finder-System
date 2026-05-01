# 🚌 Local Bus Route Finder System

A comprehensive **Data Structures and Algorithms (DSA)** project implementing graph traversal algorithms to find optimal bus routes in urban transportation networks.

## 📋 Project Information

- **Course**: CSE-114 - Data Structure and Algorithms Sessional
- **Department**: Internet of Things and Robotics Engineering
- **University**: University of Frontier Technology,Bangladesh
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

### Algorithm Comparison Example

| Route | Algorithm | Distance | Time | Stops |
|-------|-----------|----------|------|-------|
| Mohakhali → Motijheel | BFS | 8.8 km | 30 min | 4 |
| Mohakhali → Motijheel | Dijkstra (Distance) | 7.0 km | 23 min | 3 |
| Mohakhali → Motijheel | Dijkstra (Time) | 7.0 km | 23 min | 3 |

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

### Network Connectivity
```
    Uttara
      |
    Banani
      |
   Gulshan ---- Mirpur
      |           |
  Mohakhali ------+
      |
   Farmgate
      |
   Shahbag ---- Dhanmondi
      |           |
  New Market ----+
      |
  Motijheel
```

---

## 🔬 Algorithm Complexity Analysis

| Algorithm | Time Complexity | Space Complexity | Use Case |
|-----------|----------------|------------------|----------|
| **BFS** | O(V + E) | O(V) | Minimum number of stops |
| **DFS** | O(V + E) | O(V) | Path exploration |
| **Dijkstra** | O((V+E) log V) | O(V) | Optimal weighted paths |

Where:
- **V** = Number of vertices (bus stops) = 10
- **E** = Number of edges (routes) = 15+

### Performance Metrics

For the sample network:
- **BFS**: Processes ~6 nodes on average
- **DFS**: Explores ~8 nodes on average
- **Dijkstra**: Evaluates ~7 nodes with priority queue optimization

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
   git clone https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System.git
   cd DSA-Local-Bus-Route-Finder-System
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

### Quick Start Commands
```bash
# Clone repository
git clone https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System.git

# Navigate to project
cd DSA-Local-Bus-Route-Finder-System

# Build with Maven
mvn clean install

# Run application
mvn javafx:run
```

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
├── LICENSE                                      # MIT License
└── CONTRIBUTING.md                              # Contribution guidelines
```

---

## 🧪 Testing & Validation

### Test Cases

| Test ID | Source | Destination | Algorithm | Expected Result | Status |
|---------|--------|-------------|-----------|----------------|--------|
| TC-01 | Mohakhali | Motijheel | Dijkstra (Distance) | 7.0 km, 3 stops | ✅ Pass |
| TC-02 | Gulshan | Dhanmondi | BFS | 5 stops | ✅ Pass |
| TC-03 | Uttara | Shahbag | Dijkstra (Time) | Fastest route | ✅ Pass |
| TC-04 | Mohakhali | Mohakhali | Any | Error: Same stop | ✅ Pass |
| TC-05 | Mirpur | New Market | DFS | Valid path found | ✅ Pass |
| TC-06 | Banani | Motijheel | BFS | Minimum stops | ✅ Pass |

### Performance Metrics
- **Route Accuracy**: 100% (all valid routes found correctly)
- **Response Time**: < 0.5 seconds for all algorithms
- **Algorithm Efficiency**: Optimal node processing
- **UI Responsiveness**: Smooth interaction without lag
- **Memory Usage**: ~50 MB average

---

## 💡 Key Implementation Highlights

### 1. Graph Representation
```java
// Adjacency List implementation
Map<String, List<Edge>> adjacencyList = new HashMap<>();

// Each edge contains:
class Edge {
    String targetNode;      // Destination stop ID
    double distance;        // Distance in kilometers
    int time;              // Travel time in minutes
    List<String> busNumbers; // Available bus numbers
}
```

### 2. BFS Implementation (Minimum Stops)
```java
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
        
        // Explore neighbors level by level
        for (Edge edge : adjacencyList.get(node)) {
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
```

### 3. Dijkstra Implementation (Optimal Path)
```java
public RouteResult dijkstra(String start, String end, String weightType) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Map<String, Double> distances = new HashMap<>();
    Map<String, String> previous = new HashMap<>();
    
    // Initialize distances
    for (String node : adjacencyList.keySet()) {
        distances.put(node, Double.POSITIVE_INFINITY);
    }
    distances.put(start, 0.0);
    pq.add(new Node(start, 0.0));
    
    // Process nodes by priority
    while (!pq.isEmpty()) {
        Node current = pq.poll();
        if (current.id.equals(end)) break;
        
        for (Edge edge : adjacencyList.get(current.id)) {
            double weight = weightType.equals("distance") 
                          ? edge.getDistance() 
                          : edge.getTime();
            double newDist = distances.get(current.id) + weight;
            
            if (newDist < distances.get(edge.getTargetNode())) {
                distances.put(edge.getTargetNode(), newDist);
                previous.put(edge.getTargetNode(), current.id);
                pq.add(new Node(edge.getTargetNode(), newDist));
            }
        }
    }
    
    // Reconstruct path
    return constructPathFromPrevious(previous, start, end);
}
```

### 4. JavaFX Controller Integration
```java
@FXML
private void onFindRoute() {
    BusStop source = sourceComboBox.getValue();
    BusStop destination = destinationComboBox.getValue();
    String algorithm = algorithmComboBox.getValue();
    
    RouteResult result = null;
    
    if (algorithm.startsWith("BFS")) {
        result = graph.bfs(source.getId(), destination.getId());
    } else if (algorithm.startsWith("DFS")) {
        result = graph.dfs(source.getId(), destination.getId());
    } else if (algorithm.contains("Distance")) {
        result = graph.dijkstra(source.getId(), destination.getId(), "distance");
    } else {
        result = graph.dijkstra(source.getId(), destination.getId(), "time");
    }
    
    displayResult(result);
}
```

---

## 🎓 Learning Outcomes

Through this project, we implemented and understood:

### 1. Graph Data Structures
- Adjacency list representation for efficient storage
- Weighted and undirected graph implementation
- Efficient graph traversal techniques
- Space complexity optimization

### 2. Algorithm Design & Analysis
- **BFS**: Level-order traversal for unweighted shortest paths
- **DFS**: Depth-first exploration with backtracking
- **Dijkstra's Algorithm**: Greedy approach with priority queue
- Time and space complexity analysis
- Trade-offs between different algorithms

### 3. Software Engineering Principles
- **MVC Architecture**: Separation of concerns
- **Object-Oriented Design**: Encapsulation, inheritance, polymorphism
- **Code Modularity**: Reusable components
- **JavaFX GUI Development**: Event-driven programming
- **Version Control**: Git and GitHub workflow

### 4. Real-world Applications
- Transportation network modeling
- Route optimization problems
- Graph theory in practical scenarios
- User interface design for end-users
- Algorithm selection based on requirements

### 5. Problem-Solving Skills
- Breaking down complex problems
- Choosing appropriate data structures
- Optimizing algorithm performance
- Handling edge cases and errors
- Testing and validation strategies

---

## 🌟 Future Enhancements

### Short-term Goals
- [ ] Add more bus stops (expand to 50+ stops)
- [ ] Include bus frequency information
- [ ] Add transfer penalties for route changes
- [ ] Implement route history feature
- [ ] Add favorite routes functionality

### Medium-term Goals
- [ ] Real-time traffic integration using APIs
- [ ] Bus arrival time predictions using ML
- [ ] Multi-modal transport (bus + metro + rickshaw)
- [ ] Interactive map visualization (Google Maps API)
- [ ] User authentication and personalization
- [ ] Mobile responsiveness

### Long-term Goals
- [ ] Mobile application (Android/iOS)
- [ ] Live bus tracking with GPS
- [ ] Crowdsourced traffic updates
- [ ] Historical traffic data analysis
- [ ] A* algorithm implementation
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] REST API for third-party integration
- [ ] Machine learning for route recommendations
- [ ] Multi-language support (Bengali, English)
- [ ] Accessibility features for disabled users

### Advanced Features
- [ ] Public transport cost calculation
- [ ] Carbon footprint comparison (bus vs car)
- [ ] Peak hour route optimization
- [ ] Weather-based route suggestions
- [ ] Integration with ride-sharing services
- [ ] Voice-guided navigation
- [ ] Offline mode support
- [ ] Route sharing via QR code

---

## 📚 References

### Academic Papers
1. **Dijkstra, E. W.** (1959). "A note on two problems in connexion with graphs." *Numerische Mathematik*, 1(1), 269-271.
2. **Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C.** (2009). *Introduction to Algorithms* (3rd ed.). MIT Press.
3. **Sedgewick, R., & Wayne, K.** (2011). *Algorithms* (4th ed.). Addison-Wesley Professional.

### Online Resources
4. **GeeksforGeeks**. Graph Data Structure and Algorithms. Retrieved from https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/
5. **Programiz**. Graph Traversal Algorithms (BFS, DFS). Retrieved from https://www.programiz.com/
6. **Oracle**. JavaFX Documentation. Retrieved from https://openjfx.io/
7. **Baeldung**. Graph Algorithms in Java. Retrieved from https://www.baeldung.com/java-graphs

### Tools & Technologies
8. **IntelliJ IDEA Documentation**. Retrieved from https://www.jetbrains.com/idea/documentation/
9. **Maven Documentation**. Retrieved from https://maven.apache.org/guides/
10. **Git Documentation**. Retrieved from https://git-scm.com/doc

### Dhaka Transportation
11. **Shohoz**. Dhaka Bus Route App. Retrieved from https://www.shohoz.com
12. **Google Maps**. Route Planning System. Retrieved from https://maps.google.com
13. **BRTA**. Bangladesh Road Transport Authority. Retrieved from http://www.brta.gov.bd/

### Additional Resources
14. YouTube tutorials on Graph Algorithms
15. GitHub repositories for similar projects
16. Stack Overflow discussions
17. ChatGPT and AI assistants for problem-solving

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
MIT License

Copyright (c) 2025 Md. Rafiul Islam & Jannatul Fardous Anika

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/issues).

### How to Contribute

1. **Fork the repository**
2. **Create a new branch** (`git checkout -b feature/AmazingFeature`)
3. **Make your changes**
4. **Commit your changes** (`git commit -m 'Add some AmazingFeature'`)
5. **Push to the branch** (`git push origin feature/AmazingFeature`)
6. **Open a Pull Request**

### Code Style Guidelines
- Follow Java naming conventions (camelCase for methods, PascalCase for classes)
- Add JavaDoc comments for public methods
- Maintain consistent indentation (4 spaces)
- Write meaningful commit messages
- Add unit tests for new features

---

## 👏 Acknowledgments

We would like to express our gratitude to:

- **Course Instructor**: For guidance and support throughout the project
- **Department of IoT and Robotics Engineering**: For providing resources and facilities
- **University of Frontier Technology,Bangladesh**: For academic support
- **Open Source Community**: For JavaFX, Maven, and other tools
- **Stack Overflow & GitHub**: For problem-solving resources
- **AI Assistants**: For code optimization suggestions
- **Our Classmates**: For testing and feedback

---

## 📞 Contact

### Md. Rafiul Islam
- 📧 Email: rafuulislam2004@gmail.com
- 📱 Phone: 01749534924
- 🔗 GitHub: [@rafiul254](https://github.com/rafiul254)

### Jannatul Fardous Anika
- 📧 Email: 2301013@uftb.ac.bd


### Project Links
- 🔗 Repository: [DSA-Local-Bus-Route-Finder-System](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System)
- 📝 Issues: [Report a Bug](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/issues)
- 💡 Discussions: [Feature Requests](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/discussions)

---

## ⭐ Show Your Support

If you found this project helpful or interesting, please consider:
- ⭐ **Starring** the repository on GitHub
- 🍴 **Forking** it for your own projects
- 📢 **Sharing** it with others who might benefit
- 💬 **Providing feedback** via issues or discussions
- 🤝 **Contributing** to make it even better

---

## 📊 Project Statistics

![GitHub stars](https://img.shields.io/github/stars/rafiul254/DSA-Local-Bus-Route-Finder-System?style=social)
![GitHub forks](https://img.shields.io/github/forks/rafiul254/DSA-Local-Bus-Route-Finder-System?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/rafiul254/DSA-Local-Bus-Route-Finder-System?style=social)
![GitHub repo size](https://img.shields.io/github/repo-size/rafiul254/DSA-Local-Bus-Route-Finder-System)
![GitHub language count](https://img.shields.io/github/languages/count/rafiul254/DSA-Local-Bus-Route-Finder-System)
![GitHub top language](https://img.shields.io/github/languages/top/rafiul254/DSA-Local-Bus-Route-Finder-System)
![GitHub last commit](https://img.shields.io/github/last-commit/rafiul254/DSA-Local-Bus-Route-Finder-System)

---

## 🏆 Project Highlights

- ✅ **3 Graph Algorithms** implemented (BFS, DFS, Dijkstra)
- ✅ **10+ Bus Stops** with realistic Dhaka locations
- ✅ **15+ Routes** interconnecting the network
- ✅ **JavaFX GUI** with professional design
- ✅ **Real-time Calculation** (< 0.5 seconds response)
- ✅ **100% Test Pass Rate** on all test cases
- ✅ **MVC Architecture** for clean code organization
- ✅ **Comprehensive Documentation** with examples
- ✅ **MIT Licensed** open source project

---

<div align="center">

## 🚀 **Made with ❤️ for CSE-114 DSA Project**

### *Graph Algorithms • JavaFX • Transportation Systems*

**University of Frontier Technology,Bangladesh | 2025**

---

### 🔗 Quick Links

[🏠 Home](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System) •
[📖 Documentation](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/wiki) •
[🐛 Report Bug](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/issues) •
[💡 Request Feature](https://github.com/rafiul254/DSA-Local-Bus-Route-Finder-System/issues)

---

**⭐ Star this repo if you find it helpful!**

</div>

