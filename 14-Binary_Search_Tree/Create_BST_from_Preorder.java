import Traversals.Node;

public class Create_BST_from_Preorder {
    static Node BST_from_Preorder(int[] arr,int ub,int[] i){
        if(i[0] == arr.length || arr[i[0]] > ub){
            return null;
        }
        Node root = new Node(arr[i[0]++]);
        root.left = BST_from_Preorder(arr, root.data, i);
        root.right = BST_from_Preorder(arr,ub,i);
        return root;
    }

    static void Preorder(Node root){
        Node temp = root;
        if (temp == null) {
            return;
        }
        System.out.print(temp.data + " ");
        Preorder(temp.left);
        Preorder(temp.right);
    }

    public static void main(String[] args) {
        int[] arr = {8,5,1,7,10,12};
        Node root = BST_from_Preorder(arr,Integer.MAX_VALUE,new int[]{0});
        //Treee is in preorder
        Preorder(root);
    }
}
