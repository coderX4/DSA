public class Maximum_Subarray_Sum {
    public static int Kanade_algo(int[] arr){
        int n = arr.length,start = 0,ans_start = -1,ans_end = -1;
        int sum = 0, maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n ;i++){

            if(sum == 0){
                start = i;
            }
            sum = sum + arr[i];
            if(maxi < sum){
                maxi = sum ;
                ans_start = start;
                ans_end = i;
            }
            if(sum < 0){
                sum = 0;
            }
        }

        for(int j=ans_start;j<=ans_end;j++){
            System.out.print(arr[j]+" ");
        }
        return maxi;
    }
    
    public static void main(String[] args) {
        int[] A = {-2,-3,4,-1,-2,1,5,-3};
        int Result = Maximum_Subarray_Sum.Kanade_algo(A);
        System.out.println("The sum is: " + Result);
    }
}
