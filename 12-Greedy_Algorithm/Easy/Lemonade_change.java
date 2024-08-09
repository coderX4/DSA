package Easy;

public class Lemonade_change {
    static boolean Change(int[] bills){
        int five = 0,ten = 0, twenty = 0;

        for(int i = 0; i< bills.length;i++){
            if(bills[i] == 5){
                five++;
            }
            else if (bills[i]  == 10) {
                if(five > 0){
                    ten++;
                    five--;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                    twenty++;
                }
                else if (five >= 3) {
                    five = five - 3;
                    twenty++;
                }
                else{
                    return  false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println("Result:  "+ Change(bills));
    }
}
