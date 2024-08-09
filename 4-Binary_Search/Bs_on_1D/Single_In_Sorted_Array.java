package Bs_on_1D;

public class Single_In_Sorted_Array {
    public static void main(String[] args) {
        int[] A = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println("Single Element: "+ Single_element(A));
    }

    public static int Single_element(int[] arr) {
        int n = arr.length;
        //Edge case
        //only 1 element is there
        if(n == 1)
            return arr[0];
        //at 0 index
        if(arr[0] != arr[1])
            return arr[0];
        //at last index
        if(arr[n-1] != arr[n-2])
            return arr[n-1];

        int low = 1,high = n-2;
        while(low <= high){
            int mid  = (low + high) / 2;
            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }
            //if we are at left
            if(mid % 2 == 1 && arr[mid] == arr[mid - 1]
                    || mid % 2 == 0 && arr[mid] == arr[mid + 1]){
                low = mid +1;
            }
            //we are on right
            else{
                high  = mid -1;
            }
        }
        return -1;
    }
}
