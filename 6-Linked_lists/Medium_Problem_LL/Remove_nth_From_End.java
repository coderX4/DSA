package Medium_Problem_LL;

public class Remove_nth_From_End {
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

    public static Node Remove_nth(Node head,int n) {
        Node last = head;
        for(int i= 0;i<n;i++){
            last = last.next;
        }
        Node start = head;
        while(last.next != null){
            start = start.next;
            last = last.next;
        }
        if(last == null){
            return head.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 7, 9, 12, 56, 76};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        Node head = Remove_nth(head1,2);
        Traversal_in_LL(head);
    }
}
