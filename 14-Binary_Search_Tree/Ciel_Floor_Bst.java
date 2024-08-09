import Medium.Node;

public class Ciel_Floor_Bst {
    static int Ciel_Val(Node root,int key){
        Node temp = root;
        int ciel = -1;
        while(temp != null){
            if(temp.data == key){
                ciel = temp.data;
                return ciel;
            }
            if(key < temp.data){
                ciel = temp.data;
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return ciel;
    }

    static int Floor_Val(Node root,int key){
        Node temp = root;
        int floor = Integer.MAX_VALUE;
        while(temp != null){
            if(temp.data == key){
                floor = temp.data;
                return floor;
            }
            if(key < temp.data){
                temp = temp.left;
            }
            else{
                floor = temp.data;
                temp = temp.right;
            }
        }
        return floor;
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

        int ans = Ciel_Val(root,11);
        System.out.println("Ciel: "+ans);

        ans = Floor_Val
                (root,11);
        System.out.println("Floor: "+ans);
    }
}
