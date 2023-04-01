/**
 * Your implementation of a Queue backed by an array.
 *
 * @author Nikhil Dhanda
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    
    // Do not add instance variables.
    private T[] backingArray;
    private int size;
    private int front;
    private int back;

    /**
     * Construct a Queue with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * Use Constructor Chaining
     */
    public ArrayQueue() {
        this(INITIAL_CAPACITY);

    }

    /**
     * Construct a Queue with the specified initial capacity of
     * {@code initialCapacity}.
     * @param initialCapacity Initial capacity of the backing array.
     */
    public ArrayQueue(int initialCapacity) {
        backingArray = (T[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("The provided data is null");
        } 
        if (size >= backingArray.length) {
            T[] tempArray = (T[]) (new Object[backingArray.length * 2]);
            for (int i = 0; i <= backingArray.length; i++) {
                tempArray[i] = backingArray[(front + i) % size];
            }
            backingArray = tempArray;
            front = 0;
            back = size;
        }
        back = (front + size) % backingArray.length;
        backingArray[back] = item;
        size++;
        back = (front + size) % backingArray.length;


    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        } 
        T tempObj = backingArray[front];
        backingArray[front] = null;
        size--;
        front = (front + 1) % backingArray.length;
        back = (front + size) % backingArray.length;
        return tempObj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Used for testing your code.
     * DO NOT USE THIS METHOD!
     *
     * @return the backing array of this queue.
     */
    public Object[] getBackingArray() {
        return backingArray;
    }

}
