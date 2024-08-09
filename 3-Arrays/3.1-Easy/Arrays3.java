import java.util.HashMap;
import java.util.*;
public class Arrays3 {
    //Missing number in array
    //using sum of n natural nuymbers
    public static int  missingNumber(int[] arr,int n) {
        int sum = (n*(n+1)) / 2;
        int s1 = 0;
        for(int i = 0;i<arr.length;i++){
            s1 += arr[i];
        }
        return sum - s1;
    }

    //using xor
    public static int missing_XOR(int []a, int N) {
        // Write your code here.
        int xor1 = 0;
        int xor2 = 0;
        for(int i =0;i<N-1;i++){
            xor1 = xor1 ^ (i+1);
            xor2 = xor2 ^ a[i];
        }
        xor1 = xor1 ^ N;
        return xor1 ^ xor2;

    }

    //maximum consecutive ones
    public static void maxConsecutiveOnes(int[] arr){
        int maxi = 0,cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 1){
                cnt++;
                maxi = Math.max(maxi,cnt);
            }
            else{
                cnt = 0;
            }
        }
        System.out.println("Maximum Consecutive Ones : "+maxi);
    }

    // find the number which apperaed once in other twice numbers

     
    //optimal using XOR
    public static void  oncetwice(int[] arr){
        int xor1 = 0;
        for(int i = 0;i < arr.length;i++){
            xor1 = xor1 ^ arr[i];
        }
        System.out.println(xor1);
    }

    //longest subarray with sum k
    public static  int longestsubarraysum(int[] arr,int k){
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxlen = 0;
        int n = arr.length;
        while(right < n){
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxlen = Math.max(maxlen,right-left+1);
            }
            right++;
            if(right<n) {
                sum += arr[right];
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        //int[] A = {1,2,3,4,5,7,8,9,10};
        //int num = Arrays3.missing_XOR(A, 10);
        //System.out.println("The missing number is " + num);

        int[] B = {1,1,2,2,3,3,4,5,5};
        //\][Arrays3.oncetwice(B);
        int result = Arrays3.longestsubarraysum(B,5);
        System.out.println(result);

    }
}
