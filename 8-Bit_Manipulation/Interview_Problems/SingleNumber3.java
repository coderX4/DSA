package Interview_Problems;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] A = {2,4,2,6,3,7,7,3};
        int b1 = 0, b2 = 0;
        int  xorr = 0;
        for(int i = 0;i < A.length;i++){
            xorr = xorr ^ A[i];
        }
        int rightmost = (xorr & (xorr - 1)) ^ xorr;
        for(int i = 0;i < A.length;i++){
            if((A[i] & rightmost) != 0){
                b1 = b1 ^ A[i];
            }
            else{
                b2 = b2 ^ A[i];
            }
        }
        System.out.println(b1+" , "+b2);
    }
}
