import Medium.Node;

public class Recover_BST {

    static  Node first, middle, last, prev;
    static void Inorder(Node root){
        if(root == null){
            return ;
        }
        Inorder(root.left);
        if(prev != null && (root.data < prev.data)){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        Inorder(root.right);
    }
    static void Recover(Node root){
        first = last = middle = null;
        prev = new Node(Integer.MIN_VALUE);
        Inorder(root);

        if(first != null && last != null){
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }
        else if(first != null && middle != null){
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }

    static void Print(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        Print(temp.left);
        System.out.print(temp.data + " ");
        Print(temp.right);
    }

    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        //root.left.left.right = new Node(10);

        Print(root);

        System.out.println();

        Recover(root);

        Print(root);
    }
}
