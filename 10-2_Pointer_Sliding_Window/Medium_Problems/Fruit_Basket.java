package Medium_Problems;

import java.util.HashMap;

public class Fruit_Basket {
    //k is number of baskets
    static int Max_Len(int[] arr,int k){
        int maxlen = 0, l = 0, r = 0;
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();

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
    public static void main(String[] args) {
        int[] A = {3,3,3,1,2,1,1,2,3,3,4,1,1,1,1,1,1,1,1};
        System.out.println("Lenght: " + Max_Len(A,2));
    }
}
