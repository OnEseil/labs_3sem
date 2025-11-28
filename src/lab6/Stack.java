package lab6;

public class Stack <T>{
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T item){
        if (size == data.length) throw new ArrayIndexOutOfBoundsException("Stack is full");
        data[size++] = item;
    }

    public T pop(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        T element = data[size - 1];
        data[--size] = null;
        return element;
    }

    public T peek(){
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }

    public static void main(String[] args) {
        Stack< Integer> stack = new Stack<>(10);
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
