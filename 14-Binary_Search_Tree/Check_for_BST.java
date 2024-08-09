import Medium.Node;

public class Check_for_BST {
    static boolean Validate(Node root,int min,int max){
        if(root == null){
            return true;
        }
        if((root.data >= max) || (root.data <= min)){
            return false;
        }
        return (Validate(root.left,min, root.data)
        && Validate(root.right, root.data, max));
    }

    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.right = new Node(10);

        boolean ans = Validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Valid or not : "+ans);
    }
}
