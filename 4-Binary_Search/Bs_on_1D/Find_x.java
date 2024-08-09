package Bs_on_1D;

public class Find_x {
    public static int Bs_iterative(int[] arr,int target){
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return mid;
            } else if (target> arr[mid]) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int Bs_recursive(int[] arr,int low,int high,int target){
        if(low > high)
            return -1;
        int mid = (low+high)/2;

        if(arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return Bs_recursive(arr,mid+1,high,target);
        }
        return Bs_recursive(arr,low,mid-1,target);
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        System.out.println("Index: " + Find_x.Bs_recursive(A,0,A.length-1,3));

    }
}
