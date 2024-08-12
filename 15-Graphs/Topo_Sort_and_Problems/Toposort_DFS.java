package Topo_Sort_and_Problems;


import java.util.ArrayList;
import java.util.Stack;

public class Toposort_DFS {
    static void DFS(int node, int[] vis, Stack<Integer> st,Graph<Integer> graph){
        vis[node] = 1;

        for(Integer it: graph.map.get(node)){
            if(vis[it] == 0){
                if(graph.map.get(it) == null){
                    return;
                }
                DFS(it,vis,st,graph);
            }
        }
        st.push(node);
    }

    static ArrayList<Integer> Topo_sort(Graph<Integer> graph){
        int v = graph.map.size();
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                DFS(i,vis,st,graph);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}};
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        Graph<Integer> graph = new Graph<>(edges,false,adjList);
        graph.Print();

        ArrayList<Integer> ans = Topo_sort(graph);
        System.out.println(ans);
    }
}
