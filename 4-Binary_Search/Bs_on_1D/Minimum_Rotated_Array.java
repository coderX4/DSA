package Bs_on_1D;

public class Minimum_Rotated_Array {
    public static void main(String[] args) {
        int[] A = {7,8,9,1,2,3,4,5,6};
        System.out.println("Minimum is: " + Minimum(A));
    }

    public static int Minimum(int[] a) {
        int low  = 0 , high  = a.length - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;
            if(a[low] <= a[mid]){
                if(ans > a[low]){
                    ans = a[low];
                }
                low = mid +1;
            }
            else{
                high = mid - 1;
                if(ans > a[mid]){
                    ans = a[mid];
                }
            }
        }
        return ans;
    }
}
