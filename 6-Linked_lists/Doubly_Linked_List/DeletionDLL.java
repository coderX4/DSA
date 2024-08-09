package Doubly_Linked_List;

public class DeletionDLL {
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

    public static Node Delete_head(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }
    public static Node Delete_tail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        tail.back = null;
        prev.next = null;
        return head;
    }
    public static Node Delete_K(Node head,int k) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;
        if (prev == null && front == null) {
            return null;
        }
        else if(prev == null){
            head = Delete_head(head);
            return head;
        }
        else if(front == null){
            head = Delete_tail(head);
            return head;
        }
        else{
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
            return head;
        }
    }

    public static Node Delete_value(Node head,int val) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == val) {
                break;
            }
            temp = temp.next;
        }
        //this if becz if data is not present then what will it do
        //it was pointing to tail and deleting it
        //so after while loop again check if temp is pointing to result node or not

        if(temp.data == val) {
            Node prev = temp.back;
            Node front = temp.next;
            if (prev == null && front == null) {
                return null;
            } else if (prev == null) {
                head = Delete_head(head);
                return head;
            } else if (front == null) {
                head = Delete_tail(head);
                return head;
            } else {
                prev.next = front;
                front.back = prev;
                temp.next = null;
                temp.back = null;
                return head;
            }
        }
        else{
            return head;
        }
    }
    public static void main(String[] args) {
        int[] A = {3,5,7,9};
        Node head = ConvertArray2DLL(A);
        head = Delete_value(head,8);
        Traversal_in_DLL(head);
    }
}
