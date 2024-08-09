package Learning;

public class Queue {
    public int[] arr1 = new int[10000];
    public int front = -1;
    public int rear = -1;

    public void Push(int data) {
        if (front == -1) {
            front = 0;
            rear = 0;
            arr1[front] = data;
        } else {
            rear = rear + 1;
            arr1[rear] = data;
        }
    }

    public int Pop() {
        int x = arr1[front];
        //System.out.println("Deleted element: " + arr1[front]);
        front = front + 1;
        return x;
    }

    public int Size() {
        return (rear - front + 1);
    }

    public int Peek() {
        return arr1[front];
    }
}
