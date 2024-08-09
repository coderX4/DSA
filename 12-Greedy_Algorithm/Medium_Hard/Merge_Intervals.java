package Medium_Hard;

import java.util.ArrayList;

public class Merge_Intervals {

    static ArrayList<Interval> Insert(Interval[] arr, Interval[] new1){
        ArrayList<Interval> answer = new ArrayList<>();
        int i = 0,j = 0,n = arr.length, m = new1.length;
        while(j < m){
            while (i < n && arr[i].end < new1[j].start) {
                answer.add(arr[i]);
                i++;
            }

            while (i < n && arr[i].start < new1[j].end) {
                new1[j].start = Math.max(new1[j].start, arr[i].start);
                new1[j].end = Math.max(new1[j].end, arr[i].end);
                i++;
            }
            answer.add(new1[j]);
            while (i < n) {
                answer.add(arr[i]);
                i++;
            }
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Interval[] Interval = {new Interval(1,3),new Interval(6,9),new Interval(9,12)};

        Interval[] new1 = {new Interval(4,5),new Interval(8,10),new Interval(13,15)};

        ArrayList<Interval> ans = new ArrayList<>();
        ans = Insert(Interval,new1);

        for(int i = 0;i< ans.size();i++){
            System.out.print("{" + ans.get(i).start+" , "+ans.get(i).end+"}");
            System.out.print(",");
        }
    }
}
