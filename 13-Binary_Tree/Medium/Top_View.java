package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Top_View {

    static void left(Node root,Stack<Integer> st){
        if(root == null){
            return;
        }
        st.push(root.data);
        left(root.left,st);
    }

    static void right(Node root,Stack<Integer> st){;
        if(root == null){
            return;
        }
        right(root.right,st);
        st.push(root.data);
    }
    static List<Integer> Topview(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        left(root, st);
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        right(root.right, st);
        while (!st.isEmpty()) {
            ans.add(st.pop());
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

        List<Integer> ans = Topview(root);
        System.out.println("Top View: "+ans);
    }
}
