import java.io.*;
import java.util.*;
 
class Graph {
    
    private int numVertices;
    private LinkedList<Integer> adjacencyLists[]; // Adjacency Lists
 
    Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyLists = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adjacencyLists[i] = new LinkedList();
        }            
    }
 
    void addEdge(int v,int w) {
        adjacencyLists[v].add(w);
    }
 
    void bfs(int s) {

        boolean visited[] = new boolean[numVertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);
 
        while (!queue.isEmpty()) {
            
            s = queue.poll();
            
            System.out.print(s + " ");
 
            Iterator<Integer> iterator = adjacencyLists[s].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println("");
    }
 
    public static void main(String args[]) {
        Graph graph = new Graph(4);
 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
 
        graph.bfs(2);
    }
}