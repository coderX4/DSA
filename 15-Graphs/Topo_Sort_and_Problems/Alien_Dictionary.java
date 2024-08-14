package Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Alien_Dictionary {

    static ArrayList<Integer> Toposort(ArrayList<ArrayList<Integer>> adjList){
        int v = adjList.size();
        int[] indegree = new int[v];
        for(int i = 0;i < adjList.size();i++){
            for(Integer it: adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                qu.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!qu.isEmpty()){
            int node = qu.poll();
            ans.add(node);
            for(Integer it: adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }
        return ans;
    }

    static void Alien_dict(String[] arr,int k){
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0 ;i < arr.length-1 ;i++){
            char[] s1 = arr[i].toCharArray();
            char[] s2 = arr[i+1].toCharArray();

            int len = Math.min(s1.length,s2.length);
            for(int j = 0; j < len;j++){
                if(s1[j] != s2[j]){
                    edges.get(s1[j] - 'a').add(s2[j] - 'a');
                    break;
                }
            }
        }

        ArrayList<Integer> sort = Toposort(edges);

        String ans = "";
        for(int it: sort){
            ans = ans + (char)(it + (int)('a'));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String[] arr = {"baa","abcd","abca","cab","cad","e"};
        //k is number of alphabets
        Alien_dict(arr,5);
    }
}
