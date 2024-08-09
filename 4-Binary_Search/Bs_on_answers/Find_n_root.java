package Bs_on_answers;

public class Find_n_root {
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(n+" root of "+m+" : "+n_root(n,m));
    }

    public static int n_root(int n, int m) {
        int low = 1 , high = m;
        while(low <= high){
            int mid = (low + high) / 2;
            int midn = func(mid,n,m);
            if(midn == 1){
                return mid;
            }
            else if (midn == 0) {
                 low = mid + 1;
            }
            else{
                 high = mid - 1;
            }
        }
        return -1;
    }

    public static int func(int mid, int n, int m) {
        int ans = 1;
        for(int i = 1;i <= n;i++){
            ans = ans * mid;
        }
        if(ans > m)
            return 2;
        else if(ans == m)
            return 1;
        else
            return 0;
    }
}
