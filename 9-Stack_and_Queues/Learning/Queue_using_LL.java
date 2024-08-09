package Learning;

public class Queue_using_LL {
    int cursize = 0;
    public Node head;
    public void Push(int data){
        if(cursize == 0){
            cursize++;
            head = new Node(data);
        }
        else{
            cursize++;
            Node temp = head;
            while(temp.next != null){
                temp  = temp.next;
            }
            Node x = new Node(data);
            temp.next = x;
        }
    }

    public int Pop(){
        Node temp = head;
        head = temp.next;
        cursize--;
        return temp.data;
    }

    public int Size(){
        return cursize;
    }

    public int Peek(){
        return head.data;
    }

    public static void main(String[] args) {
        Queue_using_LL qu = new Queue_using_LL();

        //insertion
        qu.Push(10);
        qu.Push(20);
        qu.Push(30);
        qu.Push(40);
        qu.Push(50);

        //Size of stack
        System.out.println(qu.Size());

        //Peek or top element
        System.out.println(qu.Peek());

        //Pop or removal
        int e = qu.Pop();
        System.out.println("Deleted element: " + e);

        System.out.println(qu.Peek());

        e = qu.Pop();
        System.out.println("Deleted element: " + e);

        System.out.println(qu.Peek());

    }

}
