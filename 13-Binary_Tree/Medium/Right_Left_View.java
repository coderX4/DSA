package Medium;

import java.util.ArrayList;

public class Right_Left_View {
    static void Right(Node root,ArrayList<Integer> ans,int level){
        if(root == null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.data);
        }

        Right(root.right,ans,level+1);
        Right(root.left,ans,level+1);
    }

    static void Left(Node root,ArrayList<Integer> ans,int level){
        if(root == null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.data);
        }

        Left(root.left,ans,level+1);
        Left(root.right,ans,level+1);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root =  new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);

        //Right view

        ArrayList<Integer> res = new ArrayList<>();
        Right(root,res,0);
        System.out.println("Right View: "+res);

        //Left view
        res.clear();
        Left(root,res,0);
        System.out.println("Right View: "+res);

    }
}
