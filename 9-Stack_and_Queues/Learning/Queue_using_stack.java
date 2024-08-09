package Learning;

public class Queue_using_stack {

    private Stack st1 = new Stack();

    private Stack st2 = new Stack();
    public void Push(int data){
        st1.Push(data);
    }

    public int Pop(){
        while(st1.Size() != 0){
            st2.Push(st1.Pop());
        }
        int x  = st2.Pop();
        while(st2.Size() != 0){
            st1.Push(st2.Pop());
        }
        return x;
    }

    public int Peek(){
        while(st1.Size() != 0){
            st2.Push(st1.Pop());
        }
        int x  = st2.Peek();
        while(st2.Size() != 0){
            st1.Push(st2.Pop());
        }
        return x;
    }

    public int Size(){
        return st1.Size();
    }

    public static void main(String[] args) {
        Queue_using_stack qu = new Queue_using_stack();

        //insertion
        qu.Push(1);
        qu.Push(2);
        qu.Push(3);
        qu.Push(4);
        qu.Push(5);

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
