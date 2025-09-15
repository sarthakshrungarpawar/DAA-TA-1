public class BellmanFord11 {
    static final int V = 11; 
    static final int INF = 1000000;

    
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
    }

    public static void bellmanFord(Edge[] edges, int E, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = INF;
        dist[src] = 0;

        
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        
        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;
            if (dist[u] != INF && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
       
        Edge[] edges = {
            new Edge(0, 1, 5),
            new Edge(0, 2, 2),
            new Edge(1, 3, 6),
            new Edge(2, 3, 7),
            new Edge(2, 4, 4),
            new Edge(3, 5, -1),
            new Edge(4, 5, 3),
            new Edge(5, 6, 2),
            new Edge(6, 7, 1),
            new Edge(7, 8, -2),
            new Edge(8, 9, 4),
            new Edge(9, 10, 6),
            new Edge(1, 4, 2),
            new Edge(4, 7, 5),
            new Edge(3, 8, 3)
        };

        int E = edges.length;
        bellmanFord(edges, E, 0);
    }
}

