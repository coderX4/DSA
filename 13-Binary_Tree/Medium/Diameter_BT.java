package Medium;

public class Diameter_BT {

    static int Diameter(Node root){
        int[] diameter = new int[1];
        Height(root,diameter);
        return diameter[0];
    }
    static int Height(Node root,int[] maxi){
        if(root == null){
            return 0;
        }
        int lh = Height(root.left,maxi);
        int rh = Height(root.right,maxi);
        maxi[0 ] = Math.max(maxi[0],(lh+rh));
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

        System.out.println("Diameter: " + Diameter(root));
    }
}
