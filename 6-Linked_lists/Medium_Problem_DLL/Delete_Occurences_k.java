package Medium_Problem_DLL;

public class Delete_Occurences_k {

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
    public static Node Delete_k(Node head, int k){
        Node temp = head;
        while(temp != null){
            if(temp.data == k){
                if(temp == head){
                    head = temp.next;
                }
                Node nextnode = temp.next;
                Node prevnode = temp.back;
                if(nextnode != null){
                    nextnode.back = prevnode;
                }
                if(prevnode != null){
                    prevnode.next = nextnode;
                }
                temp = nextnode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int[] A = {3,5,7,9,3,7,9,3,6,3};
        int k = 3;
        Node head = ConvertArray2DLL(A);
        head = Delete_k(head,k);
        Traversal_in_DLL(head);
        System.out.println();
    }
}
