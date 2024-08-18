package Shortest_Path_Algo_and_Problem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Number_of_ways_with_Lowest_cost {
    static int Number_ways(int n,int src,int dest,Graph graph) {
        PriorityQueue<NodeWeightPair> pq =
                new PriorityQueue<>();

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, (int) 1e9);
        Arrays.fill(ways,0);

        pq.add(new NodeWeightPair(src,0));
        dist[src] = 0;
        ways[src] = 1;

        while(!pq.isEmpty()) {
            NodeWeightPair current = pq.poll();
            int node = current.node;
            int dis = current.weight;
            for(Graph.Pair it : graph.adjList2.get(node)) {
                int adjnode = it.node;
                int edgewt = it.weight;
                if(dis + edgewt < dist[adjnode]) {
                    dist[adjnode] = edgewt + dis;
                    pq.add(new NodeWeightPair(adjnode,dist[adjnode]));
                    ways[adjnode] = ways[node];
                }
                else if(dis + edgewt == dist[adjnode]){
                    ways[adjnode] = ways[node] + ways[adjnode];
                }
            }
        }

        return ways[dest];
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 1},{0, 2, 2},{0, 3, 1},{0, 4, 2},{1, 5, 2},{2, 5, 1},{3, 5, 2},{3, 7, 3},{3, 6, 2},{4, 6, 1},
                         {5,8,1},{7,8,1},{6,8,1}};
        Graph graph = new Graph(9,edges,false,true);
        graph.Print_weighted();
        int ans = Number_ways(9,0,8,graph);
        System.out.println(ans);

    }
}
