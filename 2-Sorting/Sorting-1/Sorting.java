public class Sorting{
    public static int[] Selectionsort(int[] arr){
        int n = arr.length;
        for(int i = 0;i <= n-2;i++){
            int min = i; //minimum element index is always the first one
            for(int j =i; j <= n-1;j++){
                //if we found a smaller element,
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //swap the minimum element with the first element of unsorted part.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static int[] Bubblesort(int[] arr){
        int n = arr.length;
        int didswap = 0;
        for(int i = n-1;i >= 1;i--){
            int temp = 0; //temporary
            for(int j =0 ; j <= n-2;j++){
                //if we found a smaller element,
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didswap = 1;
                }
            }
            if(didswap==0){
                break;
            }
        }
        return arr;
    }

    public static int[] Insertionsort(int[] arr){
        int n = arr.length;
        for(int i = 0;i <= n-1;i++){
            int temp = 0; //temporary
            int j= i;
            while(j>0 && arr[j-1] > arr[j]){
                //if we found a smaller element,
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--; 
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int [] arr1 = {45,67,39,89,23};
        System.out.println("Original array:");
        for (int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("Sorted array:");
        arr1 = Sorting.Insertionsort(arr1);
        for (int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i]+" ");
        }
    }
}