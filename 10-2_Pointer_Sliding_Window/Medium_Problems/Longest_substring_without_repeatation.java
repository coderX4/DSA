package Medium_Problems;

import java.util.HashMap;

public class Longest_substring_without_repeatation {

    public static int Max_Len(String inputstr){
        char[] c = inputstr.toCharArray();
        HashMap<Character,Integer> mpp = new HashMap<Character, Integer>();
        int l = 0 , r = 0, maxlen = 0;
        int n = c.length;

        while(r<n){
            if(mpp.containsKey(c[r])){
                l = Math.max(mpp.get(c[r]) + 1 , l);
            }
            mpp.put(c[r],r);
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
    public static void main(String args[]) {
        String str = "cadbzabcd";
        System.out.println("Length : " + Max_Len(str));
    }
}
