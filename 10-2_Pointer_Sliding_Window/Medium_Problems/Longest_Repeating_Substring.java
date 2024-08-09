package Medium_Problems;

import java.util.HashMap;

public class Longest_Repeating_Substring {
    static int Max_Len_substring(char[] arr,int k){
        int maxlen = 0, l = 0, r = 0, maxfreq = 0;
        int n = arr.length;
        HashMap<Character,Integer> mpp = new HashMap<>();


        while(r < n){
            if(!mpp.containsKey(arr[r])){
                mpp.put(arr[r],1);
            }
            else{
                int a = mpp.get(arr[r]);
                mpp.put(arr[r],a+1);
            }
            maxfreq = Math.max(maxfreq,mpp.get(arr[r]));
            if(((r- l + 1)  -  maxfreq) > k){
                int c = mpp.get(arr[l]);
                mpp.replace(arr[l],c - 1);
                if(mpp.get(arr[l]) == 0){
                    mpp.remove(arr[l]);
                }
                maxfreq = 0;
                for(Character key: mpp.keySet()){
                    maxfreq = Math.max(maxfreq,mpp.get(key));
                }
                l++;
            }
            if(((r- l + 1)  -  maxfreq) <= k){
                maxlen = Math.max(maxlen,(r-l+1));
            }
            r++;
        }
        return maxlen;
    }

    public static void main(String args[]) {
        String str = "AABABBA";
        char[] c = str.toCharArray();
        System.out.println("Length : " + Max_Len_substring(c,2));
    }
}
