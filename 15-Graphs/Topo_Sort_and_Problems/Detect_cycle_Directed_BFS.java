package Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_cycle_Directed_BFS {
    static boolean Toposort(Graph<Integer> graph){
        int v = graph.map.size();
        int[] indegree = new int[v+1];
        for(Integer key:graph.map.keySet()){
            for(Integer it: graph.map.get(key)){
                indegree[it]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 1;i<=v;i++){
            if(indegree[i] == 0){
                qu.offer(i);
            }
        }
        int cnt = 0;
        while(!qu.isEmpty()){
            int node = qu.poll();
            cnt++;
            for(Integer it: graph.map.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }
        if(v == cnt){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{3,9},{9,10},{10,6}};
        Integer[][] edges2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{9,3},{10,9},{6,10}};
        Graph<Integer> graph = new Graph<>(edges,false);
        graph.Print();

        boolean ans = Toposort(graph);
        System.out.println(ans);
    }
}
