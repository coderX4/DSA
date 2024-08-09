import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
    public static int majority_ele(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length, cnt =0,d=0;
        for(int i= 0;i<n;i++){
            map.put(arr[i],cnt++);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue() > n/2){
                d = e.getKey();
            }
        }
        return d;
    }

    //optimal
    //Moore's voting algo
    public static int Moore_voting_algo(int[] arr){
        int n = arr.length;;
        int cnt = 0, cnt1=0, el=0,d=-1;
        //finding majority element
        for (int k : arr) {
            if (cnt == 0) {
                cnt = 1;
                el = k;
            } else if (k == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        //Then counting the element
        for (int j : arr) {
            if (j == el) {
                cnt1++;
            }
        }
        if(cnt1 > (n/2)){
            d=el;
        }
        return d;
    }
    public static void main(String[] args) {
        int[] A = {2,2,3,3,2,3,3,3,3,2,2};
        //System.out.println(Majority_Element.majority_ele(A));
        System.out.println(Majority_Element.Moore_voting_algo(A));
    }
}
