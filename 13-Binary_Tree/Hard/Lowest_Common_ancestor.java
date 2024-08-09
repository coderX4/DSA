package Hard;

public class Lowest_Common_ancestor {
    static Node LCA(Node root,Node p,Node q){
        if(root == null || root == p || root == q){
            return root;
        }
        Node left = LCA(root.left,p,q);
        Node right = LCA(root.right,p,q);
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
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

        Node ans = LCA(root,c1,c22);
        System.out.println("Ancestor: "+ans.data);
    }
}
