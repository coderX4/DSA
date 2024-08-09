package Medium_Problem_LL;

public class Odd_Even_LL {
    public static Node ConvertArray2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void Traversal_in_LL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node Odd_Even(Node head) {
        Node odd = head ;
        Node even = head.next;
        Node evenhead = head.next;
        if(head == null || head.next == null){
            return head;
        }
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
    public static void main(String[] args) {
        int[] A = {3,5,7,9,12,56,76};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println();
        Node head = Odd_Even(head1);
        Traversal_in_LL(head);
    }
}
