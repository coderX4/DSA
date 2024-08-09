package Problems_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row  = row;
        this.col = col;
    }
}
public class Number_of_Islands {
    static int num_Island(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int row = 0; row<n;row++){
            for(int col = 0;col<m;col++){
                if(vis[row][col] == 0 && grid[row][col] == 1){
                    cnt++;
                    BFS(row,col,grid,vis);
                }
            }
        }
        return cnt;
    }
    static void BFS(int row,int col,int[][] grid,int[][] vis){
        vis[row][col] = 1;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!qu.isEmpty()){
            int ro = qu.peek().row;
            int co = qu.peek().col;
            qu.remove();

            for(int delrow = -1; delrow <= 1;delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = ro + delrow;
                    int ncol = co + delcol;
                    // check if neighbour row and column is valid, and is an unvisited land
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        qu.add(new Pair(nrow, ncol));
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,0},{0,1,0,1}};
        int ans = num_Island(grid);
        System.out.println("Result: "+ans);
    }
}
