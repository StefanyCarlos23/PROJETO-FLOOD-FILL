public class Queue {
    private Pixel[] data;
    private int front, rear, size;

    public Queue(int capacity) {
        data = new Pixel[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Pixel p) {
        if (size < data.length) {
            rear = (rear + 1) % data.length;
            data[rear] = p;
            size++;
        }
    }

    public Pixel dequeue() {
        if (!isEmpty()) {
            Pixel p = data[front];
            front = (front + 1) % data.length;
            size--;
            return p;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}