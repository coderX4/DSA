package Problems_BFS_DFS;

public class Detect_Cycle_Undirected_DFS {
    static boolean Detect_Cycle_DFS(int node,int parent,int[] vis,Graph<Integer> graph){
        vis[node] = 1;

        for (Integer adjnode : graph.map.get(node)) {
            if (vis[adjnode] == 0) {
                if(Detect_Cycle_DFS(adjnode,node,vis,graph)){ // == true
                    return true;
                }
            } else if (parent != adjnode) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,5},{1,3},{4,3},{3,6},{7,6}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();

        int n = graph.map.size();
        int[] vis = new int[n+1];
        boolean ans = Detect_Cycle_DFS(1,-1,vis,graph);
        if(ans){
            System.out.println("Cyclic Graph");
        }
        else{
            System.out.println("Acyclic Graph");
        }
    }
}
