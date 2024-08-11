package Topo_Sort_and_Problems;

import java.util.ArrayList;

public class Find_eventual_safe_states_DFS {
    static boolean DFS_check(int node, int[] vis, int[] path,int[] check, Graph<Integer> graph){
        vis[node] = 1;
        path[node] = 1;
        check[node] = 0;

        for(Integer it: graph.map.get(node)){
            if(vis[it] == 0){
                if(graph.map.get(it) == null){
                    path[it] = 0;
                    check[node] = 1;
                    return false;
                }
                if(DFS_check(it,vis,path,check,graph)){
                    check[node] = 0;
                    return true;
                }
            }
            else{
                if(path[it] == 1){
                    check[node] = 0;
                    return true;
                }
            }
        }
        path[node] = 0;
        check[node] = 1;
        return false;
    }

    static ArrayList<Integer> Find_safe_states(Graph<Integer> graph){
        int v = graph.map.size();
        int[] vis = new int[v+1];
        int[] path = new int[v+1];
        int[] check = new int[v+1];
        ArrayList<Integer> safe = new ArrayList<>();

        for(int i = 1; i <= v; i++){
            if(vis[i] == 0){
                if(graph.map.get(i) == null){
                    continue;
                }
                DFS_check(i,vis,path,check,graph);
            }
        }
        for(int i = 1; i <= v;i++){
            if(check[i] == 1){
                safe.add(i);
            }
        }
        return safe;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{3,9},{9,10},{10,6}};
        Integer[][] edges2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{9,3},{10,9},{6,10}};
        Graph<Integer> graph = new Graph<Integer>(edges2,false);
        graph.Print();


        ArrayList<Integer> safe = Find_safe_states(graph);
        System.out.println(safe);
    }
}
