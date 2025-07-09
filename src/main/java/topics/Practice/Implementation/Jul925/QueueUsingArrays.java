package topics.Practice.Implementation.Jul925;

public class QueueUsingArrays {
    int top;
    int bottom;
    int capacity;
    int[] queue;

    public QueueUsingArrays(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        top = -1;
        bottom = 0;
    }

    void add(int n) {
        top++;
        if(top >= capacity) {
            System.out.println("Overflow");
            return;
        }
        queue[top] = n;
    }

    int poll() {
        if(bottom > top) {
            System.out.println("Underflow");
            return -1;
        }
        int polledElement = queue[bottom];
        bottom++;
        return polledElement;
    }

    int peek() {
        if(bottom > top) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[top];
    }

    public static void main(String[] args) {
        QueueUsingArrays queueUsingArrays = new QueueUsingArrays(5);
        queueUsingArrays.add(3);
        queueUsingArrays.peek();
        queueUsingArrays.add(5);
        queueUsingArrays.add(8);
        System.out.println(queueUsingArrays.poll());
        System.out.println(queueUsingArrays.peek());
    }
}
