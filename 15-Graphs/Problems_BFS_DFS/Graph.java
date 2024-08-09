package Problems_BFS_DFS;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {

    HashMap<T,ArrayList<T>> map = new HashMap<>();
    T firstnode;
    boolean bidirected = false;
    T[][] edges;
    public Graph(T[][] edges, boolean bidirected){
        this.edges = edges;
        this.bidirected = bidirected;

        Convert(bidirected);
    }


    void Convert(boolean bidirected){
        if(bidirected == false){
            for(int i = 0; i < edges.length;i++){
                if(!map.containsKey(edges[i][0])){
                    map.put(edges[i][0],new ArrayList<T>());
                    map.get(edges[i][0]).add(edges[i][1]);
                }
                else{
                    map.get(edges[i][0]).add(edges[i][1]);
                }
            }
        }
        else{

            //for bi directed graphn
            for(int i = 0; i < edges.length;i++){
                if(!map.containsKey(edges[i][0])){
                    map.put(edges[i][0],new ArrayList<T>());
                    map.get(edges[i][0]).add(edges[i][1]);

                    if (!map.containsKey(edges[i][1])) {
                        map.put(edges[i][1],new ArrayList<T>());
                        map.get(edges[i][1]).add(edges[i][0]);
                    }
                    else{
                        map.get(edges[i][1]).add(edges[i][0]);
                    }
                }
                else{
                    map.get(edges[i][0]).add(edges[i][1]);

                    if (!map.containsKey(edges[i][1])) {
                        map.put(edges[i][1],new ArrayList<T>());
                        map.get(edges[i][1]).add(edges[i][0]);
                    }
                    else{
                        map.get(edges[i][1]).add(edges[i][0]);
                    }
                }
            }
        }

    }

    void Print(){
        for(T key: map.keySet()){
            System.out.print(key + " --> ");
            System.out.println(map.get(key));
        }
    }

    public static void main(String[] args) {
        Integer[][] edges = {{1,2},{2,3},{1,3}};
        String[][] stredges  = {{"A","B"}};
        int n = 3;
        int m = 6;
        Graph<Integer> graph1 = new Graph<Integer>(edges,true);
        Graph<String> graph2 = new Graph<String>(stredges,true);

        graph1.Print();
        System.out.println();
        graph2.Print();

    }
}
