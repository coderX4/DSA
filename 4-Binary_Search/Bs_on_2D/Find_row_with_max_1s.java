package Bs_on_2D;

public class Find_row_with_max_1s {
    public static int LowerBound(int[] A,int m,int x){
        int low = 0,high = m-1;
        int ans = A.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A[mid] >= x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int find_max_1_in_rows(int[][] arr,int n,int m){
        int cnt_max = 0;
        int indx = -1;
        for(int i = 0;i<n;i++){
            int cnt_ones = m - LowerBound(arr[i],m,1);
            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                indx = i;
            }
        }
        return indx;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " + find_max_1_in_rows(matrix, n, m));

    }
}
