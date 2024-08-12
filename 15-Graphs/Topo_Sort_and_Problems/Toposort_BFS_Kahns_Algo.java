package Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Toposort_BFS_Kahns_Algo {
    static ArrayList<Integer> Toposort(Graph<Integer> graph){
        int v = graph.map.size();
        int[] indegree = new int[v];
        for(Integer key:graph.map.keySet()){
            for(Integer it: graph.map.get(key)){
                indegree[it]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                qu.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!qu.isEmpty()){
            int node = qu.poll();
            ans.add(node);
            for(Integer it: graph.map.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Integer[][] edges = {{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}};
        Graph<Integer> graph = new Graph<>(edges,false);
        graph.Print();

        ArrayList<Integer> ans = Toposort(graph);
        System.out.println(ans);
    }
}
