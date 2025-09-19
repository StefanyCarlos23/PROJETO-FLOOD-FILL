public class Stack {
    private Pixel[] data;
    private int top;

    public Stack(int capacity) {
        data = new Pixel[capacity];
        top = -1;
    }

    public void push(Pixel p) {
        if (top < data.length - 1) {
            data[++top] = p;
        }
    }

    public Pixel pop() {
        if (!isEmpty()) {
            return data[top--];
        }
        return null;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}