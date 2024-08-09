package Medium_Problems;

import java.util.HashMap;

public class Longest_substring_with_k_distinct_char {
    static int Max_Len(char[] arr,int k){
        int maxlen = 0, l = 0, r = 0;
        int n = arr.length;
        HashMap<Character,Integer> mpp = new HashMap<>();

        while(r < n){
            if(! mpp.containsKey(arr[r])){
                mpp.put(arr[r],1);
            }
            else{
                int a = mpp.get(arr[r]);
                mpp.put(arr[r],a+1);
            }
            if(mpp.size() > k){
                int c = mpp.get(arr[l]);
                mpp.replace(arr[l],c - 1);
                if(mpp.get(arr[l]) == 0){
                    mpp.remove(arr[l]);
                }
                l++;
            }
            if(mpp.size() <= k){
                maxlen = Math.max(maxlen,(r-l+1));
            }
            r++;
        }
        return maxlen;
    }

    public static void main(String args[]) {
        String str = "aabbcccddd";
        char[] c = str.toCharArray();
        System.out.println("Length : " + Max_Len(c,2));
    }
}
