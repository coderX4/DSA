package Medium_Problems;

public class Maximum_Points_From_Card {
    public static int Max_sum_cards(int[] arr,int k){
        int maxsum = 0, lsum = 0, rsum = 0;
        int rindex = arr.length - 1;

        for(int i = 0; i <= k-1; i++){
            lsum = lsum + arr[i];
        }
        maxsum = lsum;

        for(int i = k-1; i >= 0 ; i--){
            lsum = lsum - arr[i];
            rsum = rsum + arr[rindex];
            rindex = rindex - 1;
            maxsum = Math.max(maxsum,(lsum + rsum));
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        int e = Max_sum_cards(arr,k);
        System.out.println("Max Sum obtained: "+e);
    }
}
