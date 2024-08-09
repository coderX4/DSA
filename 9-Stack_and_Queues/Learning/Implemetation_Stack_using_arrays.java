package Learning;

public class Implemetation_Stack_using_arrays {
    public static void main(String[] args) {
        Stack st = new Stack();

        //insertion
        st.Push(1);
        st.Push(2);
        st.Push(3);
        st.Push(4);

        //Size of stack
        System.out.println(st.Size());

        //Peek or top element
        System.out.println(st.Peek());

        //Pop or removal
        st.Pop();
        System.out.println("New Top: " + st.Peek());
    }
}
