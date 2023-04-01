/**
 *
 * @author Hardik Sangwan
 * @version 1.618
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
        ArrayList<T> testList = new ArrayList<T>();
    }

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index >= this.backingArray.length)
        {
            throw new IndexOutOfBoundsException("Given index out of bounds.");
        }
	else if (data == null)
	{
            throw new IllegalArgumentException("Data is null");
        }
        else {
            T temp = new T[this.backingArray.length + 1];
            for(int i = 0; i < index; i++){
                temp[i] = this.backingArray[i];
                }
            temp[index] = data;
            for(int i = index; i < this.backingArray.length; i++){
                temp[i+1] = this.backingArray[i];
                }
            }
	    this.backingArray = temp;
        }
    }
    }

    @Override
    public void addToFront(T data) {
        if (data == null)
	{
            throw new IllegalArgumentException("Data is null");
        }
        else {
            T temp = new T[this.backingArray.length + 1];
            temp[0] = data;
            for(int i = 0; i < this.backingArray.length; i++){
                temp[i+1] = this.backingArray[i];
                }
            }
	    this.backingArray = temp;
        }
    }
    }

    @Override
    public void addToBack(T data) {
        if (data == null)
	{
            throw new IllegalArgumentException("Data is null");
        }
        else {
            this.backingArray[this.backingArray.length] = data;
        }
    }
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= this.backingArray.length)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        else {
            T removed = this.backingArray[index];
            this.backingArray[index] = null;
            T[] temp = new T[this.backingArray.length-1];
            for(int i = 0, j = 0; i<this.backingArray.length; i++){
            if (i != index){
                temp[j++] = this.backingArray[i];
                }
            }
	    this.backingArray = temp;
            return removed;
        }
    }

    @Override
    public T removeFromFront() {
            T removed = this.backingArray[0];
            this.backingArray[0] = null;
            T[] temp = new T[this.backingArray.length-1];
            for(int i = 1, j = 0; i<this.backingArray.length; i++){
                temp[j++] = this.backingArray[i];
            }
	    this.backingArray = temp;
            return removed;
    }

    @Override
    public T removeFromBack() {
            T removed = this.backingArray[this.backingArray.length];
            this.backingArray[this.backingArray.length] = null;
            return removed;
    }

    @Override
    public T get(int index) {
        return testList[index];
    }

    @Override
    public boolean isEmpty() {
        return testList.size() == 0;
    }

    @Override
    public int size() {
        return backingArray.length();
    }

    @Override
    public void clear() {
        for (int i = 0; i < testList.size(); i++)
            testList[i] = null;
        backingArray = new T[INITIAL_CAPACITY];
    }

    @Override
    public Object[] getBackingArray() {
        return backingArray;
    }
}
