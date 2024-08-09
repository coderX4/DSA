package Bs_on_1D;

public class Lower_Bound {
    public static void main(String[] args) {
        int[] A = {1,2,3,3,5,6,8,8,10,11};
        int low = 0,high = A.length-1;
        int ans = A.length-1;
        int x = 9;
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
        System.out.println("Lower Bound: " + ans);
    }
}
