package Medium;

public class Maximum_Path_sum {
    static int Sum(Node root){
        int[] sum = new int[1];
        Height(root,sum);
        return sum[0];
    }
    static int Height(Node root,int[] maxi){
        if(root == null){
            return 0;
        }
        int lh = Height(root.left,maxi);
        int rh = Height(root.right,maxi);
        maxi[0 ] = Math.max(maxi[0],(lh+rh+root.data));
        return (root.data + Math.max(lh,rh));
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        Node c1 = new Node(9);
        Node c2 = new Node(20);
        root.left = c1;
        root.right = c2;


        Node c21 = new Node(15);
        Node c22 = new Node(7);
        c2.left = c21;
        c2.right = c22;

        System.out.println("Maximum Path Sum : " + Sum(root));
    }
}
