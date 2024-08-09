package Learning;

import java.util.ArrayList;
import java.util.Stack;

public class DFS_Graph {

    static void DFS_Traversal(Graph<Integer> graph,boolean[] visited ,Integer node,ArrayList<Integer> ans){

        visited[node] = true;
        ans.add(node);
        for(Integer value:graph.map.get(node)){
            if(visited[value] == false){
                DFS_Traversal(graph,visited,value,ans);
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{1,3},{2,5},{2,6},{3,4},{3,7},{4,8},{7,8}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();

        ArrayList<Integer> dfs = new ArrayList<>();
        int n = graph.map.size();
        boolean[] visited = new boolean[n+1];
        DFS_Traversal(graph,visited,1,dfs);
        System.out.println("DFS Traversal: "+dfs);
    }
}
