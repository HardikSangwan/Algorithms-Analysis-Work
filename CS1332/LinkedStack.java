/**
 * Implementation of a linked stack.
 *
 * @author Hardik Sangwan
 * @version 1.69
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T pop() {
        if (this.size() == 0) {
            throw new java.util.NoSuchElementException("The stack is empty");
        }
        T removed = head.getData();
        head.setNext(head.getNext().getNext());
        head = head.getNext();
        return head.getData();
    }

    @Override
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The provided data is null");
        }
        head = new LinkedNode<T>(data, head);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the head of this stack.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}