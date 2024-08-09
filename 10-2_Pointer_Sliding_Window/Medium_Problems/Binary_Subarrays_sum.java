package Medium_Problems;

public class Binary_Subarrays_sum {

    public static  int count_subarrays(int[] arr,int k){
        int left = 0 ,right = 0,sum = arr[0] ,cnt = 0;
        int n = arr.length;
        while(right < n){
            sum += arr[right];
            while(sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                cnt++;
            }
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A  = {1,0,0,1,0,0,1};
        System.out.println("Count: "+ count_subarrays(A,2));
    }

}
