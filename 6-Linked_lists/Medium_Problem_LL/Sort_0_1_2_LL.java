package Medium_Problem_LL;

public class Sort_0_1_2_LL {
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

    public static Node Sort_0_1_2(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node zerohead = new Node(-1);
        Node onehead = new Node(-1);
        Node twohead = new Node(-1);

        Node zero = zerohead;
        Node one = onehead;
        Node two = twohead;

        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = onehead.next;
        one.next = twohead.next;
        two.next = null;

        return zerohead.next;
    }
    public static void main(String[] args) {
        int[] A = {1,1,0,2,0,1,1,0,0,2};
        Node head1 = ConvertArray2LL(A);
        Traversal_in_LL(head1);
        System.out.println();
        Node newhead = Sort_0_1_2(head1);
        Traversal_in_LL(newhead);
    }
}
