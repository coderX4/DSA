package Interview_Problems;

public class Minimum_bits_flips_to_convert_a_to_b {
    public static void main(String[] args) {
        int start = 10, goal = 7;
        int n = start ^ goal;
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        System.out.println("Numbers os flips are: "+cnt);

    }
}
