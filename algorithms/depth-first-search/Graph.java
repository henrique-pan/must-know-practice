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
 
    void addEdge(int v, int w) {
        adjacencyLists[v].add(w);
    }
 
    void dfsUtil(int v, boolean visited[]) {        
        visited[v] = true;
        System.out.print(v + " ");
 
        Iterator<Integer> iterator = adjacencyLists[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n])
                dfsUtil(n, visited);
        }
    }

    void dfs(int v) {
        boolean visited[] = new boolean[numVertices];
        dfsUtil(v, visited);
        System.out.println("");
    }
 
    public static void main(String args[]) {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        g.dfs(2);
    }
}
// This code is contributed by Aakash Hasija