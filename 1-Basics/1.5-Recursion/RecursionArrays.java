public class RecursionArrays {

    //2pointer
    public static void func(int[] arr,int l,int r){
        int m = (arr.length)/2;
        if (l>=m) return;
        //Swap
        int c = arr[l];
        arr[l] = arr[r];
        arr[r] = c;

        func(arr,l+1,r-1);
    }

    // single pointer
    public static void func2(int[] arr,int i){
        int n = arr.length;
        if (i>= n/2) return;
        //Swap
        int c = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = c;

        func2(arr,i+1);
    }

    // string Palindrome
    public static boolean func3(char[] arr,int i){
        int n = arr.length;
        if (i>= n/2){
            return true;
        }
        if(arr[i] != arr[n-i-1]){
            return false;
        }
        
        return func3(arr,i+1);
    }

    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4,5,6};
        int n = arr.length;
        //RecursionArrays.func(arr, 0, n-1);
        //RecursionArrays.func2(arr, 0);
        for(int i =0;i<m;i++){
            System.out.print(charr1[i]+" ");
        }
        
        */
        /*String s1 = "11211";
        char[] charr = s1.toCharArray();
        System.out.println(RecursionArrays.func3(charr,0));*/

    }
}
