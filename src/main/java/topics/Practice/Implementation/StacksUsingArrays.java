package topics.Practice.Implementation;

public class StacksUsingArrays {
    int capacity;
    int top;
    int[] stack;

    public StacksUsingArrays(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[capacity];
    }

    void push(int n) {
        top++;
        if(top >= capacity) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[top] = n;
    }

    int pop() {
        if(top < 0) {
            System.out.println("Stack underflow");
        }
        int poppedNum = stack[top];
        top--;
        return poppedNum;
    }

    int peek() {
        return stack[top];
    }

    public static void main(String[] args) {
        StacksUsingArrays stacksUsingArrays = new StacksUsingArrays(5);
        stacksUsingArrays.push(1);
        stacksUsingArrays.push(2);
        stacksUsingArrays.peek();
        stacksUsingArrays.push(3);
        stacksUsingArrays.push(4);
        stacksUsingArrays.push(5);
        stacksUsingArrays.peek();
        stacksUsingArrays.push(6);
        System.out.println(stacksUsingArrays.peek());
    }
}
