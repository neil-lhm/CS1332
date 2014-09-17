/**
 * CircularLinkedList implementation
 * @author <Menghang Li>
 * @version 1.0
 */
public class CircularLinkedList<T> implements LinkedListInterface<T> {
    
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    
    @Override
    public void addAtIndex(int index, T data) {       
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();       
        else if (index == 0) 
            addToFront(data);
        else if ((size == 1) && (index == 1)) 
            addToBack(data);
        else {
            Node<T> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(data, current.getNext()));
            size++;
        }
        
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) 
            throw new IndexOutOfBoundsException();       
        else if (index == 0) 
            return getHead().getData();
        else if (index == (size - 1)) 
            return getTail().getData();
        else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }         
            return current.getData();
        }
        
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) 
            throw new IndexOutOfBoundsException();       
        else if (index == 0) 
            return removeFromFront();
        else if (index == (size - 1)) 
            return removeFromBack();
        else {
            Node<T> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.getNext();
            }
            T data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            size--;
            return data;
        }
    }

    @Override
    public void addToFront(T t) {
        head = new Node<T>(t, head);
        if (size == 0) tail = head;
        tail.setNext(head);
        size++;
        
    }

    @Override
    public void addToBack(T t) {
        if (size == 0) {
            addToFront(t);            
        } else {
            tail.setNext(new Node<T>(t, head));
            tail = tail.getNext();
            size++;
        }
        
    }

    @Override
    public T removeFromFront() {
        if (head == null) return null;       
        T data = head.getData();
        head = head.getNext();
        tail.setNext(head);
        size--;
        return data;
    }

    @Override
    public T removeFromBack() {
        if (tail == null) return null;
        
        T data = tail.getData();
        Node<T> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(head);
        tail = current;
        size--;
        return data;
    }

    @Override
    public T[] toList() {
        if (isEmpty()) return (T[]) new Object[0];
        Object[] data = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            data[i] = current.getData();
            current = current.getNext();
        }
        return (T[]) data;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
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
     * Reference to the head node of the linked list.
     * Normally, you would not do this, but we need it
     * for grading your work.
     *
     * @return Node representing the head of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Reference to the tail node of the linked list.
     * Normally, you would not do this, but we need it
     * for grading your work.
     *
     * @return Node representing the tail of the linked list
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * This method is for your testing purposes.
     * You may choose to implement it if you wish.
     */
    @Override
    public String toString() {
        String out = "";
        Node<T> current = head;
        if (head != null) {
            while (current.getNext() != head) {
                out += String.format("  %s  ", current.getData());
                current = current.getNext();
            }
        }
        return out;
    }
}

