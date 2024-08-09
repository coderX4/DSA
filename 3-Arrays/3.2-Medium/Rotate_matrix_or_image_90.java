public class Rotate_matrix_or_image_90 {
    public static void main(String[] args) {
        int[][] A = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = 4, m = 4;
        System.out.println("Matrix Before: ");
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(A[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("Matrix After: ");
        A = Rotate_matrix_or_image_90.Rotate(A,n,m);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(A[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    private static int[][] Rotate(int[][] a, int n, int m){
        //Transpose of the matrix
        //Row becomes col and col becomes row
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        //Reverse every row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][n - 1 - j];
                a[i][n - 1 - j] = temp;
            }
        }

        return a;
    }
}
