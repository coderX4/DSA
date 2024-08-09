package Medium_Problem_LL;

public class Find_Intersectionpt {

    public static void Traversal_in_LL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node Point(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node t1 = head1;
        Node t2 = head2;

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2){
                return t1;
            }

            if(t1 == null){
                t1 = head2;
            }
            if(t2 == null){
                t2 = head1;
            }

        }
        return t1;
    }

    public static void main(String[] args) {

        //First LL
        Node head1 = new Node(3);
        Node h11 = new Node(1);
        head1.next = h11;
        Node h12 = new Node(4);
        h11.next = h12;
        Node h13 = new Node(6);
        h12.next = h13;
        Node h14 = new Node(2);
        h13.next = h14;

        Traversal_in_LL(head1);
        System.out.println();

        //second LL
        Node head2 = new Node(1);
        Node h21 = new Node(2);
        head2.next = h21;
        Node h22 = new Node(4);
        h21.next = h22;
        Node h23 = new Node(5);
        h22.next = h23;
        h23.next = h12;
        Traversal_in_LL(head2);

        System.out.println("Result: ");
        Node res = Point(head1,head2);
        System.out.println(res.data);
    }
}
