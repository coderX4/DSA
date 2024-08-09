package Learning;

public class ImplementMinStack {
    public int minele;
    static Stack st = new Stack();

    public void Push(int data){
        if(st.Size() == 0){
            minele = data;
            st.Push(data);
        }
        else{
            if(data < minele){
                st.Push(2*data - minele);
                minele = data;
            }
            else{
                st.Push(data);
            }
        }
    }
    public int Pop(){
        if(st.Size() == 0){
            System.out.println("Stack Empty");
            return st.Size();
        }
        else{
            int x = st.Pop();
            if(x < minele){
                int d = minele;
                minele = 2*minele - x;
                return d;
            }
            else{
                return x;
            }
        }
    }

    public void getMinele(){
        System.out.println("Minimum element: "+ minele);
    }

    public void Peek()
    {
        if (st.Size() == 0) {
            System.out.println("Stack is empty ");
            return;
        }

        Integer t = st.Peek(); // Top element.

        System.out.print("Top Most Element is: ");

        // If t < minEle means minEle stores
        // value of t.
        if (t < minele){
            System.out.println(minele);
        }
        else
            System.out.println(t);
    }

    public static void main(String[] args) {
        ImplementMinStack st = new ImplementMinStack();

        st.Push(-2);
        st.Push(0);
        st.Push(-3);

        st.getMinele();

        int e = st.Pop();
        System.out.println("Deleted element: "+e);

        st.Peek();

        st.getMinele();

    }
}
