import java.util.Arrays;

public class Recursivesorting {

    //Recursive Bubble sort
    public  static void recursiveBubble(int[] arr,int n){
        if(n==1){ return ;}
        int didswap = 0;
        for (int i=0;i<n-1;i++) {
            if (arr[i] > arr[i+1]){
                // swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                didswap = 1;
            }
        }
        if(didswap==0){
            return;
        }
        if (n > 1) {
            Recursivesorting.recursiveBubble(arr,n - 1);
        }
    }
    
    //Recursive Selection sort
    public static void main(String[] args){
        int[] arr ={9,8,7,6,5,4,3};
        System.out.println("Given Array: "+Arrays.toString(arr));
        Recursivesorting.recursiveBubble(arr,arr.length);
        System.out.println("Sorted array is: " + Arrays.toString(arr));
    }
}
