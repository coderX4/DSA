package Learning;

public class Stack_using_Queue {

    private Queue q1 = new Queue();
    private Queue q2 = new Queue();
    private int currSize;

    public Stack_using_Queue() {
        currSize = 0;
    }

    public void push(int x) {

        // Push x first in empty q2
        if(currSize == 0){
            currSize++;
            q1.Push(x);
            return;
        }
        else{
            while (q1.Size() != 0) {
                q2.Push(q1.Pop());
            }
            q1.Push(x);
            currSize++;
            while (q2.Size() != 0) {
                q1.Push(q2.Pop());
            }
        }

    }

    public int pop() {
        // if no elements are there in q1
        if (q1.Size() == 0) {
            return -1;
        }
        currSize--;
        return q1.Pop();
    }

    public int top() {
        if (q1.Size() == 0) {
            return -1;
        }
        return q1.Peek();
    }

    public int size() {
        return currSize;
    }

    public static void main(String[] args) {
        Stack_using_Queue s = new Stack_using_Queue();

        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Top element: " + s.top());  // Output: 30
        System.out.println("Size: " + s.size());  // Output: 3
        System.out.println("Popped element: " + s.pop());  // Output: 30
        System.out.println("Top element: " + s.top());  // Output: 20
        System.out.println("Size: " + s.size());  // Output: 2
    }

}

