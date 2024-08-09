package Medium;

public class Check_For_Symmeetrical {
    static boolean IsSymmetrical(Node root){
        return root==null  || issymmetricalhelp(root.left,root.right);
    }
    static boolean issymmetricalhelp(Node left,Node right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.data != right.data){
            return false;
        }
        return (issymmetricalhelp(left.left,right.right) &&
                issymmetricalhelp(left.right,right.left));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean ans = IsSymmetrical(root);
        System.out.println(ans);
    }
}
