package Linked_lists_1D;

public class InsertionLL {
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

    public static Node Insert_head(Node head,int data1){
        Node temp = new Node(data1,head);
        return temp;
    }

    public static Node Insert_tail(Node head,int data1){
        if(head == null){
            return new Node(data1);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node last_el = new Node(data1);
        temp.next = last_el;
        return head;
    }

    public static Node Insert_at_k(Node head,int data1,int k){
        if(head == null){
            if(k==1){
                return new Node(data1);
            }
            else {return head;}
        }
        if(k == 1){
            Node temp = new Node(data1,head);
            return temp;
        }
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k-1){
                Node x = new Node(data1,temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node Insert_Before_val(Node head,int data1,int val){
        if(head == null){
            return null;
        }
        if(head.data == val){
            Node temp = new Node(data1,head);
            return temp;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == val){
                Node x = new Node(data1,temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] A = {12,5,8,10};
        Node head = ConvertArray2LL(A);
        head = Insert_Before_val(head,20,10);
        printLL(head);
    }
}
