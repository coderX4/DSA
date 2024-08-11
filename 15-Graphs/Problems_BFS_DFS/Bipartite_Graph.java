package Problems_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {

    static boolean BFS(int start,int[] color,Graph<Integer> graph){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        color[start] = 1;

        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.remove();

            for(Integer adjnode: graph.map.get(node)){
                if(color[adjnode] == -1){
                    //toggle btw 0 and 1
                    // 1 ^ 1 = 0 && 1 ^ 0 = 1
                    color[adjnode] = 1 ^ color[node];
                    qu.offer(adjnode);
                }
                else{
                    if(color[adjnode] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean DFS(int node,int col,int[] color,Graph<Integer> graph){
        color[node] = col;
        for(Integer adjnode: graph.map.get(node)){
            if(color[adjnode] == -1){
                if(!DFS(adjnode,1 ^ col,color,graph)){
                    return false;
                }
            }
            else{
                if(color[adjnode] == col){
                    return false;
                }
            }
        }
        return true;
    }

    static  boolean Check_Bipartite(Graph<Integer> graph){
        int v = graph.map.size();
        int[] color = new int[v+1];

        for(int i = 0;i <= v;i++){
            color[i] = -1;
        }

        for(int i = 1;i <= v;i++){
            if(color[i] == -1){
//                if(!BFS(i, color, graph)){
//                    return false;
//                }
                if(!DFS(i,1,color,graph)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{3,9},{9,10},{10,6}};
        //Integer[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{2,7},{7,8},{4,8}};
        Graph<Integer> graph = new Graph<>(edges,true);
        graph.Print();

        boolean ans = Check_Bipartite(graph);
        System.out.println(ans);

    }
}
