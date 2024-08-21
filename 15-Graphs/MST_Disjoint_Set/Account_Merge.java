package MST_Disjoint_Set;

import java.util.*;

public class Account_Merge {
    static ArrayList<ArrayList<String>> Merge(ArrayList<ArrayList<String>> details){
        int n = details.size();
        Disjoint_Set ds = new Disjoint_Set(n);
        HashMap<String,Integer> mapnode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if (!mapnode.containsKey(mail)) {
                    mapnode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapnode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<String>();
        }
        for (Map.Entry<String, Integer> it : mapnode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main (String[] args) {
        ArrayList<ArrayList<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        ArrayList<ArrayList<String>> ans = Merge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println();
        }

    }
}
