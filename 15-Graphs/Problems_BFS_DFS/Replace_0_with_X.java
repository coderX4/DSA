package Problems_BFS_DFS;

public class Replace_0_with_X {
    static  void DFS(int row,int col,int[][] vis,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '0'){
                DFS(nrow,ncol,vis,grid);
            }
        }
    }

    static char[][] Replace(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int j = 0; j < m; j++){
            //first row
            if(vis[0][j] == 0 && grid[0][j] == '0'){
                DFS(0,j,vis,grid);
            }
            //last  row
            if(vis[0][j] == 0 && grid[0][j] == '0'){
                DFS(n-1,j,vis,grid);
            }
        }

        for(int i = 0; i < n; i++){
            //first row
            if(vis[i][0] == 0 && grid[i][0] == '0'){
                DFS(i,0,vis,grid);
            }
            //last  row
            if(vis[i][m-1] == 0 && grid[i][m-1] == '0'){
                DFS(i,m-1,vis,grid);
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0){
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        char[][] grid = {{'X','X','X','X','X'},
                         {'X','0','0','X','0'},
                         {'X','X','0','X','0'},
                         {'X','0','X','0','X'},
                         {'0','0','X','X','X'}};

        Replace(grid);

        for(int i =0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
