package Problems_BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;

public class Number_of_Distinct_islands {

    static void DFS(int row, int col, int[][] grid, int[][] vis, ArrayList<String> vec, int row0, int col0){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        vec.add(toString(row-row0,col-col0));

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                DFS(nrow,ncol,vis,grid,vec,row0,col0);
            }
        }
    }

    private static String toString(int r, int c) {
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    static int Num_Distinct(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> st = new HashSet<>();

        int[][] vis = new int[n][m];

        for(int row = 0; row<n;row++){
            for(int col = 0;col<m;col++){
                if(vis[row][col] == 0 && grid[row][col] == 1){
                    ArrayList<String> vec =  new ArrayList<>();
                    DFS(row,col,grid,vis,vec,row,col);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0},
                {1,0,0,0},
                {0,0,1,1},
                {0,0,1,0}};
        int ans = Num_Distinct(grid);
        System.out.println("Result: "+ans);
    }
}
