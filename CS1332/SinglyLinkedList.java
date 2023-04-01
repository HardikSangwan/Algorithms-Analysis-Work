/**
 * Implementation of a SinglyLinkedList
 *
 * @author Hardik Sangwan
 * @version 3.14
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {
    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Please enter valid index");
        }

        if (data == null) {
            throw new IllegalArgumentException("Enter valid data");
        }

        if (index == 0) {
            addToFront(data);
            return;
        }

        LinkedListNode<T> temp = new LinkedListNode<T>(data);
        LinkedListNode<T> curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.getNext();
        }
        curr.setNext(temp);
        temp.setNext(curr.getNext());
        if (index == size) {
            tail = temp;
        }
        size++;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Enter valid data");
        }

        head = new LinkedListNode<T>(data, head);
        if (size == 0) {
            head = new LinkedListNode<T>(data);
            tail = head;
        }
        size++;
    }

    @Override
    public void addToBack(T data) {
        LinkedListNode<T> newest = new LinkedListNode<>(data);
        if (data == null) {
            throw new IllegalArgumentException("Null Data");
        }
        if (size == 0) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    @Override
    public T removeAtIndex(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return removeFromFront();
        } else {
            LinkedListNode<T> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            LinkedListNode<T> removed = curr.getNext();
            curr.setNext(removed.getNext());
            if (removed.getNext() == null) {
                tail = curr;
            }
            removed.setNext(null);
            size--;
            return removed.getData();
        }
    }

    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        LinkedListNode<T> answer = head;
        head = head.getNext();
        size--;
        answer.setNext(null);
        if (size == 0) {
            tail = null;
        }
        return answer.getData();
    }

    @Override
    public T removeFromBack() {
        if (size <= 1) {
            return removeFromFront();
        } else {
            LinkedListNode<T> curr = head;

            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }

            LinkedListNode<T> temp = curr.getNext();
            curr.setNext(null);
            tail = curr;
            size--;
            return temp.getData();
        }
    }

    @Override
    public T removeFirstOccurrence(T data) {
        if (isEmpty()) {
            return null;
        }
        LinkedListNode<T> x = head;

        T removed = null;

        for (int i = 0; i < size; i++, x = x.getNext()) {
            if (x.getData().equals(data)) {
                removed = removeAtIndex(i);
                return removed;
            }
        }
        return removed;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Enter valid index");
        }
        LinkedListNode<T> x = head;
        for (int i = 0; i < index; i++) {
            x = x.getNext();
        }

        return x.getData();
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        LinkedListNode<T> temp = head;
        for (int i = 0; i < size; i++) {
            a[i] = temp.getData();
            temp = temp.getNext();
        }
        return a;
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
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    @Override
    public LinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}