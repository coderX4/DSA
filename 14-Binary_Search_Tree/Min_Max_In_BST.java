import Medium.Node;

public class Min_Max_In_BST {
    static Node Max_BST(Node root){
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    static Node Min_BST(Node root){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root =  new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(13);

        Node min_ele = Min_BST(root);
        Node max_ele = Max_BST(root);

        System.out.println("Min Element: "+min_ele.data);
        System.out.println("Max Element: "+max_ele.data);
    }
}
