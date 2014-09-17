/**
 * Doubly linked list implementation
 *
 * @author Menghang Li
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else if (index == 1 && size == 1) {
            tail = new Node<T>(data);
            tail.setPrevious(head);
            head.setNext(tail);
            tail.setNext(null);
            size++;
        } else {
            Node<T> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.getNext();
            }
            Node<T> toInsert = new Node<T>(data);
            current.getNext().setPrevious(toInsert);
            toInsert.setNext(current.getNext());
            toInsert.setPrevious(current);
            current.setNext(toInsert);
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return getHead().getData();
        } else if (index == (size - 1)) {
            return getTail().getData();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFromFront();
        } else if (index == (size - 1)) {
            return removeFromBack();
        } else {
            Node<T> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.getNext();
            }
            T data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);
            size--;
            return data;
        }

    }

    @Override
    public void addToFront(T t) {
        if (size == 0) {
            head = new Node<T>(t);
            head.setNext(null);
            head.setPrevious(null);
            tail = head;
        } else {
            Node<T> oldHead = head;
            head = new Node<T>(t);
            head.setNext(oldHead);
            head.setPrevious(null);
            oldHead.setPrevious(head);
        }
        size++;
    }

    @Override
    public void addToBack(T t) {
        if (size == 0) {
            addToFront(t);
        } else {
            Node<T> oldTail = tail;
            tail = new Node<T>(t);
            tail.setPrevious(oldTail);
            tail.setNext(null);
            oldTail.setNext(tail);
            size++;
        }
    }

    @Override
    public T removeFromFront() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = getHead().getData();
            clear();
            return data;
        } else {
            T oldHeadData = getHead().getData();
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return oldHeadData;
        }
    }

    @Override
    public T removeFromBack() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = getTail().getData();
            clear();
            return data;
        } else {
            T oldTailData = getTail().getData();
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return oldTailData;
        }
    }

    @Override
    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[0];
        }
        Object[] data = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            data[i] = current.getData();
            current = current.getNext();
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
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

    /**
     * Reference to the head node of the linked list. Normally, you would not do
     * this, but we need it for grading your work.
     *
     * You will get a 0 if you do not implement this method.
     *
     * @return Node representing the head of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Reference to the tail node of the linked list. Normally, you would not do
     * this, but we need it for grading your work.
     *
     * You will get a 0 if you do not implement this method.
     *
     * @return Node representing the tail of the linked list
     */
    public Node<T> getTail() {
        return tail;
    }
}
