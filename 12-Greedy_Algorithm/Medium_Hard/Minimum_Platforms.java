package Medium_Hard;

import java.util.Arrays;

public class Minimum_Platforms {
    static int Min_Platform(int[] arr,int[] dept){
        int cnt = 0,maxcnt = 0,i = 0, j = 0;
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dept);

        while(i < n){
            if(arr[i] < dept[j]){
                cnt++;
                maxcnt = Math.max(maxcnt,cnt);
                i++;
            }
            else{
                cnt--;
                j++;
            }
        }
        return maxcnt;
    }

    public static void main(String[] args) {
        int[] arr = {900,945,955,1100,1500,1800};
        int[] dept = {920,1200,1130,1150,1900,2000};

        System.out.println("Minimum Platforms: "+Min_Platform(arr,dept));
    }
}
