package Linked_lists_1D;

public class DeletionLL {
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
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node Deletehead(Node head){
        if(head == null)
            return head;
        Node temp = head;
        head = head.next;
        return head;
    }

    public static Node Deletetail(Node head){
        if(head == null || head.next == null)
            return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node Delete_K_El(Node head, int k){
        if(head == null)
            return head;
        if(k == 1){
            Node temp = head;
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node Delete_value(Node head, int el){
        if(head == null)
            return head;
        if(head.data == el){
            Node temp = head;
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == el){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args) {
        int[] A = {12,5,8,10};
        Node head = ConvertArray2LL(A);
        head = Delete_value(head,8);
        printLL(head);
    }
}
