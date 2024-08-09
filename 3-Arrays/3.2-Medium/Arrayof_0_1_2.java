import java.util.Arrays;

public class Arrayof_0_1_2 {

    public static int[] swapi(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
    //optimal
    //Dutch national flag algorithm
    public static int[] Dutchflagalgo(int[] arr){
        int n = arr.length;
        int low = 0,mid = 0,high = n-1;
        for(int i = 0;i<n;i++){
            if(arr[mid]==0){
                Arrayof_0_1_2.swapi(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }
            else {
                Arrayof_0_1_2.swapi(arr,mid,high);
                high--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] A = {0,1,1,0,1,2,1,2,0,0,0};
        Arrayof_0_1_2.Dutchflagalgo(A);
        System.out.println("Sorted array:"+ Arrays.toString(A));
    }
}
