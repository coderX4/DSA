package Medium_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Intervals{
    int start;
    int end;

    Intervals(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Intervals>
{
    @Override
    public int compare(Intervals o1, Intervals o2)
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        return 1;
    }
}
public class Non_Overlaping_Intervals {
    static int Min_Overlaps(int[] start,int[] end,int n){
        ArrayList<Intervals> arr = new ArrayList<>();
        for(int i = 0;i < n;i++){
            arr.add(new Intervals(start[i], end[i]));
        }
        Collections.sort(arr,new IntervalComparator());

        int Mincnt = 1;
        int freetime = arr.get(0).end;

        for(int i = 1;i < n-1;i++){
            if(arr.get(i).end >= freetime){
                Mincnt++;
                freetime = arr.get(i).end;
            }
        }
        return (n-Mincnt);
    }

    public static void main(String[] args) {
        int[] start = {1,2,3,1};
        int[] end = {2,3,4,3};
        int n = 4;

        System.out.println("Minimum Overlap: "+Min_Overlaps(start,end,n));
    }
}
