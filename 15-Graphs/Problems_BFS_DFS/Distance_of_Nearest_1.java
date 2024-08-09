package Problems_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_of_Nearest_1 {
    static class Pair{
        int row,col,steps;
        Pair(int row,int col,int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    static int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> qu = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    qu.offer(new Pair(i,j,0));
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }

        while(!qu.isEmpty()){
            int row = qu.peek().row;
            int col = qu.peek().col;
            int steps = qu.peek().steps;
            qu.remove();

            dist[row][col] = steps;
            int[] delrow = {-1,0,1,0};
            int[] delcol = {0,1,0,-1};

            for(int i =0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m
                    && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    qu.offer(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{1,0,1}};
        int[][] dist = nearest(grid);

        for(int i =0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(dist[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
