package Traversals;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal {
    static ArrayList<ArrayList<Integer>> BFS(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<Node>();
        Node temp = root;

        if(temp == null){
            return ans;
        }
        q1.add(temp);
        while(!q1.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < q1.size();i++){
                // Get the front node in the queue
                Node node = q1.poll();

                level.add(node.data);

                // Enqueue the child nodes if they exist
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }
            ans.add(level);
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

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = BFS(root);
        System.out.println("Result: "+ans.toString());
    }
}
