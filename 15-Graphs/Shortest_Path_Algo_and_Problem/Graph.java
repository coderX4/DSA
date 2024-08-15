package Shortest_Path_Algo_and_Problem;

import java.util.ArrayList;

public class Graph {
    static class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    static  int n;
    ArrayList<ArrayList<Pair>> adjList2 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[][] edges ;
    boolean weighted = false;
    boolean directed = false;

    Graph(int n,int[][] edges,boolean directed,boolean weighted){
        this.n = n;
        this.edges  = edges;
        this.directed = directed;
        this.weighted = weighted;

        if(weighted){
            for(int i = 0; i < n ; i++){
                adjList2.add(new ArrayList<>());
            }
            Convert_weighted(directed);
        }
        else{
            for(int i = 0; i < n ; i++){
                adjList.add(new ArrayList<>());
            }
            Convert(directed);
        }

    }

    void PutEdge(int i,int a,int b){
        adjList.get(edges[i][a]).add(edges[i][b]);
    }

    void PutEdge_weighted(int i,int a,int b,int c){
        adjList2.get(edges[i][a]).add(new Pair(edges[i][b],edges[i][c]));
    }

    void Convert(boolean directed){
        if(directed){
            for(int i = 0;i < edges.length;i++){
                PutEdge(i,0,1);
            }
        }
        else{
            for(int i = 0;i < edges.length;i++){
                PutEdge(i,0,1);
                PutEdge(i,1,0);
            }
        }
    }
    void Convert_weighted(boolean directed){
        if(directed){
            for(int i = 0;i < edges.length;i++){
                PutEdge_weighted(i,0,1,2);
            }
        }
        else{
            for(int i = 0;i < edges.length;i++){
                PutEdge_weighted(i,0,1,2);
                PutEdge_weighted(i,1,0,2);
            }
        }
    }

    void Print_weighted(){
        for(int i = 0;i < adjList2.size();i++){
            System.out.print(i + " --> ");
            for(Pair it: adjList2.get(i)){
                System.out.print("{"+it.node+","+it.weight+"} ");
            }
            System.out.println();
        }
    }

     void Print(){
        for(int i = 0;i < adjList.size();i++){
            System.out.print(i + " --> ");
            System.out.println(adjList.get(i));
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,1},{1,2,1},{2,3,5},{1,3,8}};
        int[][] edges1 = {{1,2},{2,3},{1,3}};
        Graph graph1 = new Graph(4,edges,false,true);
        Graph graph = new Graph(4,edges1,false,false);
        graph.Print();
        graph1.Print_weighted();
    }
}
