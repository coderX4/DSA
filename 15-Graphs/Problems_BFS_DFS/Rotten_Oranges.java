package Problems_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    static class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int Time_to_Rote(int[][] grid){
        int n = grid.length;
        int m  = grid[0].length;
        int[][] vis = new int[n][m];

        Queue<Pair> qu = new LinkedList<>();
        int tm = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2){
                    qu.offer(new Pair(i,j,tm));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!qu.isEmpty()){
            int row = qu.peek().row;
            int col = qu.peek().col;
            int t = qu.peek().time;

            tm = Math.max(t,tm);
            qu.remove();
            for(int i = 0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow<n && ncol>=0 && ncol<m &&
                    grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                    vis[nrow][ncol] = 2;
                    qu.offer(new Pair(nrow,ncol,t+1));
                }
            }
        }
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<m;j++){
                if(vis[i][j] != 2 && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return tm;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = Time_to_Rote(grid);
        System.out.println("Min Time to rote: "+ans);
    }
}
