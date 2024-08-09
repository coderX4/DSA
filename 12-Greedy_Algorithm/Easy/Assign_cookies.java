package Easy;

import java.util.Arrays;

public class Assign_cookies {
    static int Greedy1(int[] greed,int[] size){
        int n = greed.length, m  = size.length;
        int l = 0, r = 0;

        Arrays.sort(greed);
        Arrays.sort(size);

        while( l < m && r < n){
            if(size[l] >= greed[r]){
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] greed = {1,5,3,3,4};
        int[] size = {4,2,1,2,1,3};

        System.out.println("Result: "+Greedy1(greed,size));
    }
}
