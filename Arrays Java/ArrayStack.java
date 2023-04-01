/**
 * Your implementation of a Stack backed by an array.
 *
 * @author Nikhil Dhanda
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {
    // Do not add any new instance variables!
    private T[] backingArray;
    private int size;

    /**
     * Construct a Stack with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * Use constructor chaining.
     */
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Construct a Stack with the specified initial capacity of
     * {@code initialCapacity}.
     * @param initialCapacity Initial capacity of the backing array.
     */
    public ArrayStack(int initialCapacity) {
        backingArray = (T[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
    }

    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("The provided data is null");
        }
        try {
            backingArray[size] = item;
            size++;

        } catch (ArrayIndexOutOfBoundsException e) {
            int lengthTemp = backingArray.length * 2;
            T[] tempArray = (T[]) (new Object[lengthTemp]);
            for (int i = 0; i <= size; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
            backingArray[size] = item;
            size++;
        }
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The stack is empty");
        }
        size--;
        T object = backingArray[size];
        backingArray[size] = null;
        return object;
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
