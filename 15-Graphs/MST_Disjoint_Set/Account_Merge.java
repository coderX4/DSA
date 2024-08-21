package MST_Disjoint_Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
}
