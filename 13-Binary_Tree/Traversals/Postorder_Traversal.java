package Traversals;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder_Traversal {
    static void Postorder(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        Postorder(temp.left);
        Postorder(temp.right);
        System.out.print(temp.data + " ");
    }

    static Stack<Integer> Iterative_Postorder(Node root){
        Stack<Integer> postorder = new Stack<>();
        Stack<Node> s1 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            Node node = s1.pop();
            postorder.push(node.data);
            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        return postorder;
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

        Postorder(root);

        Stack<Integer> ans = Iterative_Postorder(root);

        while(!ans.isEmpty()){
            System.out.print(ans.pop()+" ");
        }

    }
}
