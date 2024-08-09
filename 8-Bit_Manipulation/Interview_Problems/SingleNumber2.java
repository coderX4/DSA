package Interview_Problems;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] A = {5,5,5,2,4,4,4};
        int ones = 0, twos = 0;
        for(int i = 0;i < A.length;i++){
            ones = (ones ^ A[i]) & ~(twos);
            twos = (twos ^ A[i]) & ~(ones);
        }
        System.out.println(ones);
    }
}
