import Medium.Node;

public class Search_in_BST {
    static Node Search(Node root,int val){
        Node temp = root;
        while(temp != null){
            if(temp.data == val){
                return temp;
            } else if (val < temp.data) {
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root =  new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(13);

        Node ans = Search(root,10);
        System.out.println(ans.data);
    }
}
