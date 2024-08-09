package Medium_Problems;

import java.util.HashMap;

public class Number_of_substring_with_all_3_chars {
    static int Number_of_Substring(char[] arr){
        int[] lastseen = {-1,-1,-1};
        int cnt = 0;

        for(int i = 0;i< arr.length;i++){
            lastseen[arr[i] - 'a'] = i;
            if((lastseen[0] != -1) && (lastseen[1] != -1) && (lastseen[2] != -1)){
                cnt = cnt + (1 + Math.min(lastseen[0], Math.min(lastseen[1],lastseen[2] )));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str = "bbacba";
        char[] c = str.toCharArray();
        System.out.println("Length : " + Number_of_Substring(c));
    }
}
