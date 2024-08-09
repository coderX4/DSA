package Medium;

import Traversals.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Zig_Zag_Traversal {

    static ArrayList<ArrayList<Integer>> Zig_Zag(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<Node>();
        Node temp = root;

        if(temp == null){
            return ans;
        }
        q1.add(temp);
        boolean flag = true;
        while(!q1.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < q1.size();i++){
                // Get the front node in the queue
                Node node = q1.poll();
                int index = i;
                if(!flag){
                    index = q1.size() - i - 1;
                }
                level.add(index,node.data);

                // Enqueue the child nodes if they exist
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }
            flag = !flag;
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        Traversals.Node root = new Traversals.Node(1);
        Traversals.Node c1 = new Traversals.Node(2);
        Traversals.Node c2 = new Traversals.Node(3);
        root.left = c1;
        root.right = c2;

        Traversals.Node c11 = new Traversals.Node(4);
        Traversals.Node c12 = new Traversals.Node(5);
        c1.left = c11;
        c1.right = c12;

        Traversals.Node c21 = new Traversals.Node(6);
        Traversals.Node c22 = new Node(7);
        c2.left = c21;
        c2.right = c22;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = Zig_Zag(root);
        System.out.println("Result: "+ans.toString());
    }
}
