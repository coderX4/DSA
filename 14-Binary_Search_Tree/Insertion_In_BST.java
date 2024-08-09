import Medium.Node;

public class Insertion_In_BST {
    static Node Insert(Node root,int n1){
        Node temp = root;
        while(temp.left!= null || temp.right != null){
            if(n1 <= temp.data){
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        Node x =  new Node(n1);
        if(n1 <= temp.data){
            temp.left = x;
        }
        else{
            temp.right = x;
        }
        return root;
    }

    static void Inorder(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        Inorder(temp.left);
        System.out.print(temp.data + " ");
        Inorder(temp.right);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root =  new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        //Before
        Inorder(root);
        System.out.println();

        root = Insert(root,11);
        Inorder(root);
    }
}
