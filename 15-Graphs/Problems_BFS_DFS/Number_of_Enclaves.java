package Problems_BFS_DFS;

public class Number_of_Enclaves {
    static  void DFS(int row,int col,int[][] vis,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                DFS(nrow,ncol,vis,grid);
            }
        }
    }

    static int Num_Enclave(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int j = 0; j < m; j++){
            //first row
            if(vis[0][j] == 0 && grid[0][j] == 1){
                DFS(0,j,vis,grid);
            }
            //last  row
            if(vis[0][j] == 0 && grid[0][j] == 1){
                DFS(n-1,j,vis,grid);
            }
        }

        for(int i = 0; i < n; i++){
            //first row
            if(vis[i][0] == 0 && grid[i][0] == 1){
                DFS(i,0,vis,grid);
            }
            //last  row
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1){
                DFS(i,m-1,vis,grid);
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,1,1},
                {0,0,1,1,0},
                {0,1,0,0,0},
                {0,1,1,0,0},
                {0,0,0,1,1}
        };

        int ans = Num_Enclave(grid);
        System.out.println("Number Of Enclave: "+ans);
    }
}
