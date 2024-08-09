package Medium;

public class Maximum_Height {
    static int Max_Depth(Node root){
        if(root == null){
            return 0;
        }
        int lh = Max_Depth(root.left);
        int rh = Max_Depth(root.right);
        return (1 + Math.max(lh,rh));
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

        System.out.println("Max Height: " + Max_Depth(root));
    }
}
