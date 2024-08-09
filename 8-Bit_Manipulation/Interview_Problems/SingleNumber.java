package Interview_Problems;

public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {4,1,2,1,2};
        int x = 0;
        for(int i = 0;i < A.length; i++){
            x = x ^ A[i];
        }
        System.out.println(x);
    }
}
