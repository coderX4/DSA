package Medium;

public class Check_Balanced_Tree {
    static int Check(Node root){
        if(root == null){
            return 0;
        }
        int lh = Check(root.left);
        int rh = Check(root.right);
        if(lh == -1 || rh == -1){
            return -1;
        }
        if(Math.abs(lh-rh) > 1){
            return -1;
        }
        return (1 + Math.max(lh,rh));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        //Node c1 = new Node(2);
        Node c2 = new Node(3);
        //root.left = c1;
        root.right = c2;

        //Node c11 = new Node(4);
        //Node c12 = new Node(5);
        //c1.left = c11;
        //c1.right = c12;

        Node c21 = new Node(6);
        Node c22 = new Node(7);
        c2.left = c21;
        c2.right = c22;

        int res = Check(root);
        if(res == -1){
            System.out.println("Not Balanced");
        }
        else{
            System.out.println("Balanced");
        }
    }
}
