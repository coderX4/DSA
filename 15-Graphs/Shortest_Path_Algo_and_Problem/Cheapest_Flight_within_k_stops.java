package Shortest_Path_Algo_and_Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Cheapest_Flight_within_k_stops {
    static class Tuple{
        int node;
        int dis;
        int stop;
        Tuple(int node,int dis,int stop){
            this.node = node;
            this.dis = dis;
            this.stop = stop;
        }
    }
    static int Cost_flight(int n,int k,int src,int dest,Graph graph){
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src,0,0));

        while(!q.isEmpty()) {
            Tuple curr = q.peek();
            int node = curr.node;
            int dis = curr.dis;
            int stop = curr.stop;
            q.remove();

            if(stop > k)
                continue;
            for(Graph.Pair it : graph.adjList2.get(node)) {
                int adjnode = it.node;
                int edgewt = it.weight;
                if(dis + edgewt < dist[adjnode]) {
                    dist[adjnode] = edgewt + dis;
                    q.add(new Tuple(adjnode,dist[adjnode],stop+1));
                }
            }
        }
        if(dist[dest] == 1e9){
            return  -1;
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,100},{1,3,600},{1,2,100},{2,0,100},{2,3,200}};
        Graph graph = new Graph(4,edges,true,true);
        graph.Print_weighted();
        int ans = Cost_flight(4,2,0,3,graph);
        System.out.println(ans);
    }
}
