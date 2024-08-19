package MST_Disjoint_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prims_Algo {
    static void Prims(int n,Graph graph){
        PriorityQueue<Edges> pq = new PriorityQueue<>();
        int[] vis = new int[n];
        int sum = 0;

        Arrays.fill(vis,0);

        ArrayList<Edges> mstEdges = new ArrayList<>();

        pq.offer(new Edges(-1,0,0));
        vis[0] = 1;
        while(!pq.isEmpty()){
            Edges curr = pq.poll();
            int node = curr.v;
            int wt = curr.weight;

            sum += wt;

            for(Graph.Pair it:graph.adjList2.get(node)){
                int adjnode = it.node;
                int edgewt = it.weight;
                if(vis[adjnode] == 0){
                    vis[adjnode] = 1;
                    pq.offer(new Edges(node,adjnode,edgewt));
                    mstEdges.add(new Edges(node,adjnode,edgewt));
                }
            }
        }
        for(Edges it:mstEdges){
            System.out.println(it.u+" ---> "+ it.v+" { wt: "+ it.weight+" }");
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,3,6},{1,2,3},{1,4,5},{1,3,8},{2,4,7}};
        Graph graph = new Graph(5,edges,false,true);
        graph.Print_weighted();

        Prims(5,graph);
    }
}
