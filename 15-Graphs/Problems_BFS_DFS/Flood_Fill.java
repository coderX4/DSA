package Problems_BFS_DFS;

import java.util.Arrays;

public class Flood_Fill {
    static void DFS(int row,int col,int[][] ans,int[][] grid,int[] delrow,int[] delcol,int inicolor,int newcolor){
        ans[row][col] = newcolor;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i < 4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && grid[nrow][ncol] == inicolor && ans[nrow][ncol] != newcolor)
            {
                DFS(nrow,ncol,ans,grid,delrow,delcol,inicolor,newcolor);
            }
        }
    }
    static int[][] Flood(int[][] grid,int sr,int sc,int newcolor){
        int inicolor = grid[sr][sc];
        int[][] ans = grid;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        DFS(sr,sc,ans,grid,delrow,delcol,inicolor,newcolor);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{2,2,0},{2,2,2}};

        int[][] ans = Flood(grid,2,0,3);

        for(int i = 0 ;i< grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        for(int i = 0 ;i< grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
