/**
 *
 * @author Hardik Sangwan
 * @version 1
 */
public class ArrayList<T> implements ArrayListInterface<T> {

    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * You may add statements to this method.
     */
    public ArrayList() {

    }

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index >= this.backingArray.length) {
            throw new IndexOutOfBoundsException("Given index out of bounds.");
        } else if (data == null) {
            throw new IllegalArgumentException("Data is null");
        } else if (this.size + 1 > this.backingArray.length) {
            T[] temp = (T[]) new Object[this.backingArray.length * 2];
            for (int i = 0; i < this.backingArray.length * 2; i++) {
                temp[i] = this.backingArray[i];
            }
            this.backingArray = temp;
        } else {
            T[] temp = (T[]) new Object[this.backingArray.length + 1];
            for (int i = 0; i < index; i++) {
                temp[i] = this.backingArray[i];
            }
            temp[index] = data;
            for (int i = index; i < this.backingArray.length; i++) {
                temp[i + 1] = this.backingArray[i];
            }
            this.backingArray = temp;
        }
        this.size++;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        } else if (this.size + 1 > this.backingArray.length) {
            T[] temp = (T[]) new Object[this.backingArray.length * 2];
            for (int i = 0; i < this.backingArray.length * 2; i++) {
                temp[i] = this.backingArray[i];
            }
            this.backingArray = temp;
        } else {
            T[] temp = (T[]) new Object[this.backingArray.length + 1];
            temp[0] = data;
            for (int i = 0; i < this.backingArray.length; i++) {
                temp[i + 1] = this.backingArray[i];
            }
            this.backingArray = temp;
        }
        this.size++;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        } else if (this.size + 1 > this.backingArray.length) {
            T[] temp = (T[]) new Object[this.backingArray.length * 2];
            for (int i = 0; i < this.backingArray.length * 2; i++) {
                temp[i] = this.backingArray[i];
            }
            this.backingArray = temp;
        } else {
            this.backingArray[this.backingArray.length] = data;
        }
        this.size++;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= this.backingArray.length) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else {
            T removed = this.backingArray[index];
            this.backingArray[index] = null;
            T[] temp = (T[]) new Object[this.backingArray.length - 1];
            for (int i = 0, j = 0; i < this.backingArray.length; i++) {
                if (i != index) {
                    temp[j++] = this.backingArray[i];
                }
            }
            this.backingArray = temp;
            this.size--;
            return removed;
        }
    }

    @Override
    public T removeFromFront() {
        T removed = this.backingArray[0];
        this.backingArray[0] = null;
        T[] temp = (T[]) new Object[this.backingArray.length - 1];
        for (int i = 1, j = 0; i < this.backingArray.length; i++) {
            temp[j++] = this.backingArray[i];
        }
        this.backingArray = temp;
        this.size--;
        return removed;
    }

    @Override
    public T removeFromBack() {
        T removed = this.backingArray[this.backingArray.length];
        this.backingArray[this.backingArray.length] = null;
        this.size--;
        return removed;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.backingArray.length) {
            throw new IndexOutOfBoundsException("Given index out of bounds.");
        } else {
            return this.backingArray[index];
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        size = 0;
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public Object[] getBackingArray() {
        return backingArray;
    }
}
