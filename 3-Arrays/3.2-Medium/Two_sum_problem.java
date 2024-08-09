import java.util.Arrays;
import java.util.HashMap;

public class Two_sum_problem{

    //Better
    public static void twosum(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= arr.length;
        for(int i =0;i<n;i++){
            map.put(arr[i],i);

            int b = target - arr[i];
            if(map.containsKey(b)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }

    //Optimal
    public static String Twosum(int[] arr,int target){
        int n = arr.length;
        int left = 0,right = n-1;
        int sum = 0;

        Arrays.sort(arr);
        while(left<right){
            sum = arr[left] + arr[right];
            if(sum == target){
                return "yes";
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
            sum = 0;
        }
        return "no";
    }
    public static void main(String[] args){
        int[] A = {2,6,5,8,11};
        int target = 14;

        System.out.println(Two_sum_problem.Twosum(A,target));
    }
}