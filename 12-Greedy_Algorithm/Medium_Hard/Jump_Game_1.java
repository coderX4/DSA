package Medium_Hard;

public class Jump_Game_1 {
    static boolean Jump(int[] arr){
        int n = arr.length;
        int maxtotal = 0;
        for(int i = 0;i < n;i++){
            if(i > maxtotal){
                return false;
            }
            maxtotal = Math.max(maxtotal,(i+arr[i]));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,1,1,0,2,5};
        System.out.println("Result: "+ Jump(arr));
    }
}
