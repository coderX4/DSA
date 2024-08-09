public class Recursiveclass{

    //Print name n times
    public static void Printname(int i,int n){
        if (i>n) {
            return ;
        }
        System.out.println("Deep");
        Printname(i+1,n);
    }

    //Print 1 --> N linearly
    public static void PrintLinearly(int i,int n){
        if (i>n) {
            return ;
        }
        System.out.print(i+ " ");
        PrintLinearly(i+1,n);
    }

    //Print N --> 1 linearly
    public static void PrintReverseLinearly(int n){
        if (n==0) {
            return ;
        }
        System.out.print(n+ " ");
        PrintReverseLinearly(n-1);
    }

    //Print 1 --> N linearly using Backtracking
    public static void BacktrackLinearly(int i){
        if (i<1) {
            return ;
        }
        BacktrackLinearly(i-1);
        System.out.print(i+ " ");
    }

    //Print N --> 1 linearly using Backtracking
    public static void BacktrackReverseLinearly(int i, int n){
        if (i > n) {
            return ;
        }
        BacktrackReverseLinearly(i+1,n);
        System.out.print(i+ " ");
    }
    
    //Parameterized Recursion
    public static void sumofnaturalnumber1(int i,int sum){
        if (i < 1) {
            System.out.println(sum);
            return ;
        }
        sumofnaturalnumber1(i-1,sum + i);
    }

    //Function Recursion
    public static int  sumofnaturalnumber2(int n){
        if (n == 0) {
            return 0;
        }
        return n + sumofnaturalnumber2(n-1);
    }

    //Factorial of n
    public static int  Factorial(int n){
        if (n == 0) {
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            return n * Factorial(n - 1);
        }
    }

    //Fibonaci series 
    public static int Fibonacii(int n){
        if (n <= 1) return n;
        return Fibonacii(n-1) + Fibonacii( n-2);
    }
    public static void main(String[] args) {
        int n = 6 ;
        System.out.println("Result"+ Recursiveclass.Fibonacii(n));
    }
}
