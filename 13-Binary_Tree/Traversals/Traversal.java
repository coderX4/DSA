package Traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Pair{
    Node node;
    int num;
    Pair(Node node,int num){
        this.node = node;
        this.num = num;
    }
}
public class Traversal {
    static List<List<Integer>> Travers(Node root){
        Stack<Pair> st = new Stack<Pair>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        st.push(new Pair(root,1));

        while(!st.isEmpty()){
            Pair it = st.pop();

            if(it.num == 1){
                preorder.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num == 2){
                inorder.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                postorder.add(it.node.data);
            }
        }
        ans.add(0,preorder);
        ans.add(1,inorder);
        ans.add(2,postorder);
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

        List<List<Integer>> ans = Travers(root);
        System.out.println("Traversals: "+ans);
    }
}
