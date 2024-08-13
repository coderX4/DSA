package com.Dsa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Find_Safe_state_BFS {
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
	
	static ArrayList<Integer> Find_safe_state(Graph<Integer> graph){
		ArrayList<Integer> ans = new ArrayList<>();
		
		graph.Reverse_Edges();
		graph.Print();
		
		
		ans = Toposort(graph);
		return ans;
	}
    public static void main(String[] args) {
        Integer[][] edges = {{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}};
        Graph<Integer> graph = new Graph<>(edges,false);
       
        ArrayList<Integer> ans = Find_safe_state(graph);
        System.out.println(ans);
    }

}
