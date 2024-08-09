package Medium_Problem_LL;

public class Reversal_LL {

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
    public static Node Reverse_LL(Node head){
        Node temp = head;
        Node prev = null;

        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev; 
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 7, 9, 12, 56, 76};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        Node head = Reverse_LL(head1);
        Traversal_in_LL(head);
    }
}
