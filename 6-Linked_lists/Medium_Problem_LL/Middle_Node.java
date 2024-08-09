package Medium_Problem_LL;

public class Middle_Node {

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
        Node fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] A = {1,5,9,4,7};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        Node res = Middle(head1);
        System.out.println(res.data);
    }
}
