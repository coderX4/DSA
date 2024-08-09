package Medium;
import java.util.*;

class Pair{
    Node node;
    int line;

    Pair(Node node,int line){
        this.node = node;
        this.line = line;
    }
}
public class Bottom_View {
    static List<Integer> bottomView(Node root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if(root == null) {
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair(root, 0));

        // BFS traversal
        while(!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.line;

            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.data);

            // Process left child
            if(node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair(node.left, line - 1));
            }

            // Process right child
            if(node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair(node.right, line + 1));
            }
        }

        // Transfer values from the
        // map to the result list
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root =  new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);

        // Get the Bottom View traversal
        List<Integer> bottomView = bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for(int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}
