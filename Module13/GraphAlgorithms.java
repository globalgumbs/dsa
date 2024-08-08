package Module13;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Queue<Vertex<T>> q = new LinkedList<>();
        Set<Vertex<T>> vs = new HashSet<>();
        List<Vertex<T>> tracker = new ArrayList<>();
        Vertex<T> v;

        vs.add(start); // Add starting vertex to Visited Set (VS)
        q.add(start); // Add starting vertex to queue
        while (q.size() > 0) { // Do until queue is empty
            v = q.poll(); // Dequeue
            tracker.add(v);
            for (VertexDistance<T> w: graph.getAdjList().get(v)) { // Do for each vertex in the adjacency list for dequeued vertex
                if (!vs.contains(w.getVertex())) { // Add any adjacent vertices to queue and VS, if they have not already been added
                    vs.add(w.getVertex());
                    q.add(w.getVertex());
                }
            }
        }
        return tracker;
    }

    

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> tracker = new ArrayList<>();
        Set<Vertex<T>> vs = new HashSet<>();
        rDfs(start, graph, vs, tracker);
        return tracker;
    }

    private static <T> void rDfs(Vertex<T> start, Graph<T> graph, Set<Vertex<T>> vs, List<Vertex<T>> tracker) {
        vs.add(start);
        tracker.add(start);
        for (VertexDistance<T> w: graph.getAdjList().get(start)) {
            if (!vs.contains(w.getVertex())) {
                rDfs(w.getVertex(), graph, vs, tracker);
            }
        }
    }
}