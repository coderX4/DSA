package Medium_Hard;

public class Candy {
    static int Min_Candy_Slope(int[] rating){
        int n = rating.length,sum = 1, i = 1;

        while(i < n){
            if(rating[i] == rating[i-1]){
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while(i < n && rating[i] > rating[i-1]){
                peak++;
                sum += peak;
                i++;
            }

            int down = 1;
            while(i < n && rating[i] < rating[i-1]){
                sum += down;
                peak++;
                i++;
            }
            if(down > peak){
                sum += down - peak;
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        //int[] rating = {0,2,4,7,6,5,4,3,2,1,1,1,2,3,4,2,1,1,1};
        //int[] a = {0,2,4,3,2,1,1,3,5,6,4,0,0};
        int[] a1 = {4,6,4,5,6,2};
        System.out.println("Result: "+ Min_Candy_Slope(a1));
    }
}
