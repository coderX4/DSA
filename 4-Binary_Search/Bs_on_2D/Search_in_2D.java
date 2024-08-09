package Bs_on_2D;

public class Search_in_2D {
    public static boolean Search(int[][] mat,int target){
        int n = mat.length, m = mat[0].length;
        int low = 0, high = (n * m) - 1; //total size in 1d -1 cause start from 0.
        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if(mat[row][col] == target)
                return true;
            else if(mat[row][col] < target)
                low = mid + 1;
            else {
                high = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 5},
                {6, 7, 8},
                {9, 10, 11}
        };

        int target = 23;
        System.out.println("Search result : " + Search(matrix, target));

    }
}
