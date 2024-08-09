package Bs_on_1D;

import java.util.Arrays;

public class First_and_Last_Occurrences {
    public static int Lower(int[] arr,int x){
        int low = 0,high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                ans = mid;
                high  = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static  int Upper(int[] arr,int x){
        int low = 0,high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans-1; //one less so that it gives last occurence
    }
    //count number of occurrences
    public static  int Count_occurrences(int first,int last){
        int res = last - first + 1;
        return res;
    }

    //Method 2: to use plain bs.
    public static int First_occurence(int[] arr, int x){
        int low = 0,high = arr.length-1;
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == x){
                first = mid;
                high  = mid - 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return first;
    }

    public static int Last_occurence(int[] arr, int x){
        int low = 0,high = arr.length-1;
        int last = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == x){
                last = mid;
                low  = mid + 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,3,5,6,8,8,10,11};
        int x = 8;
        int lb = First_occurence(A,x);
        int ub = Last_occurence(A,x);
        int[] B = {0,0};
        if(lb == A.length || A[lb] != x){
            B[0] = -1;
            B[1] = -1;
        }
        else{
            B[0] = lb;
            B[1] = ub;
        }
        System.out.println("First and Last occurrences: "+ Arrays.toString(B));

        //Count number of occurrences
        int cnt = Count_occurrences(lb,ub);
        System.out.println("Count: " + cnt);
    }
}
