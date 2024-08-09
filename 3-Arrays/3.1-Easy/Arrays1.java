public class Arrays1{
    
    //Largest element in an array
    public static int Largestinarr(int[] arr){
        int largest = arr[0];
        for (int i=1;i<arr.length;i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }
        return largest;
    }

    //Second largest element in array
    public static int Second_Largest(int [] arr) {
        int largest = arr[0];
        int second = -1;
        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                second = largest;
                largest = arr[i];
            }
            else if (second < arr[i] && arr[i] != largest) {
                second = arr[i];
            }
        }
        return second;
    }

    //Second smallest
    public static int Second_small(int [] arr) {
        int small = arr[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (small > arr[i]) {
                second = small;
                small = arr[i];
            }
            else if (second > arr[i] && arr[i] != small) {
                second = arr[i];
            }
        }
        return second;
    }

    //Check if array is sorted or not
    public static int checkSorted(int[] arr){
        for(int i = 1;i< arr.length;i++){
            if(arr[i] < arr[i-1]){
                return 0;
            }
        }
        return 1;
    }

    //Remove duplicates from in place sorted array
    public static int removeDuplicates(int[] arr){
        int n = arr.length;
        if (n == 0 || n == 1)
            return n;
 
        int[] temp = new int[n];
 
        // Start traversing elements
        int j = 0;
        for (int i = 0; i < n - 1; i++)
             
            // If current element is not equal to next
            // element then store that current element
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];
 
        // Store the last element as whether it is unique or
        // repeated, it hasn't stored previously
        temp[j++] = arr[n - 1];
 
        // Modify original array
        for (int i = 0; i < j; i++)
            arr[i] = temp[i];
 
        return j;
    }

    public static void main(String[] args){
        int [] arr1 = {1,2,3,4,4,6};
        int res = Arrays1.removeDuplicates(arr1);
        //System.out.println("The largest element in the array is : "+result);
 
        for(int i = 0;i< res;i++){
            System.out.print(arr1[i]+" ");
        }
    }
}