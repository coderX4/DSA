package Linked_lists_1D;

public class LinkedList1 {
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

    public static void Find_lenght_LL(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            cnt++;
        }
        System.out.println(cnt);
    }

    public static String Search_in_LL(Node head,int target){
        Node temp = head;
        while(temp != null){
            if(temp.data == target){
                return "Yes";
            }
            temp = temp.next;
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] A = {3,5,7,9};
        Node head = ConvertArray2LL(A);
        System.out.println(head.data);
        Traversal_in_LL(head);
        System.out.println();
        Find_lenght_LL(head);
        System.out.println(Search_in_LL(head,5));
    }
}
