package Medium_Problem_LL;

public class Palindrome_LL {
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

    public static  String Palindrome(Node head){

        if(head == null || head.next == null){
            return "True";
        }
        //find the middle
        Node slow = head;
        Node fast = head.next.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        //Now the reversal of middle half
        Node newhead = Reverse_LL(slow.next);
        //now the compairision of elements
        Node first = head;
        Node second = newhead;
        while(second != null){
            if(first.data != second.data){
                return "False";
            }
            first = first.next;
            second = second.next;
        }
        return "True";
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        String res = Palindrome(head1);
        System.out.println(res);
    }

}
