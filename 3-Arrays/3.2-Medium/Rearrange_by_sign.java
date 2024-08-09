import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange_by_sign {

    //varient 1 is about no. of pos == no. of neg
    public static int[] varient1(int[] arr){
        int n = arr.length;
        int [] ans = new int[n];
        int posindex = 0,negindex = 1;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                ans[negindex] = arr[i];
                negindex +=2;
            }
            else{
                ans[posindex] = arr[i];
                posindex += 2;
            }
        }
        return ans;
    }
    //varient 2 is about no. of pos != no. of neg
    public static int[] varient2(int[] arr){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                neg.add(arr[i]);
            }
            else{
                pos.add(arr[i]);
            }
        }
        if(pos.size() > neg.size()){
            for(int j = 0;j<neg.size();j++){
                arr[2*j] = pos.get(j);
                arr[2*j +1] = neg.get(j);
            }
            int index = neg.size()*2;
            for(int i =neg.size();i< pos.size();i++){
                arr[index] = pos.get(i);
                index++;
            }
        }
        else{
            for(int j = 0;j<pos.size();j++){
                arr[2*j] = pos.get(j);
                arr[2*j +1] = neg.get(j);
            }
            int index = pos.size()*2;
            for(int i =pos.size();i< neg.size();i++){
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] A = {3,1,-2,-5,2,-4,5,8,-9,8,2,5};
        System.out.println("Rearrenged array: "+ Arrays.toString(Rearrange_by_sign.varient2(A)));
    }
}
