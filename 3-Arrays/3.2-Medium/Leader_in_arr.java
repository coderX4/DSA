import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;


public class Leader_in_arr {
    public static ArrayList<Integer> Leaders(int[] arr){
        ArrayList<Integer> leader = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            if(arr[i] > maxi){
                leader.add(arr[i]);
            }
            //keep the track of maximum on right
            maxi = max(maxi,arr[i]);
        }
        //sorting if asked
        Collections.sort(leader);
        return leader;
    }
    public static void main(String[] args) {
        int[] A = {10,22,12,3,0,6};
        System.out.println("sorted" + Leader_in_arr.Leaders(A));
    }
}
