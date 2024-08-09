package Medium_Hard;

import java.util.Arrays;

public class Shortest_job_first {
    static int SJF(int[] pt){
        Arrays.sort(pt);
        int t = 0,wt = 0;
        for(int i = 0;i < pt.length; i++){
            wt += t;
            t += pt[i];
        }
        return (wt/ pt.length);
    }

    public static void main(String[] args) {
        int[] pt = {4,3,7,1,2};
        System.out.println("Result: "+SJF(pt));
    }
}
