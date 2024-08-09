import Medium.Node;

public class Delete_Node_BST {

    static void Inorder(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        Inorder(temp.left);
        System.out.print(temp.data + " ");
        Inorder(temp.right);
    }
    static Node Delete_Bst(Node root, int val){
        Node temp = root;
        Node pre = root;
        while(temp != null){
            if(temp.data == val){
                //No child
                if(temp.left == null && temp.right == null){
                    if(pre.left.data == temp.data){
                        pre.left = null;
                    }
                    else{
                        pre.right = null;
                    }
                    return root;
                }
                //2 child
                else if (temp.left != null && temp.right != null) {
                    Node x = pre.left.left;
                    pre.left = pre.left.left;
                    while(x.right != null){
                        x = x.right;
                    }
                    x.right = temp.right;
                    return root;
                }
                //one child
                else {
                    if(temp.left != null){
                        if(temp.left.data <= pre.data){
                            pre.left = temp.left;
                        }
                        else{
                            pre.right = temp.left;
                        }
                    }
                    else{
                        if(temp.right.data <= pre.data){
                            pre.left = temp.right;
                        }
                        else{
                            pre.right = temp.right;
                        }
                    }
                }
                return root;
            } else if (val < temp.data) {
                pre = temp;
                temp = temp.left;
            }
            else{
                pre = temp;
                temp = temp.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root =  new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        //root.left.right = new Node(7);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        //root.left.right.left = new Node(6);
        root.right.right.left = new Node(13);

        Inorder(root);
        System.out.println();

        root = Delete_Bst(root,5);
        Inorder(root);

    }
}
