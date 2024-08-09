package Hard;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width {

    static class Pair{
        Node node;
        int num;

        Pair(Node node,int num){
            this.node = node;
            this.num = num;
        }
    }
    static int WidthBT(Node root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while (!q.isEmpty()){
            int size =  q.size(),last = 0,first = 0;
            int mini = q.peek().num;
            for(int i=0;i<size;i++){
                int curr_ind = q.peek().num - mini;
                Node node = q.peek().node;
                q.poll();
                if(i==0)
                    first  = curr_ind;
                if(i == size-1)
                    last = curr_ind;
                if(node.left != null)
                    q.offer(new Pair(node.left,curr_ind*2 +1));
                if(node.right != null)
                    q.offer(new Pair(node.right,curr_ind*2 +2));
            }
            ans = Math.max(ans,last-first +1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node c1 = new Node(2);
        Node c2 = new Node(3);
        root.left = c1;
        root.right = c2;

        Node c11 = new Node(4);
        Node c12 = new Node(5);
        c1.left = c11;
        c1.right = c12;

        Node c21 = new Node(6);
        Node c22 = new Node(7);
        c2.left = c21;
        c2.right = c22;

        int ans = WidthBT(root);
        System.out.println("Max Width: "+ans);
    }
}
