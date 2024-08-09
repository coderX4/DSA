import Medium.Node;

import java.util.Stack;


class BST_Iterator{
    private Stack<Node> st = new Stack<>();
    boolean reverse = true;

    public BST_Iterator(Node root,boolean isreverse){
        reverse = isreverse;
        pushAll(root);
    }
    public int Next(){
        Node temp = st.pop();
        if(reverse == false){
            pushAll(temp.right);
        }
        else{
            pushAll(temp.left);
        }
        return temp.data;
    }
    public boolean hasnext(){
        return !st.isEmpty();
    }

    private void pushAll(Node node){
        while(node != null){
            st.push(node);
            if(reverse == true){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
    }
}
public class Two_Sum_BST {

    public static boolean find_2_sum(Node root,int k){
        if(root == null){
            return  false;
        }
        BST_Iterator l = new BST_Iterator(root,false);
        //before() for insertion of rights
        BST_Iterator r = new BST_Iterator(root,true);

        int i = l.Next();
        int j = r.Next();

        while(i < j){
            if(i + j == k){
                return true;
            }
            else if(i + j < k){
                i = l.Next();
            }
            else{
                j = r.Next();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        boolean ans = find_2_sum(root,4);
        System.out.println("Two sum: "+ans);
    }
}
