package Medium_Problem_DLL;


import java.util.ArrayList;
import java.util.Map;

public class Find_pairs_with_sum {
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

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int k = 5;
        ArrayList<String> ans = new ArrayList<>();
        Node head = ConvertArray2DLL(A);
        ans = Find_pair(head,k);
        System.out.println(ans);
        System.out.println();
    }

    public static  ArrayList<String> Find_pair(Node head, int sum){
        Node left = head;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node right = temp;

        ArrayList<String> ans = new ArrayList<>();

        while(left.data < right.data){
            if(left.data + right.data == sum){
                String a = String.valueOf(left.data);
                String b = String.valueOf(right.data);
                String c = "( "+ a + ", " + b+ ")";
                ans.add(c);

                left = left.next;
                right = right.back;
            }
            else if (left.data + right.data < sum) {
                left = left.next;
            }
            else{
                right = right.back;
            }
        }
        return ans;
    }
}
