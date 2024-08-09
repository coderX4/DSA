import Medium.Node;

public class LCA_BST {
    static Node LCA(Node root,int p,int q){
        if(root == null ){
            return null;
        }
        if(root.data < p && root.data < q){
            return LCA(root.right,p,q);
        } else if (root.data > p && root.data > q) {
            return LCA(root.left,p,q);
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.right = new Node(2);

        Node ans = LCA(root,1,4);
        System.out.println("Ancestor: "+ans.data);
    }
}
