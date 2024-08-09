package Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder_Traversal {
     static void Preorder(Node root){
         Node temp = root;
         if (temp == null) {
             return;
         }
         System.out.print(temp.data + " ");
         Preorder(temp.left);
         Preorder(temp.right);
    }

    static ArrayList<Integer> Iterative_Preorder(Node root){
        ArrayList<Integer> preorder = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            Node node = s1.pop();
            preorder.add(node.data);
            if(node.right != null){
                s1.push(node.right);
            }
            if(node.left != null){
                s1.push(node.left);
            }
        }
        return preorder;
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

        //Preorder(root);

        ArrayList<Integer> ans = Iterative_Preorder(root);
        System.out.println(ans.toString());

    }
}
