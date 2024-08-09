package Bs_on_1D;

public class Search_Rotated_Array {
    public static void main(String[] args) {
        int[] A = {7,7,8,9,1,2,3,4,5,6,7};
        int x = 7;
        System.out.println("Index of "+x+" : "+Search_Rotated_2(A,x));
    }

    public static int Search_Rotated_1(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            //if(left part is sorted)
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //else(right part is sorted
            else {
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int Search_Rotated_2(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            //condition for duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low +1;
                high = high -1;
                continue;
            }

            //if(left part is sorted)
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //else(right part is sorted
            else {
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
