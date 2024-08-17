package Shortest_Path_Algo_and_Problem;

import java.util.*;

class NodeWeightPair implements Comparable<NodeWeightPair> {
    int node;
    int weight;

    public NodeWeightPair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    @Override
    public int compareTo(NodeWeightPair other) {
        // Compare based on the weight (ascending order by default)
        return Integer.compare(this.weight, other.weight);
    }
}


public class Djisktras_Algo {

    static int[] Shortest_Path_using_Queue(int n,int src,Graph graph){

        int[] dist = new int[n];
        for(int i = 0;i<n;i++) dist[i] = (int)1e9;
        dist[src] = 0;

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(Graph.Pair it : graph.adjList2.get(node)) {
                if(dist[node] + it.weight < dist[it.node]) {
                    dist[it.node] = it.weight + dist[node];
                    q.add(it.node);
                }
            }
        }

        return dist;
    }
    static int[] Shortest_Path_using_PriorityQueue(int n,int src,Graph graph) {
        PriorityQueue<NodeWeightPair> pq =
                new PriorityQueue<>();

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        pq.add(new NodeWeightPair(src,0));
        dist[src] = 0;

        while(!pq.isEmpty()) {
            NodeWeightPair current = pq.poll();
            int node = current.node;
            int dis = current.weight;
            for(Graph.Pair it : graph.adjList2.get(node)) {
                int adjnode = it.node;
                int edgewt = it.weight;
                if(dis + edgewt < dist[adjnode]) {
                    dist[adjnode] = edgewt + dis;
                    pq.add(new NodeWeightPair(adjnode,dist[adjnode]));
                }
            }
        }

        return dist;
    }

    static int[] Shortest_Path_using_TreeSet(int n, int src, Graph graph) {
        TreeSet<NodeWeightPair> treeSet = new TreeSet<>();

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        treeSet.add(new NodeWeightPair(src, 0));
        dist[src] = 0;

        while (!treeSet.isEmpty()) {
            NodeWeightPair current = treeSet.pollFirst();  // Get the node with the smallest weight
            int node = current.node;
            int dis = current.weight;

            for (Graph.Pair it : graph.adjList2.get(node)) {
                int adjNode = it.node;
                int edgeWeight = it.weight;

                if (dis + edgeWeight < dist[adjNode]) {
                    // Remove the old distance if it exists in the TreeSet
                    treeSet.remove(new NodeWeightPair(adjNode, dist[adjNode]));

                    // Update the distance
                    dist[adjNode] = dis + edgeWeight;

                    // Add the new distance to the TreeSet
                    treeSet.add(new NodeWeightPair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        Graph graph = new Graph(6,edges,false,true);
        graph.Print_weighted();
        int[] ans = Shortest_Path_using_Queue(6,0,graph);
        System.out.println(Arrays.toString(ans));
    }
}
