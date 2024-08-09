import java.lang.Math;
public class  Digits{

    public static void Countnumberofdigits(int num){
        int k = 0;
        while(num>0){
            int lstdigit = num % 10;
            num /= 10;
            k += 1;
        }
        System.out.println("Number of digits:" + k);
    }

    public static void ReverseDigit(int n){
        int revdgt = 0;
        while(n>0){
            int lstdgt =  n%10;
            n /= 10;
            revdgt = (revdgt*10)+lstdgt;
        }
        System.out.println("Revrse of n: "+ revdgt);
    } 

    public static void Palindrome(int n){
        int k = n;
        int revdgt = 0;
        while(n>0){
            int lstdgt =  n%10;
            n /= 10;
            revdgt = (revdgt*10)+lstdgt;
        }
        if(k == revdgt){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    } 

    public static void ArmstrongNumber(int n){
        int k = n;
        double j = 0;
        int revdgt = 0;
        while(n>0){
            n /= 10;
            j += 1;
        }
        n = k;
        double armsum = 0;
        while(n>0){
            double lstdgt =  n%10;
            n /= 10;
            armsum = armsum + Math.pow(lstdgt,j);
        }
        if(k == armsum){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    } 

    public static void Divisors(int n){
        for(int i = 1 ;i <= Math.sqrt(n) ; i++){
            if(n % i == 0) {
                System.out.print(i+" ");
                if( n/i != i){
                System.out.print(n/i+" ");
            }
            }
        }
    }

    public static void Prime(int n){
        int cnt = 0;
        for(int i = 1; i*i<=n;i++){
            if(n % i==0){
                cnt ++;
                if(n/i != i){ cnt++;}
            }
        }
        if(cnt ==2 ){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

    public static void GCD(int a, int b){
        while(a>0 && b>0){
            if(a>b){a = a%b;}
            else{b=b%a;}
        }
        if(a == 0){System.out.println(b);}
        else{ System.out.println(a);}
    }
    
    public static void main(String[] args){
        int num = 9 ;
        int d = 12;
        Digits.GCD(num,d);
    }
}