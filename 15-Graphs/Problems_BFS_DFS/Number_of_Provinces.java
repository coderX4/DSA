package Problems_BFS_DFS;

public class Number_of_Provinces {
    static int num_provinces(Graph<Integer> graph){
        int n = graph.map.size();
        int[] vis = new int[n+1];
        int cnt = 0;

        for(int i = 1;i <= n;i++){
            if(vis[i] == 0){
                cnt++;
                DFS(graph,vis,i);
            }
        }
        return cnt;
    }

    static void DFS(Graph<Integer> graph, int[] visited , Integer node){

        visited[node] = 1;

        for(Integer value:graph.map.get(node)){
            if(visited[value] == 0){
                DFS(graph,visited,value);
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{4,5},{5,6},{7,8}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();

        int num_provinces = num_provinces(graph);
        System.out.println("Result: "+num_provinces);

    }
}
