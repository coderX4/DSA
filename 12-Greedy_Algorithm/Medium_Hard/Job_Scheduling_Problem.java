package Medium_Hard;

import java.util.*;

class Job{
    int id;
    int deadline;
    int profit;

    Job(int id,int deadline,int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;

    }
}


public class Job_Scheduling_Problem {

    static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int[] result = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {

                // Free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;

    }

    public static void main(String[] args) {

        Job[] arr = new Job[8];
        arr[0]  = new Job(1, 4, 20);
        arr[1] = new Job(2, 5, 60);
        arr[2] = new Job(3, 6, 70);
        arr[3] = new Job(4, 6, 65);
        arr[4] = new Job(5, 4, 25);
        arr[5] = new Job(6, 2, 80);
        arr[6] = new Job(7, 2, 10);
        arr[7] = new Job(8, 2, 22);

        int[] res = JobScheduling(arr,8);
        System.out.println("Jobs: "+res[0] + "  MaxProfit: " + res[1]);
    }
}
