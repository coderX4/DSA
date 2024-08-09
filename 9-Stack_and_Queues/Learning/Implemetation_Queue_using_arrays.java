package Learning;

public class Implemetation_Queue_using_arrays {
    public static void main(String[] args) {
        Queue qu = new Queue ();

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
        qu.Pop();

        System.out.println(qu.Peek());

        qu.Pop();

        System.out.println(qu.Peek());

    }
}
