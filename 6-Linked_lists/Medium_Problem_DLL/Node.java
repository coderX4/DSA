package Medium_Problem_DLL;
public class Node {
    public int data;
    public Node next;
    public Node back;

    public Node(int data1, Node next, Node back){
        this.data = data1;
        this.next = next;
        this.back = back;
    }
    public Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
