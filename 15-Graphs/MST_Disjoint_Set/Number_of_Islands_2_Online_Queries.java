package MST_Disjoint_Set;

import java.util.ArrayList;

public class Number_of_Islands_2_Online_Queries {

    static ArrayList<Integer> Number_queries(int n,int m,int[][] queries){
        int[][] vis = new int[n][m];
        ArrayList<Integer> ans = new ArrayList<>();
        Disjoint_Set ds = new Disjoint_Set(n*m);
        int cnt = 0;
        for(int i = 0;i < queries.length;i++){
            int row = queries[i][0];
            int col = queries[i][1];
            if(vis[row][col] == 1){
                continue;
            }
            vis[row][col] = 1;
            cnt++;

            int[] delrow = {-1,0,1,0};
            int[] delcol = {0,1,0,-1};
            for(int j = 0;j < 4;j++){
                int nrow = row + delrow[j];
                int ncol = col + delcol[j];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 1) {
                    int node = row * m + col;
                    int adjnode = nrow * m + ncol;
                    if(ds.findUPar(node) != ds.findUPar(adjnode)){
                        cnt--;
                        ds.unionBySize(node,adjnode);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        ArrayList<Integer> ans = Number_queries(n,m,operators);
        System.out.println(ans);
    }
}
