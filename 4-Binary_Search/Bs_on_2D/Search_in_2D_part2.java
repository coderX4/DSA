package Bs_on_2D;

import java.util.Arrays;

public class Search_in_2D_part2 {

    public static int[] Search_2(int[][] mat,int target){
        int n = mat.length, m = mat[0].length;
        int row = 0, col = m-1;
        int ans[] = {-1,-1};
        while(row < n && col >= 0){
            if(mat[row][col] == target){
                ans[0] = row;
                ans[1] = col;
                return ans;
            }
            else if(mat[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7,11,15},
                {2, 5, 8,12,19},
                {3, 6, 9,16, 22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        int target = 23;
        System.out.println("Search result : " + Arrays.toString(Search_2(matrix, target)));

    }
}
