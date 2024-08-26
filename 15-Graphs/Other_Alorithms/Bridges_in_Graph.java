package Other_Alorithms;

import java.util.ArrayList;

public class Bridges_in_Graph {
    static int timer = 1;
    private static void DFS(int node, int parent, int[] vis,
                            ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
                            ArrayList<ArrayList<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                DFS(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] > tin[node]) {
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(it);
                    x.add(node);
                    bridges.add(x);
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
     static ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();

        DFS(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }

    public static void main (String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };
        Graph graph = new Graph(n,edges,false,false);
        graph.Print();
        ArrayList<ArrayList<Integer>> connections = graph.adjList;

        ArrayList<ArrayList<Integer>> bridges = criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println("");
    }
}

