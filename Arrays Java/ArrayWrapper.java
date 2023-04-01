/**
 * This class defines things that simple collections can do.
 * @author Hardik Sangwan
 * @version 2.71
 * @param <T> The type to be stored within the ArrayWrapper.
 */
public class ArrayWrapper<T> implements SimpleCollection<T> {
    private T[] backingarray;

    /**
     * Creates a default backingarray of type T with length 5
     */

    public ArrayWrapper() {
        backingarray = (T[]) new Object[5];
    }

    /**
     * Creates a backingarray from an array of given elements
     * If the length of the given array exceeds the size of the backing array,
     * the array is resized
     *
     * @param elems The elements that the array is created from
     */

    public ArrayWrapper(T[] elems) {
        if (elems.length > backingarray.length) {
            T[] temp = (T[]) new Object[backingarray.length * 2];
            backingarray = temp;
        }
        int i = 0;
        for (T elem : elems) {
            backingarray[i] = elem;
            i++;
        }
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */

    public void add(T elem) {
        if (backingarray[backingarray.length - 1] != null) {
            T[] temp = (T[]) new Object[backingarray.length * 2];
            for (int j = 0; j < backingarray.length; j++) {
                temp[j] = backingarray[j];
            }
            backingarray = temp;
        }
        for (int i = 0; i < backingarray.length; i++) {
            if (backingarray[i] == null) {
                backingarray[i] = elem;
                break;
            }
        }
    }

    /**
     * Adds all elements in elems to the collection.
     * Hint: can this be implemented in terms of add(T elem)?
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (T elem : elems) {
            this.add(elem);
        }
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        boolean contains = false;
        for (T check : backingarray) {
            if (check.equals(elem)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hello", null]
     * Collection after remove("hello") = ["hi", "wsup", "hello", null, null]
     *
     * Note that this method only removes the first instance of a value
     * equal to elem, as shown above.
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        boolean removed = this.contains(elem);
        int remIndex = -1;
        for (int i = 0; i < backingarray.length; i++) {
            if (backingarray[i].equals(elem)) {
                remIndex = i;
                break;
            }
        }
        if (remIndex >= 0) {
            for (int j = remIndex; j < backingarray.length - 1; j++) {
                backingarray[j] = backingarray[j + 1];
            }
        }
        return removed;
    }

    /**
     * Removes each element in elems from the collection.
     * Hint: can this be implemented in terms of remove(T elem)?
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        int remove = 0;
        for (T elem : elems) {
            boolean removed = this.remove(elem);
            if (removed) {
                remove++;
            }
        }
        return remove > 0;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is less than zero or greater than the number
     * of elements in this collection, return null.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (index < 0 || index >= backingarray.length) {
            return null;
        } else {
            return backingarray[index];
        }
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int size = 0;
        for (T item : backingarray) {
            if (item != null) {
                size++;
            }
        }
        return size;
    }
    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return backingarray.length;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        backingarray = (T[]) new Object[5];
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        boolean empty = false;
        if (this.size() == 0) {
            empty = true;
        }
        return empty;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String dispStr = "[";
        for (int i = 0; i < backingarray.length; i++) {
            T temp = this.get(i);
            if (temp != null) {
                dispStr = dispStr + " " + temp + ",";
            }
        }
        return dispStr.substring(0, dispStr.length() - 1) + "]";
    }
}