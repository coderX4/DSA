package Shortest_Path_Algo_and_Problem;

import java.util.ArrayList;
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
        for(int i:dist){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int it:topo){

        }

    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{1,3,1},{4,0,3},{6,4,2},{6,5,3},{5,4,1},{4,2,1},{2,3,3}};
        Graph graph = new Graph(7,edges,true,true);
        graph.Print_weighted();
    }
}
