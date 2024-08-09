import Medium.Node;

public class K_Smallest_Largest_Element {
    static void Smallest(Node root,int k,int[] cnt,int[] ksmallest){
        if(root == null){
            return;
        }
        Smallest(root.left,k,cnt,ksmallest);
        cnt[0]++;
        if(cnt[0] == k){
            ksmallest[0] = root.data;
            return;
        }
        Smallest(root.right,k,cnt,ksmallest);
    }

    static void Largest(Node root,int k,int[] cnt,int[] klargest){
        if(root == null){
            return;
        }
        Largest(root.right,k,cnt,klargest);
        cnt[0]++;
        if(cnt[0] == k){
            klargest[0] = root.data;
            return;
        }
        Largest(root.left,k,cnt,klargest);
    }
    static int[] find_Kth_small_large(Node root,int k){
        int[] cnt = new int[]{0};
        int[] ksmallest = new int[]{Integer.MIN_VALUE};
        int[] klargest = new int[]{Integer.MAX_VALUE};

        Smallest(root,k,cnt,ksmallest);
        cnt[0] = 0;
        Largest(root,k,cnt,klargest);

        int[] ans = {ksmallest[0],klargest[0]};

        return ans;
    }

    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.right = new Node(2);

        int[] ans = find_Kth_small_large(root,3);
        System.out.println("Smallest: "+ans[0]);
        System.out.println("Largest: "+ans[1]);
    }
}
