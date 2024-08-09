package Medium_Problem_LL;

public class Sorting_LL {

    public static Node ConvertArray2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void Traversal_in_LL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node Middle(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node MergeNode(Node left,Node right){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(left != null && right != null){
            if(left.data < right.data){
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else{
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        if(left != null){
            temp.next = left;
        }
        else{
            temp.next = right;
        }
        return dummy.next;
    }

    public static Node SortLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node middle = Middle(head);
        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = SortLL(left);
        right = SortLL(right);

        return MergeNode(left,right);
    }

    public static void main(String[] args) {
        int[] A = {1,5,9,4,7};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        Node head2 = SortLL(head1);
        Traversal_in_LL(head2);
    }
}
