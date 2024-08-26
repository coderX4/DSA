package Other_Alorithms;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_Algorithm {

    static void DFS1(int node,int[] vis,Graph graph,Stack<Integer> st){
        vis[node] = 1;
        for(Integer adjnode: graph.adjList.get(node)){
            if(vis[adjnode] == 0 ){
                DFS1(adjnode,vis,graph,st);
            }
        }
        st.push(node);
    }

    static void DFS2(int node,int[] vis,ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> x){
        vis[node] = 1;
        for(Integer adjnode: adjList.get(node)){
            if(vis[adjnode] == 0 ){
                DFS2(adjnode,vis,adjList,x);
            }
        }
        x.add(node);
    }
    static void Kosaraju(int n,int[][] edges){
        Graph graph = new Graph(n,edges,true,false);
        graph.Print();

        //step1: sorting edges.
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];
        for(int i = 0; i < n;i++){
            if(vis[i] == 0){
                DFS1(i,vis,graph,st);
            }
        }

        //Reverse the graph.
        ArrayList<ArrayList<Integer>> revadjlist = new ArrayList<>();
        for(int i = 0;i<n;i++){
            revadjlist.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            vis[i] = 0;
            for(Integer adjnode: graph.adjList.get(i)){
                revadjlist.get(adjnode).add(i);
            }
        }

        //storing of Scc's
        int src = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == 0){
                ArrayList<Integer> x = new ArrayList<>();
                src++;
                DFS2(node,vis,revadjlist,x);
                ans.add(x);
            }
        }

        System.out.println("Number of SCC's : "+src);
        System.out.println("The SCC's are .. ");
        for(ArrayList<Integer> it: ans){
            System.out.println(it);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0},{2,3},{3,4},{4,5},{5,6},{6,4},{4,7},{6,7}};
        Kosaraju(8, edges);
    }
}
