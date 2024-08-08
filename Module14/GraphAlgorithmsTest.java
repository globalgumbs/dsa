package Module14;

import java.util.*;

public class GraphAlgorithmsTest {
    public static void main(String[] args) {
        // Creating vertices
        Vertex<Character> a = new Vertex<>('A');
        Vertex<Character> b = new Vertex<>('B');
        Vertex<Character> c = new Vertex<>('C');
        Vertex<Character> d = new Vertex<>('D');
        Vertex<Character> e = new Vertex<>('E');

        // Creating edges
        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(a, b, 2));
        edges.add(new Edge<>(a, c, 3));
        edges.add(new Edge<>(b, c, 1));
        edges.add(new Edge<>(b, d, 4));
        edges.add(new Edge<>(c, d, 5));
        edges.add(new Edge<>(c, e, 6));
        edges.add(new Edge<>(d, e, 7));

        // Creating graph
        Graph<Character> graph = new Graph<>(new HashSet<>(Arrays.asList(a, b, c, d, e)), edges);

        // Running Prim's algorithm
        Set<Edge<Character>> mst = GraphAlgorithms.prims(a, graph);

        // Displaying the result
        System.out.println("Minimum Spanning Tree:");
        for (Edge<Character> edge : mst) {
            System.out.println(edge.getU().getData() + " - " + edge.getV().getData() + " : " + edge.getWeight());
        }
    }
}
