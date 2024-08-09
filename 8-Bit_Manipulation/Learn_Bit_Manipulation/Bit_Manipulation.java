package Learn_Bit_Manipulation;

public class Bit_Manipulation {
    //1) Swap 2 numbers
    public  static void Swap_2_numbers(int a, int b){
        System.out.println("a : "+a+" and b : "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swap ... ");
        System.out.println("a : "+a+"and b : "+b);
    }

    //2) Check if i th bit is set or not
    public static void Check_i_set_or_not(int n,int i){
        int d = n;
        if((n & (1<<i)) != 0){
            System.out.println(i+" th bit is set in " + d);
        }
        else{
            System.out.println(i+" th bit is not set in " + d);
        }
    }

    //3) Set the i th bit
    public static void Set_i_bit(int n, int i){
        System.out.println("Number: "+n);
        n = n | (1 << i);
        System.out.println("New number: "+n);
    }

    //4) Clear the i th bit
    public static void Clear_i_bit(int n,int i){
        System.out.println("Number: "+n);
        n = n & (~(1 << i)) ;
        System.out.println("New number: "+n);
    }

    //5) Toggle the i th bit
    public static void Toggle_i_bit(int n,int i){
        System.out.println("Number: "+n);
        n = n ^ (1 << i) ;
        System.out.println("New number: "+n);
    }

    //6) Remove the last set bit
    public static void Remove_last_bit(int n){
        System.out.println("Number: "+n);
        n = n & (n - 1) ;
        System.out.println("New number: "+n);
    }

    //7) Check if number is power of 2
    public static void Check_if_pow_2(int n){

        if((n & ( n-1 )) == 0){
            System.out.println(n+" is power of 2.");
        }
        else{
            System.out.println(n+" is not power of 2.");
        }
    }

    //8) Count the number of set bits
    public static void Count_set_bits(int n){
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        System.out.println("Number of set bits: "+ cnt);
    }

    public static void main(String[] args) {
        //1) Swap 2 numbers
        //int a = 10, b = 20;
        //Swap_2_numbers(a,b);

        //2) Check if i th bit is set or not
        //int n = 13, i = 1;
        //Check_i_set_or_not(n,i);

        //3) Set the i th bit
        //int n = 13, i = 1;
        //Set_i_bit(n,i);

        //4) Clear the i th bit
        //int n = 13, i = 2;
        //Clear_i_bit(n,i);

        //5) Toggle the i th bit
        //int n = 13, i = 1;
        //Toggle_i_bit(n,i);

        //6) Remove the last bit
        //int n = 13 ;
        //Remove_last_bit(n);

        //7) Check if number is power of 2
        //int n = 64 ;
        //Check_if_pow_2(n);

        //8 Count the number of set bits
        //int n = 13 ;
        //Count_set_bits(n);
    }
}
