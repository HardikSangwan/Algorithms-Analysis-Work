
public class ArrayStack<T> {
    //one letter reprenting the type parameter
    
    
    private T[] elements;
    public static final int DEFAULT_CAPACITY = 10;
    private int top;
    
    public ArrayStack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Stack capacity must be > 0");
        
        elements = (T[])new Object[capacity];
        top = -1;
    }
    
    public ArrayStack() {
        //elements = new Object[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY);  //use chaining
        //top = -1;
    }
    
    
    public void push(T value) {
        if (top == elements.length - 1) {
            //We can throw an exception as below:
            throw new StackException("Stack is full!");
            /*or increase the array size as below...
             
             int newSize = elements.length * 2;
             elements = Arrays.copyOf(elements, newSize);
             */
        }
        top++;
        elements[top] = value;
        
    }
    
    public T pop() {
        if (top == -1)
            throw new StackException("Stack is empty!");
        
        T popped = elements[top];
        elements[top] = null;
        top--;
        return popped;
        
    }
    
    public T peek() {
        if (top == -1) 
            throw new StackException("Stack is empty!");
        return elements[top];
    }
    
    public static void main(String[] args) {
        ArrayStack<Double> x = new ArrayStack<Double>();
        x.pop();
    }
}
