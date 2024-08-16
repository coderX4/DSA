package Shortest_Path_Algo_and_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_Directed_Graph {
    static ArrayList<Integer> Toposort(Graph graph){
        int v = graph.adjList2.size();
        int[] indegree = new int[v];
        ArrayList<Integer> sort = new ArrayList<>();

        for(int i = 0;i < v;i++){
            for(Graph.Pair it: graph.adjList2.get(i)){
                indegree[it.node]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                qu.offer(i);
            }
        }

        while(!qu.isEmpty()){
            int node = qu.poll();
            sort.add(node);
            for(Graph.Pair it: graph.adjList2.get(node)){
                indegree[it.node]--;
                if(indegree[it.node]==0){
                    qu.offer(it.node);
                }
            }
        }
        return sort;
    }

    static int[] Shortest_Path(int n,int src,Graph graph){
        ArrayList<Integer> topo = Toposort(graph);
        int[] dist = new int[n];
        for(int i =0 ;i < n;i++){
            if(i == src){
                dist[i] = 0;
            }
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        for(int i = 0;i < topo.size();i++){
            int node = topo.get(i);
            for(int j =0 ;j < graph.adjList2.get(node).size();j++){
                int v = graph.adjList2.get(node).get(j).node;
                int wt = graph.adjList2.get(node).get(j).weight;
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        Graph graph = new Graph(6,edges,true,true);
        graph.Print_weighted();
        int[] ans = Shortest_Path(6,4,graph);
        System.out.println(Arrays.toString(ans));
    }


}
