package Traversals;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Stack;

public class Inorder_Traversal {
    static void Inorder(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        Inorder(temp.left);
        System.out.print(temp.data + " ");
        Inorder(temp.right);
    }

    static ArrayList<Integer> Iterative_Inorder(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();

        Node temp = root;
        while(true){
            if(temp != null){
                s1.push(temp);
                temp = temp.left;
            }
            else{
                if(s1.isEmpty()){
                    break;
                }
                temp = s1.pop();
                inorder.add(temp.data);
                temp = temp.right;
            }
        }

        return inorder;
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

        Inorder(root);

        ArrayList<Integer> ans = Iterative_Inorder(root);
        System.out.println(ans.toString());

    }
}
