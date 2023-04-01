/**
 * Implementation of an array-backed queue.
 *
 * @author Hardik Sangwan
 * @version 1.69
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int back;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
        front = 0;
        back = 0;
    }

    /**
     * Dequeue from the front of the queue.
     *
     * Do not shrink the backing array.
     * If the queue becomes empty as a result of this call, you must not
     * explicitly reset front or back to 0.
     *
     * @see QueueInterface#dequeue()
     */
    @Override
    public T dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        } 
        T removed = backingArray[front];
        backingArray[front] = null;
        size--;
        front = (front + 1) % backingArray.length;
        back = (front + size) % backingArray.length;
        return removed;
    }

    /**
     * Add the given data to the queue.
     *
     * If sufficient space is not available in the backing array, you should
     * regrow it to (double the current length) + 1; in essence, 2n + 1, where n
     * is the current capacity. If a regrow is necessary, you should copy
     * elements to the front of the new array and reset front to 0.
     *
     * @see QueueInterface#enqueue(T)
     */
    @Override
    public void enqueue(T data) {
        if (item == null) {
            throw new IllegalArgumentException("Data is Null");
        } 
        if (size >= backingArray.length) {
            T[] tempArray = (T[]) (new Object[(backingArray.length * 2) + 1]);
            for (int i = 0; i <= backingArray.length; i++) {
                tempArray[i] = backingArray[(front + i) % size];
            }
            backingArray = tempArray;
            front = 0;
        }
        back = size;
        backingArray[back] = data;
        size++;
        back = size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY!
        return backingArray;
    }
}