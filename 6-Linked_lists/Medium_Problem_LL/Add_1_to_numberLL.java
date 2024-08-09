package Medium_Problem_LL;

public class Add_1_to_numberLL {
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

    public static Node NewLLAfter_ADD_1(Node head){
        Node temp = Reverse_LL(head);
        Node temp1 = temp;
        int carry = 1;
        while(temp != null){
            temp.data = temp.data + carry;
            if (temp.data < 10){
                carry = 0;
                break;
            }
            else{
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if(carry == 1){
            Node x = new Node(1);
            temp.next = x;

        }

        head = Reverse_LL(temp1);
        return head;
    }

    public static int helper(Node temp){
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if(temp.data < 10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    public static Node Recursive_approach(Node head){
        Node temp = head;
        int carry = helper(temp);
        if(carry == 1){
            Node x = new Node(1);
            x.next = head;
            head = x;
            return head;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] A = {1,5,9};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println("Result: ");
        Node head = Recursive_approach(head1);
        Traversal_in_LL(head);
    }

}
