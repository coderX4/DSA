import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Longest_consecutive_sequence {
    //Better Solution
    public static int  Longest_sequence(int[] arr){
        Arrays.sort(arr);
        int longest  = 1, lastsmall = Integer.MIN_VALUE , cntcurr = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] -1 == lastsmall){
                cntcurr += 1;
                lastsmall = arr[i];
            }
            else if(arr[i] != lastsmall){
                cntcurr = 1;
                lastsmall = arr[i];
            }
            longest = Math.max(longest,cntcurr);
        }
        return  longest;
    }

    //optimal Solution
    public static int Longest_Sequence_2(int[] arr){
        int n = arr.length;
        if (n == 0)
            return 0;
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< n; i++){
            set.add(arr[i]);
        }
        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
         int[] A = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};
        System.out.println("Lenght: "+Longest_consecutive_sequence.Longest_Sequence_2(A));
    }
}
