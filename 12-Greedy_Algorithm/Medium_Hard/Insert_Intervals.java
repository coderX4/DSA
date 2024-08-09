package Medium_Hard;

import java.util.ArrayList;

class Interval{
    int start;
    int end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Insert_Intervals {
    static ArrayList<Interval> Insert(Interval[] arr, Interval new1){
        ArrayList<Interval> answer = new ArrayList<>();
        int i = 0,n = arr.length;
        while(i < n && arr[i].end < new1.start ){
            answer.add(arr[i]);
            i++;
        }

        while(i < n && arr[i].start < new1.end ){
            new1.start = Math.max(new1.start,arr[i].start);
            new1.end = Math.max(new1.end,arr[i].end);
            i++;
        }
        answer.add(new1);
        while(i < n){
            answer.add(arr[i]);
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Interval[] Interval = {new Interval(1,3),new Interval(6,9),
                new Interval(10,12)};

        Interval new1 = new Interval(4,5);

        ArrayList<Interval> ans = new ArrayList<>();
        ans = Insert(Interval,new1);

        for(int i = 0;i< ans.size();i++){
            System.out.print("{" + ans.get(i).start+" , "+ans.get(i).end+"}");
            System.out.print(",");
        }

    }

}
