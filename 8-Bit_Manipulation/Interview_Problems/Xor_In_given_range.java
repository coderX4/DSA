package Interview_Problems;

public class Xor_In_given_range {
    public static int Xorr(int n){
        if(n % 4 == 1){
            return 1;
        }
        else if(n % 4 == 2){
            return n+1;
        }
        else if(n % 4 == 3){
            return 0;
        }

        return n; //if(n % 4 == 0)
    }

    public static void main(String[] args) {
        int l = 4, r = 8;
        int result = Xorr(l-1) ^ Xorr(r);
        System.out.println(result);
    }
}
