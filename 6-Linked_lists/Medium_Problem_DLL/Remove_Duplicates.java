package Medium_Problem_DLL;

import java.util.ArrayList;

public class Remove_Duplicates {

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

    public static Node Remove_duplicate(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            Node nextnode = temp.next;
            while(nextnode != null && nextnode.data == temp.data){
                nextnode = nextnode.next;
            }
            temp.next = nextnode;
            nextnode.back = temp;

            temp = temp.next;

        }
        return head;
    }
    public static void main(String[] args) {
        int[] A = {1,1,1,1,2,2,3,3,3,4,5,6,6,6,7};
        int k = 3;
        Node head = ConvertArray2DLL(A);
        head = Remove_duplicate(head);
        Traversal_in_DLL(head);
        System.out.println();
    }
}
