package Shortest_Path_Algo_and_Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Cell{
    int row;
    int col;
    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Pair{
    Cell cell;
    int dis;
    Pair(Cell cell,int dis){
        this.cell = cell;
        this.dis = dis;
    }
}

public class Shortest_dist_Binary_maze {
    static int Shortest_dist(Cell src,Cell dest ,int[][] grid){
        Queue<Pair> qu = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                vis[i][j] = (int)1e9;
            }
        }
        qu.offer(new Pair(src,0));
        vis[src.row][src.col] = 0;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!qu.isEmpty()){
            Pair curr = qu.poll();
            int row = curr.cell.row;
            int col = curr.cell.col;
            int dis = curr.dis;

            for(int i = 0;i < 4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    dis + 1 < vis[nrow][ncol] && grid[nrow][ncol] == 1){

                    vis[nrow][ncol] = dis +1;

                    if(nrow == dest.row && ncol == dest.col){
                        return dis + 1;
                    }
                    qu.offer(new Pair(new Cell(nrow,ncol),dis+1));
                }
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
        {1, 1, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {1, 0, 0, 1}
        };

        int[][] grid2 = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1}};
        Cell src = new Cell(0,0);
        Cell dest = new Cell(3,4);

        int ans ;

        if(grid2[dest.row][dest.col] == 0){
            ans = -1;
        }
        else{
            ans = Shortest_dist(src,dest,grid2);
        }

        System.out.println(ans);
    }
}
