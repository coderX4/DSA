package Medium_Hard;

public class Valid_Paraenthesis {
    static boolean Valid(char[] arr,int n){
        int mini = 0, maxi = 0;

        for(int i = 0;i < n;i++){
            if(arr[i] == '('){
                mini = mini + 1;
                maxi = maxi + 1;
            }
            else if(arr[i] == ')'){
                mini = mini - 1;
                maxi = maxi - 1;
            }
            else{
                mini = mini - 1;
                maxi = maxi + 1;
            }
            if(mini < 0 ){
                mini = 0;
            }
            if(maxi < 0 ){
                return false;
            }
        }
        if(mini == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(*)((*))(()";
        char[] arr = s.toCharArray();
        boolean res = Valid(arr, arr.length);
        if(res){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }
}
