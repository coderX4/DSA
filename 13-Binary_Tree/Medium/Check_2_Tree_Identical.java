package Medium;

public class Check_2_Tree_Identical {
    static boolean Check(Node root1,Node root2){
        if(root1 == null || root2 == null){
            return (root1 == root2);
        }
        Check(root1.left,root2.left);
        Check(root1.right,root2.right);
        return (root1.data == root2.data);
    }

    public static void main(String[] args) {
        //Tree1
//        Node root1 = new Node(1);
//        Node c1 = new Node(2);
//        Node c2 = new Node(3);
//        root1.left = c1;
//        root1.right = c2;
//
//        Node c11 = new Node(4);
//        Node c12 = new Node(5);
//        c1.left = c11;
//        c1.right = c12;
//
//        Node c21 = new Node(6);
//        Node c22 = new Node(7);
//        c2.left = c21;
//        c2.right = c22;

        //Tree 2

        Node root2 = new Node(1);
        Node C1 = new Node(2);
        Node C2 = new Node(3);
        root2.left = C1;
        root2.right = C2;

        Node C11 = new Node(4);
        Node C12 = new Node(5);
        C1.left = C11;
        C1.right = C12;

        Node C21 = new Node(6);
        Node C22 = new Node(7);
        C2.left = C21;
        C2.right = C22;

        //Tree 3
        Node root = new Node(-10);
        Node c1 = new Node(9);
        Node c2 = new Node(20);
        root.left = c1;
        root.right = c2;


        Node c21 = new Node(15);
        Node c22 = new Node(7);
        c2.left = c21;
        c2.right = c22;

        System.out.println("Result: "+Check(root,root2));
    }
}
