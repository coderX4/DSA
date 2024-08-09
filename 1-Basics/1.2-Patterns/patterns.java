public class patterns{

    public static void pattern1(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j < n ;j++){
                System.out.print("* ");
                
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<=i ;j++){
                System.out.print("* ");
                
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<=i ;j++){
                System.out.print(j+1 + " ");
                
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<=i ;j++){
                System.out.print(i+1 + " ");
                
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j< n-i ;j++){
                System.out.print("* ");
                
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<=n-i-1 ;j++){
                System.out.print(j+1 + " ");
                
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<n-i-1 ;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i +1;k++){
                System.out.print("*");
            }
            for(int l = 0; l<n-i-1 ;l++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<i ;j++){
                System.out.print(" ");
            }
            for(int k= 0;k<2*n-(2*i+1);k++){
                System.out.print("*");
            }
            for(int l = 0; l<i ;l++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        // Write your code here
       patterns.pattern7(n);
       patterns.pattern8(n);
    }

    public static void pattern10(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
                for(int j = 0; j<=i ;j++){
                System.out.print("* ");}
            
            System.out.println();
        }
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<n-i-1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        // Write your code here
        int s =  0;
        for(int i = 0; i<n ;i++){
            if(i%2==0){  s = 1;}
            else{ s = 0;}
            for(int j = 0; j<=i ;j++){
                System.out.print(s);
                s = 1-s;
            }
            System.out.println();
        }
    }

    public static void pattern12(int n){
        //Write your code here
        int s = 2 *(n-1);
        for(int i =0; i<n ; i++){
            for(int j=0; j <=i; j++){
                System.out.print(j+1);
            }
            for(int k=0;k<=s;k++){
                System.out.print(" ");
            }
            for(int j=i; j >= 0; j--){
                System.out.print(j+1);
            }
             System.out.println();
             s-=2;
        }
    }

    public static void pattern13(int n){
        int num = 1; 
        for(int i=0; i<n ;i++){
            for(int j=0; j<=i; j++){
                System.out.print(num + " ");
                num += 1 ;
            }
            System.out.println();
        }
    }

    public static void pattern14(int n){
        for(int i=0;i<n;i++){
            for(char j='A';j<= 'A'+i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern15(int n){
        for(int i=0;i<n;i++){
            for(char j='A';j<='A'+(n-i-1);j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void pattern16(int n){
        char ch = 'A';
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(ch+" ");
            }
            System.out.println();
            ch += 1;
        }
    }

    public static void pattern17(int n) {
        // Write your code here
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<n-i-1 ;j++){
                System.out.print(" ");
            }
            char ch = 'A';
            int bpt = (2*i +1)/2 ;
            for(int k=0;k<2*i+1;k++){
                System.out.print(ch);
                if(k < bpt){
                    ch++;
                }
                else{
                    ch--;
                }

            }
            for(int l = 0; l<n-i-1 ;l++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

     public static void pattern18(int n){
        char ch = 'F';
        for(int i=0;i<n;i++){
            for(ch -= i ; ch < 'F';ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    public static void pattern18a(int n){
        for(int i=0;i<n;i++){
            char ch = 'A';
            ch += n-1;
            for(int j=0;j<=i;j++){
                System.out.print(ch);
                ch--;
            }
            System.out.println();
        }
    }

    public static void pattern19(int n){
        //Write your code here
        //upper half
        int s1 =0;
        for(int i =0; i<n ; i++){
            for(int j=0; j <n-i; j++){
                System.out.print("*");
            }
            for(int k=0;k<=s1;k++){
                System.out.print(" ");
            }
            for(int j=n-i; j > 0; j--){
                System.out.print("*");
            }
             System.out.println();
             s1+=2;
        }


        //Lower half
        int s = 2 *(n-1);
        for(int i =0; i<n ; i++){
            for(int j=0; j <=i; j++){
                System.out.print("*");
            }
            for(int k=0;k<=s;k++){
                System.out.print(" ");
            }
            for(int j=i; j >= 0; j--){
                System.out.print("*");
            }
             System.out.println();
             s-=2;
        }
    }

    public static void pattern20(int n) {
        // Write your code here
        //Upper
        int s1 = 2 *(n-1);
        for(int i = 0; i<n ;i++){
            //U1
            for(int j = 0; j<=i ;j++){
                System.out.print("*");
            }
            //space
            for(int k = 0;k<s1;k++){
                System.out.print(" ");
            }
            //U2
            for(int j =i;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
            s1 -=2;
        }

        //Middle m
        /*for(int i = 0;i<2*n;i++){
            System.out.print("*");
        }
        System.out.println();*/

        //Lower
        int s=2;
        for(int i = 0; i<n ;i++){
            //L1
            for(int j = 0; j<n-i-1; j++){
                System.out.print("*");
            }
            //Space
            for(int k=0;k<s;k++){
                System.out.print(" ");
            }
            //L2
            for(int j=n-i-1;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
            s+=2;
        }
    }

    public static void pattern21(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                if(i == 0 || i == n-1 || j== 0 || j == n-1 ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static void pattern22(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                if(i == 0 || i == n-1 || j== 0 || j == n-1 ){
                    System.out.print(n);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static void main(String[] args){
        int n = 4;
        patterns.pattern20(n);
    }
    
}