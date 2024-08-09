package Bs_on_1D;

public class No_of_times_Array_ {

    public static void main(String[] args) {
        int[] A = {7,8,9,1,2,3,4,5,6};
        System.out.println("Ans : " + Minimum_index(A));
    }
    public static int Minimum_index(int[] a) {
        int low  = 0 , high  = a.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[low] <= a[mid]){
                if(ans > a[low]){
                    ans = a[low];
                    index = low;
                }
                low = mid +1;
            }
            else{
                high = mid - 1;
                if(ans > a[mid]){
                    ans = a[mid];
                    index = mid;
                }
            }
        }
        return index;
    }
}
