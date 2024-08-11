package Problems_BFS_DFS;

public class Detect_Cycle_Directed_DFS {
    static boolean DFS_check(int node,int[] vis,int[] path,Graph<Integer> graph){
        vis[node] = 1;
        path[node] = 1;

        for(Integer it: graph.map.get(node)){
            if(vis[it] == 0){
                if(graph.map.get(it) == null){
                    return false;
                }
                if(DFS_check(it,vis,path,graph)){
                    return true;
                }
            }
            else{
                if(path[it] == 1){
                    return true;
                }
            }
        }
        path[node] = 0;
        return false;
    }

    static boolean Check_cycle(int v,Graph<Integer> graph){
        int[] vis = new int[v+1];
        int[] path = new int[v+1];

        for(int i = 1; i <= v; i++){
            if(vis[i] == 0){
                if(!graph.map.containsKey(i)){
                    return false;
                }
                if(DFS_check(i,vis,path,graph)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{3,9},{9,10},{10,6}};
        Integer[][] edges2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{9,3},{10,9},{6,10}};
        Graph<Integer> graph = new Graph<>(edges2,false);
        graph.Print();

        boolean ans = Check_cycle(10,graph);
        System.out.println(ans);
    }
}
