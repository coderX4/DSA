import Medium.Node;

public class Inorder_Successor_Predecessor {
    static int Successor(Node root,int val){
        int successor = 0;
        while(root != null){
            if(val >= root.data){
                root = root.right;
            }
            else{
                successor = root.data;
                root = root.left;
            }
        }
        return successor;
    }

    static int Predecessor(Node root,int val){
        int predecessor = 0;
        while(root != null){
            if(val <= root.data){
                root = root.left;
            }
            else{
                predecessor = root.data;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.left.left.left = new Node(1);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);

        int successsor = Successor(root,8);
        System.out.println("Successor: "+successsor);

        int predecessor = Predecessor(root,8);
        System.out.println("Predecessor: "+predecessor);

    }
}
