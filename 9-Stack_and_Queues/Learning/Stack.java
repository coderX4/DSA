package Learning;

public class Stack{

    public int[] arr = new int[10000];
    public int top = -1;
    public void Push(int data){
        top = top + 1;
        arr[top] = data;
    }

    public int Pop(){
        int x = arr[top];
        top = top - 1;
        return x;
    }

    public int Peek(){
        if(top != -1){
            return arr[top];
        }
        return top;
    }

    public int Size(){
        return top + 1;
    }
}
