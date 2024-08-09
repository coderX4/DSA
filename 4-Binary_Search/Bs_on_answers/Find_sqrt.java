package Bs_on_answers;

public class Find_sqrt {
    public static void main(String[] args) {
        int n = 89;
        System.out.println("Square root of "+n+ " is: "+Sqrt(n));
    }

    public static int Sqrt(int n) {
        int low = 1, high = n;
        int ans = 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid * mid <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
