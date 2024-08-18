package Shortest_Path_Algo_and_Problem;

import java.util.Arrays;

public class Floyd_Warshall_Algo {
    static int[][] Floyd_Warshall(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == -1){
                    grid[i][j] = (int)1e9;
                }
            }
        }

        for(int via = 0;via < n;via++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    grid[i][j] = Math.min(grid[i][j],
                            grid[i][via] + grid[via][j]);
                }
            }
        }
        //for negative cycle
        for(int i = 0;i < n;i++){
            if(grid[i][i] < 0){
                int[][] temp = new int[1][1];
                temp[0][1] = -1;
                return temp;
            }
        }

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1e9){
                    grid[i][j] = -1;
                }
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0},
        };

        for (int[] i : grid) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("After Result: ");
        grid = Floyd_Warshall(grid);

        for (int[] i : grid) {
            System.out.println(Arrays.toString(i));
        }

    }
}
