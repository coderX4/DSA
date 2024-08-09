import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
public class Arrays2 {
    //Rotation left by one place
    public static void rotateleftby1(int[] arr){
        int n = arr.length;
        int temp = arr[0];
        for(int i = 1;i<n;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1]=temp;
    }
    
    //reversal of an array
    public static void reverse(int[] arr,int start,int end){
        while (start < end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    //roation left by d places
    public static void rotateleftbyD(int[] arr,int d) {
        int n = arr.length;
        d=d%n;//this is to handle the case when d>n
        Arrays2.reverse(arr,0,d-1);
        Arrays2.reverse(arr,d,n-1);
        Arrays2.reverse(arr,0,n-1);
    }
    //rotate right by d places
    public static void rotaterightbyD(int[] arr,int d) {
        int n = arr.length;
        d=d%n;//this is to handle the case when d>n
        Arrays2.reverse(arr,0,n-d-1);
        Arrays2.reverse(arr,n-d,n-1);
        Arrays2.reverse(arr,0,n-1);
    }

    //move all zeros to end of the array
    public static void movezero(int[] arr){
        int n = arr.length;
        int j = -1;
        for(int i = 0;i<n;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1) return ;
        
        for(int i = j+1;i<n;i++){
            if(arr[i]!= 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    
    //Linear search
    public static int linearsearch(int[] arr,int x){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    //Union of two sorted arrays
    //Brute method
    //less time complexity
    //more space complexity
    public static List<Integer> unionOfTwoSortedArrays(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i =0;i<n;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(Integer ele: set){
            list.add(ele);
        }
        return list;
    }

    //optimal approach
    //more time but less space
    public static List<Integer> unionofarr(int[] arr1,int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i =0 , j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m){
            if(arr1[i] <= arr2[j]){
                if(list.size()==0 || ! list.contains(arr1[i])){
                    list.add(arr1[i]);
                }
                i++;
            }
            else{
                if(list.size()==0 || ! list.contains(arr2[j])){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while(i < n){
            if(! list.contains(arr1[i])){
                list.add(arr1[i]);
            }
            i++;
        }

        while(j<m){
            if(! list.contains(arr2[j])){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;

    }

    //Intersection of two sorted arrays
    public static List<Integer> intersectionOfArrays(int[] arr1,int[] arr2){
        int i=0, j=0;
        int n = arr1.length , m = arr2.length;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n && j<m) {
            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if(arr1[i] > arr2[j]){
                    j++;
                }
            else{
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] A = {1,2,2,3,3,5,5,7,8,10};
        int[] B = {2,2,4,4,5,6,7,8,9};
        /*int num = 5;
        System.out.println("Given array: "+Arrays.toString(A));
        int index = Arrays2.linearsearch(A,num);
        System.out.println(num+" at index "+index);*/
        //System.out.println("Result: "+Arrays.toString(A));
        List<Integer> op = Arrays2.intersectionOfArrays(A, B);
        System.out.println(op);
    }
}
