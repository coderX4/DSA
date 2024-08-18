package Shortest_Path_Algo_and_Problem;

import java.util.ArrayList;
import java.util.Arrays;

class Edges{
    int u;
    int v;
    int wt;
    Edges(int u,int v,int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
public class BellMan_Ford_Algo {
    static int[] Bellman_ford(int n,int src, ArrayList<Edges> edges){
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        for(int i = 0;i < n-1; i++){
            for(Edges it:edges){
                int u = it.u;
                int v = it.v;
                int wt = it.wt;
                if(dist[u] + wt < dist[v] && dist[u] != 1e9){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(Edges it:edges){
            int u = it.u;
            int v = it.v;
            int wt = it.wt;
            if(dist[u] + wt < dist[v] && dist[u] != 1e9){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Edges> edges = new ArrayList<>();
        edges.add(new Edges(3, 2, 6));
        edges.add(new Edges(5, 3, 1));
        edges.add(new Edges(0, 1, 5));
        edges.add(new Edges(1, 5, -3));
        edges.add(new Edges(1, 2, -2));
        edges.add(new Edges(3, 4, -2));
        edges.add(new Edges(2, 4, 3));


        int[] ans = Bellman_ford(n,0,edges);
        System.out.println(Arrays.toString(ans));

    }
}
