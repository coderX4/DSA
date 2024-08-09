package Interview_Problems;

import java.util.ArrayList;

public class Power_Set {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int subset = 1 << A.length;
        for(int K = 0;K < subset;K++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i < A.length ; i++){
                if((K & (1 << i))!=0){
                    list.add(A[i]);
                }
            }
            ans.add(list);
        }

        System.out.println(ans);
    }
}
