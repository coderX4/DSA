package Medium_Problems;

public class Count_Nice_subarrays {
    public static  int count_subarrays(int[] arr,int k){
        int left = 0 ,right = 0,sum = arr[0] ,cnt = 0;
        int n = arr.length;
        while(right < n){
            sum += (arr[right] % 2);
            while(sum > k){
                sum -= (arr[left]  % 2);
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
        int[] A  = {1,5,2,1,1};
        System.out.println("Count: "+ count_subarrays(A,3));
    }

}
