package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Item{
    double value;
    double weight;

    Item(double value,double weight){
        this.value = value;
        this.weight = weight;
    }
}
class ValueComparator implements Comparator<Item>
{
    @Override
    public int compare(Item o1, Item o2)
    {
        if ((o1.value/ o1.weight) > (o2.value/ o2.weight))
            return -1;
        return 1;
    }
}

public class Fractional_Knapsack {

    static double Max_Profit(ArrayList<Item> arr, double Weight){
        double profit = 0;
        ValueComparator comp = new ValueComparator();

        Collections.sort(arr,comp);

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).weight <= Weight){
                profit += arr.get(i).value;
                Weight -= arr.get(i).weight;
            }
            else{
                profit += ((arr.get(i).value / arr.get(i).weight) * Weight);
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        ArrayList<Item> arr = new ArrayList<>();
        arr.add(new Item(100,20));
        arr.add(new Item(60,10));
        arr.add(new Item(100,50));
        arr.add(new Item(200,50));

        System.out.println("Result: "+Max_Profit(arr,90));
    }
}
