package MST_Disjoint_Set;

public class Number_of_Provinces {
    static int Provinces(int n,int[][] edges){

        Disjoint_Set ds = new Disjoint_Set(n);
        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u,v);
            }
        }
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(ds.parent.get(i) == i){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6},{7, 8}};

        int ans = Provinces(V,edge);
        System.out.println(ans);
    }
}
