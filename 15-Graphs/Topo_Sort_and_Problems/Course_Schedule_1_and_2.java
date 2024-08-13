package Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_1_and_2 {
	static ArrayList<Integer> Schedule_2(Graph<Integer> graph){
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
	
	static boolean Schedule_1(Graph<Integer> graph){
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
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{3,9},{9,10},{10,6}};
        Integer[][] edges2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{9,3},{10,9},{6,10}};
        Graph<Integer> graph = new Graph<>(edges,false);
        graph.Print();

        boolean ans1 = Schedule_1(graph);
        System.out.println(ans1);
        
        ArrayList<Integer> ans2 = Schedule_2(graph);
        System.out.println(ans2);
    }

}
