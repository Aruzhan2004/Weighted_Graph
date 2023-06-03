
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        graph.addEdge("Almaty", "Astana", 3.8);
        graph.addEdge("Almaty", "Shymkent", 3.8);
        graph.addEdge("Shymkent", "Astana", 9.7);
        graph.addEdge("Astana", "Kostanay", 1.4);
        graph.addEdge("Shymkent", "Kyzylorda", 9.6);

        System.out.println("Vertices count: " + graph.getVerticesCount());
        System.out.println("Edges count: " + graph.getEdgesCount());

        System.out.println("Graph has vertex 'Almaty': " + graph.hasVertex("Almaty"));
        System.out.println("Graph has vertex 'Nur-Sultan': " + graph.hasVertex("Nur-Sultan"));

        System.out.println("Graph has edge 'Almaty' to 'Astana': " + graph.hasEdge("Almaty", "Astana"));
        System.out.println("Graph has edge 'Shymkent' to 'Kostanay': " + graph.hasEdge("Shymkent", "Kostanay"));

        System.out.println("Adjacency list of 'Almaty': " + graph.adjacencyList("Almaty"));

        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        System.out.println("DFS has path to 'Kyzylorda': " + dfs.hasPathTo("Kyzylorda"));
        System.out.print("DFS path to 'Kyzylorda': ");
        outputPath(dfs, "Kyzylorda");
        System.out.println();

        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        System.out.println("BFS has path to 'Kyzylorda': " + bfs.hasPathTo("Kyzylorda"));
        System.out.print("BFS path to 'Kyzylorda': ");
        outputPath(bfs, "Kyzylorda");
        System.out.println();

        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        System.out.println("Dijkstra has path to 'Kyzylorda': " + djk.hasPathTo("Kyzylorda"));
        System.out.print("Dijkstra path to 'Kyzylorda': ");
        outputPath(djk, "Kyzylorda");
        System.out.println();
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path == null) {
            System.out.println("No path found");
            return;
        }
        for (String v : path) {
            System.out.print(v + " -> ");
        }
    }
}