/**
 * Your implementation of a max heap.
 *
 * @author Hardik Sangwan
 * @version 1.11
 */
public class MaxHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a Heap with an initial size of {@code STARTING_SIZE}.
     *
     * Use the constant field in the interface. Do not use magic numbers!
     */

    public MaxHeap() {
        backingArray = (T[]) new Comparable[STARTING_SIZE];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (size < (backingArray.length - 1)) {
            backingArray[size + 1] = item;
            size++;
            upHeap();
        } else {
            T[] tempArray = (T[]) new Comparable[backingArray.length * 2];
            for (int i = 1; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
            backingArray[size + 1] = item;
            size++;
            upHeap();
        }
    }

    /**
    * Helper method for Adding to the heap
    */
    private void upHeap() {
        int i = size;
        while (i > 1) {
            T tempObj = backingArray[i / 2];
            if (backingArray[i / 2].compareTo(backingArray[i]) < 0) {
                backingArray[i / 2] = backingArray[i];
                backingArray[i] = tempObj;
            }
            i = i / 2;
        }
    }

    @Override
    public T remove() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        T tempObject = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        downHeap();
        return tempObject;
    }

    /**
    * Helper method for Removing an item from the heap
    */
    private void downHeap() {
        int i = 1;
        while (i <= size / 2) {
            if (backingArray[2 * i] != null) {
                if (backingArray[(2 * i) + 1] != null && backingArray[2 * i]
                    .compareTo(backingArray[(2 * i) + 1]) < 0) {
                    if (backingArray[(2 * i) + 1]
                        .compareTo(backingArray[i]) > 0) {
                        T tempObj = backingArray[(2 * i) + 1];
                        backingArray[(2 * i) + 1] = backingArray[i];
                        backingArray[i] = tempObj;
                        i = (2 * i) + 1;
                    } else {
                        i = size;
                    }
                } else {
                    if (backingArray[2 * i].compareTo(backingArray[i]) > 0) {
                        T tempObj = backingArray[2 * i];
                        backingArray[2 * i] = backingArray[i];
                        backingArray[i] = tempObj;
                        i = 2 * i;
                    } else {
                        i = size;
                    }
                }

            } else {
                i = size;
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        backingArray = (T[]) new Comparable[STARTING_SIZE];
        size = 0;
    }

    @Override
    public Comparable[] getBackingArray() {
        // DO NOT CHANGE THIS METHOD!
        return backingArray;
    }

}