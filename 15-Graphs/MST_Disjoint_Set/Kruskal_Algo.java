package MST_Disjoint_Set;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal_Algo {
    static void Kruskal(int n, ArrayList<Edges> adjList){
        ArrayList<Edges> mstEdges = new ArrayList<>();
        int sum = 0;
        //sorting the edges.
        Collections.sort(adjList);
        //Initializing the dynamic graph
        Disjoint_Set ds = new Disjoint_Set(n);
        for(Edges it: adjList){
            int u = it.u;
            int v = it.v;
            int wt = it.weight;
            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u,v);
                //insert the edge that is not the component
                mstEdges.add(it);
                sum += wt;
            }
        }
        for(Edges it:mstEdges){
            System.out.println(it.u+" ---> "+ it.v+" { wt: "+ it.weight+" }");
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,3,6},{1,2,3},{1,4,5},{1,3,8},{2,4,7}};
        ArrayList<Edges> adjList = new ArrayList<>();
        for(int[] it:edges){
            adjList.add(new Edges(it[0],it[1],it[2]));
        }
        Kruskal(5,adjList);
    }
}
