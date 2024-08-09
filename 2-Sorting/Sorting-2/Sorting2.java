import java.util.ArrayList;

public class Sorting2 {

    //Mergesort
    public static void Merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr
        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // if elements on the left half are still left //
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public  void Mergesort(int[] arr,int low,int high){
        if (low >= high){return;}
        int mid = (low+high)/2;
        Mergesort(arr,low,mid);
        Mergesort(arr,mid+1,high);
        Sorting2.Merge(arr, low,mid, high);
    }

    //Quick Sort
    public static int Partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i = low ;
        int j = high;
        while(i<j){
            while(arr[i]<= pivot && i<=high-1){
                i++;
            }
            while(arr[j]> pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //Swap
        int temp = arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
    public void Quicksort(int[] arr,int low,int high){
        if(low<high){
            //pi is partition index
            int pi = Sorting2.Partition(arr,low,high);
            Quicksort(arr,low,pi-1);
            Quicksort(arr,pi+1,high);
        }
    }

    public static void main(String[] args){
        Sorting2 obj = new Sorting2();
        int [] arr1 = {4,6,2,5,7,9,1,3};
        int n = arr1.length;
        System.out.println("Original array:");
        for (int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("Sorted array:");
        obj.Quicksort(arr1,0,n-1);
        for (int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i]+" ");
        }
    }
}
