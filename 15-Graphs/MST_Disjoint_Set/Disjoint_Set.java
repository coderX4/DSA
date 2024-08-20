package MST_Disjoint_Set;

import java.util.ArrayList;

public class Disjoint_Set {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    ArrayList<Integer> size = new ArrayList<>();

    Disjoint_Set(int n){
        for(int i = 0;i <= n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v){
            return;
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v,ulp_u);
        }
        else if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
        }
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v){
            return;
        } else if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }

    public static void main(String[] args) {
        Disjoint_Set ds = new Disjoint_Set(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
