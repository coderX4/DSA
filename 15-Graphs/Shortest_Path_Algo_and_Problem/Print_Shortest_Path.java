package Shortest_Path_Algo_and_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Print_Shortest_Path {
    static ArrayList<Integer> Shortest_Path_using_PriorityQueue(int n, int src, int dest, Graph graph) {
        PriorityQueue<NodeWeightPair> pq =
                new PriorityQueue<>();

        int[] dist = new int[n];
        int[] parent = new int[n];
        for(int i = 0;i <n ;i++){
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        pq.add(new NodeWeightPair(src,0));
        dist[src] = 0;

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
                    parent[adjnode] = node;
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        int node = dest;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);

        System.out.println("Path cost: "+dist[dest]);

        return path;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        Graph graph = new Graph(6,edges,false,true);
        graph.Print_weighted();
        ArrayList<Integer> ans = Shortest_Path_using_PriorityQueue(6,3,4,graph);
        System.out.println(ans);
    }

}
