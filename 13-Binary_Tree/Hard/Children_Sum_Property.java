package Hard;

public class Children_Sum_Property {
    static void ChangeTree(Node root){
        if(root == null){
            return ;
        }
        int child = 0;
        if(root.left != null){
            child += root.left.data;
        }
        if(root.right != null){
            child += root.right.data;
        }
        if(child >= root.data){
            root.data = child;
        }
        else{
            if(root.left != null){
                root.left.data = root.data;
            }
            else if(root.right != null){
                root.right.data = root.data;
            }
        }
        ChangeTree(root.left);
        ChangeTree(root.right);

        int total = 0;
        if(root.left != null)
            total += root.left.data;
        if(root.right != null)
            total += root.right.data;
        if(root.left != null || root.right != null)
            root.data = total;
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
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

        //Before change
        inorderTraversal(root);
        System.out.println();

        ChangeTree(root);

        //After children sum property applied
        inorderTraversal(root);
        System.out.println();
    }
}
