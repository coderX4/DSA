package Bs_on_2D;

public class Find_PeakElement_in_2D {
    public static void main(String[] args) {
        int[][] arr = { { 9,10, 8 }, { 2,6,15 } };

        int[] result = Peak_element(arr);

        System.out.println("Peak element found at index: "
                + result[0] + "," + result[1]);
    }

    public static int findmaxindex(int[][] arr,int col){
        int n = arr.length, m = arr[0].length;
        int indx = -1, maxvalue = -1;
        for(int i=0;i<n;i++){
            if(arr[i][col] > maxvalue){
                maxvalue = arr[i][col];
                indx = i;
            }
        }
        return indx;
    }
    public static int[] Peak_element(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int low = 0, high = m-1;
        int[] ans = {-1,-1};
        while(low <= high){
            int mid = (low + high)/2;
            int maxrowindx = findmaxindex(arr,mid);
            int left = mid -1 >= 0 ? arr[maxrowindx][mid-1] : -1;
            int right = mid +1 < m  ? arr[maxrowindx][mid+1] : -1;
            if(arr[maxrowindx][mid] > left && arr[maxrowindx][mid]>right){
                ans[0] = maxrowindx;
                ans[1] = mid;
                return ans;
            }
            else if(arr[maxrowindx][mid] < left){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}
