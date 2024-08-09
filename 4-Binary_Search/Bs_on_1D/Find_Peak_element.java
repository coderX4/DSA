package Bs_on_1D;

public class Find_Peak_element {
    public static void main(String[] args) {
        int[] A = {1,2,3,8,4,5,6,7};
        System.out.println("Peak Element: "+Peak_element(A));
    }
    public static int Peak_element(int[] arr) {
        int n = arr.length;
        int low = 1,high = n-2;
        while(low <= high){
            int mid  = (low + high) / 2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return arr[mid];
            }
            //if we are at left
            else if(arr[mid] > arr[mid - 1]){
                low = mid + 1;
            }
            //we are on right
            else {
                high  = mid - 1;
            }
        }
        //edge cases
        if(n==1)
            return 0;
        //at 0 index
        if(arr[0] > arr[1])
            return arr[0];
        //at last index
        if(arr[n-1] > arr[n-2])
            return arr[n-1];
        return -1;
    }
}
