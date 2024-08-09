package Doubly_Linked_List;

public class DoublyList1 {
    public static Node ConvertArray2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1;i< arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void Traversal_in_DLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node Reversal_DLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node last = null;
        while(current != null){
            last = current.back;
            current.back = current.next;
            current.next = last;
            current = current.back;
        }
        return last.back;
    }
    public static void main(String[] args) {
        int[] A = {3,5,7,9};
        Node head = ConvertArray2DLL(A);
        head = Reversal_DLL(head);
        Traversal_in_DLL(head);
        System.out.println();
    }
}
