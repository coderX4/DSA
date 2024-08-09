package Doubly_Linked_List;

public class InsertionDLL {
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

    public static Node Insert_head(Node head,int val){
        if(head == null){
            return new Node(val);
        }
        Node front = new Node(val,head,null);
        head.back = front;
        return front;
    }

    public static Node Insert_tail(Node head,int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node front = new Node(val,null,temp);
        temp.next = front;
        return head;
    }

    public static Node Insert_before_k(Node head,int k,int val){
        if (k==1) {
            return Insert_head(head, val);
        }
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node x = new Node(val,temp,prev);
        prev.next = x;
        temp.back = x;
        return head;
    }

    public static Node Insert_before_value(Node head,int value,int el){
        if (head.data == value) {
            return Insert_head(head, el);
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == value){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node x = new Node(el,temp,prev);
        prev.next = x;
        temp.back = x;
        return head;
    }

    public static void main(String[] args) {
        int[] A = {3,5,7,9};
        Node head = ConvertArray2DLL(A);
        head = Insert_before_value(head,3,70);
        Traversal_in_DLL(head);
    }
}
