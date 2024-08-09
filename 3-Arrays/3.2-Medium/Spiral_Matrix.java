import java.util.ArrayList;

public class Spiral_Matrix {
    private static ArrayList<Integer> Spiral(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int left = 0 , right = n-1;
        int top = 0, bottom = n-1;
        ArrayList<Integer> ans = new ArrayList<>();

        while(left <= right && top <= bottom){
            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(a[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(a[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(a[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(a[i][left]);

                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                     {5, 6, 7, 8},
                     {9, 10, 11, 12},
                     {13, 14, 15, 16}};

        ArrayList<Integer> res = new ArrayList<>();
        res = Spiral_Matrix.Spiral(A);
        System.out.println(res);
    }
}
