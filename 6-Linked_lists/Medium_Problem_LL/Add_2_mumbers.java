package Medium_Problem_LL;
public class Add_2_mumbers {
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

        public static Node Add_LL(Node head1,Node head2){
            Node dummy = new Node(-1);
            int carry = 0, sum = 0;
            Node t1 = head1;
            Node t2 = head2;
            Node curr = dummy;
            while(t1 != null || t2 != null){
                sum = carry;
                if(t1 != null){
                    sum += t1.data;
                    t1 = t1.next;
                }
                if(t2 != null){
                    sum += t2.data;
                    t2 = t2.next;
                }
                Node x = new Node (sum % 10);
                carry = sum / 10;

                curr.next = x;
                curr = curr.next;
            }
            if(carry != 0){
                Node x = new Node(carry);
                curr.next = x;
            }
            return dummy.next;
        }

        public static void main(String[] args) {
            int[] A = {3,5};
            Node head1 = ConvertArray2LL(A);
            Traversal_in_LL(head1);
            System.out.println();
            int[] B = {4,5,9,9};
            Node head2 = ConvertArray2LL(B);
            Traversal_in_LL(head2);
            System.out.println();
            Node headans = Add_LL(head1,head2);
            Traversal_in_LL(headans);
        }
}

