package Problems_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_Undirected_BFS {
    static class Pair{
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean Detect_Cycle(Graph<Integer> graph,int src){
        int n = graph.map.size();
        int[] vis = new int[n+1];
        vis[src] = 1;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(src,-1));

        while(!qu.isEmpty()){
            int node = qu.peek().node;
            int parent = qu.peek().parent;
            qu.remove();

            for(Integer adjnode: graph.map.get(node)){
                if(vis[adjnode] == 0){
                    vis[adjnode] = 1;
                    qu.offer(new Pair(adjnode,node));
                } else if (parent != adjnode) {
                    return  true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,5},{1,3},{4,3},{3,6},{7,6},{5,7}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();

        boolean ans = Detect_Cycle(graph,1);
        if(ans){
            System.out.println("Cyclic Graph");
        }
        else{
            System.out.println("Acyclic Graph");
        }
    }
}
