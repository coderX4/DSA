package Bs_on_1D;

import java.util.ArrayList;
import java.util.Arrays;

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] A = {1,2,3,3,5,6,8,8,10,11};
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: A){
            arr.add(i);
        }
        int low = 0,high = A.length-1;
        int ans = A.length-1;
        int insert_ele = 7;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A[mid] >= insert_ele){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        arr.add(ans,insert_ele);
        System.out.println("Array: " + arr);
    }
}
