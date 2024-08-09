package Medium_Problem_LL;

public class Detect_Loop {

    public static void Traversal_in_LL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static String Detect(Node head){
        if(head == null || head.next == null){
            return "False";
        }
        int cnt = 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            cnt++;
            if(slow == fast){
                System.out.println(cnt);
                return "True";
            }
        }
        return "False";
    }

    public static void main(String[] args) {

        //First LL
        Node head1 = new Node(1);
        Node h11 = new Node(2);
        head1.next = h11;
        Node h12 = new Node(3);
        h11.next = h12;
        Node h13 = new Node(4);
        h12.next = h13;
        Node h14 = new Node(5);
        h13.next = h14;
        Node h16 = new Node(6);
        h14.next = h16;
        Node h17 = new Node(7);
        h16.next = h17;
        Node h18 = new Node(8);
        h17.next = h18;

        h18.next = h12;
        //Traversal_in_LL(head1);

        System.out.println("Result: ");
        String res = Detect(head1);
        System.out.println(res);
    }
}
