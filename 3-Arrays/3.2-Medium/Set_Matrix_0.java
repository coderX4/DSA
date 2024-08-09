public class Set_Matrix_0 {
    //Better Solution that uses extra space
    //row r[] and column c[]
    //TC  = O(2 X n X m)
    //SC = O(n+m) extra space for the row and column
    private static int[][] Setmatrix1(int[][] a,int n,int m) {
        int[] r = new int[n];
        int[] c = new int[m];

        for(int i = 0; i<n ;i++){
            for(int j = 0; j<m;j++){
                if(a[i][j] == 0){
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        for(int i = 0; i<n ;i++){
            for(int j = 0; j<m;j++){
                if(r[i] == 1 || c[j] == 1){
                    a[i][j] = 0;
                }
            }
        }
        return a;
    }

    //Optimal Solution
    //TC = O(2 X n X m)
    //SC = O(1) no extra space will be used
    //That is inplace transformation
    private static int[][] Setmatrix2(int[][] a,int n,int m) {

        for(int i = 0; i<n ;i++){
            for(int j = 0; j<m;j++){
                if(a[i][j] == 0){
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        for(int i = 1; i<n ;i++){
            for(int j = 1; j<m;j++){
                if(a[i][0] == 0 || a[0][j] == 0){
                    a[i][j] = 0;
                }
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int[][] A = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};
        int n = 4, m = 4;
        System.out.println("Matrix Before: ");
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(A[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println("Matrix After: ");
        A = Set_Matrix_0.Setmatrix2(A,n,m);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(A[i][j]+" | ");
            }
            System.out.println();
        }
    }
}
