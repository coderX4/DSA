package Learning;

public class Stack_using_LL {

    public Node head;
    int cursize = 0;
    public void Push(int data){
        if(cursize == 0){
             head = new Node(data);
             cursize++;
        }
        else{
            cursize++;
            Node x = new Node(data);
            x.next = head;
            head = x;
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
        Stack_using_LL st = new Stack_using_LL();

        st.Push(10);
        st.Push(20);
        st.Push(30);
        st.Push(40);

        System.out.println(st.Size());

        //Peek or top element
        System.out.println(st.Peek());

        //Pop or removal
        st.Pop();
        System.out.println("New Top: " + st.Peek());

    }
}
