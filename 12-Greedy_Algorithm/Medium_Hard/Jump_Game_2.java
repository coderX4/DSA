package Medium_Hard;

public class Jump_Game_2 {
    static int Jump(int[] arr){
        int jump = 0, l = 0, r = 0;
        int n = arr.length;
        while(r < n-1){
            int furthest = 0;
            if(r == 0){
                l = 1;
                r = arr[r];
                jump++;
            }
            for(int i = l; i < r;i++){
                furthest = Math.max(furthest, i + arr[i]);
            }
            l = r + 1;
            r = furthest;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4 };
        System.out.println("Result: " + Jump(arr));
    }
}
