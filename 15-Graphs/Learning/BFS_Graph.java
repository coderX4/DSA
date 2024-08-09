package Learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Graph {

    static ArrayList<Integer> BFS_Traversal(Graph<Integer> graph, Integer startnode){
        int n = graph.map.size();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> qu = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Integer firstkey = startnode;
        qu.offer(firstkey);
        visited[firstkey] = true;

        while(!qu.isEmpty()){
            Integer node = qu.poll();
            ans.add(node);

            for(Integer value: graph.map.get(node)){
                if(visited[value] == false){
                    visited[value] = true;
                    qu.offer(value);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{1,6},{2,3},{2,4},{6,7},{6,9},{4,5},{7,8},{5,8}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();
        Integer startnode = 3;
        ArrayList<Integer> bfs = BFS_Traversal(graph,startnode);
        System.out.println("BFS Traversal: "+bfs);

    }
}
