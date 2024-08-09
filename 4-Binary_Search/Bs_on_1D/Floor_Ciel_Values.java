package Bs_on_1D;

public class Floor_Ciel_Values {
    public static int Floor(int[] arr,int x){
        int low = 0,high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] <= x){
                ans = arr[mid];
                low  = mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    public static  int Ciel(int[] arr,int x){
        int low = 0,high = arr.length-1;
        int ans = arr.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,3,5,6,8,8,10,11};
        int x = 8;
        int floor1 = Floor_Ciel_Values.Floor(A,x);
        int ciel1 = Floor_Ciel_Values.Ciel(A,x);
        System.out.println("Floor: "+floor1);
        System.out.println("Ciel: "+ciel1);

    }

}
