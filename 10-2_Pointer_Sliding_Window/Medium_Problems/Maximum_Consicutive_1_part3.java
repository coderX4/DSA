package Medium_Problems;

public class Maximum_Consicutive_1_part3 {
    static int Max_1_s(int[] arr,int k){
        int maxlen = 0, l = 0, r = 0, zeros = 0;
        int n = arr.length;

        while(r < n){
            if(arr[r] == 0){
                zeros++;
            }
            if(zeros > k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }
            if(zeros <= k){
                maxlen = Math.max(maxlen,(r-l+1));
            }
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println("Lenght: " + Max_1_s(A,2));
    }
}
