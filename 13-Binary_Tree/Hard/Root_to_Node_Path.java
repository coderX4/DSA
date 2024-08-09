package Hard;

import java.util.ArrayList;

public class Root_to_Node_Path {

    static boolean Path(Node root, ArrayList<Integer> ans,int x){
        if(root == null){
            return false;
        }
        ans.add(root.data);
        if(root.data == x){
            return true;
        }
        if(Path(root.left,ans,x)|| Path(root.right,ans,x)){
            return true;
        }
        else{
            ans.remove(ans.size()-1);
            return false;
        }
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

        ArrayList<Integer> ans = new ArrayList<>();
        Path(root,ans,7);
        System.out.println("Path: "+ans);
    }
}
