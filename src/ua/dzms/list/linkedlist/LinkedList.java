package ua.dzms.list.linkedlist;

import ua.dzms.list.List;
import ua.dzms.list.node.Node;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> temp;
    private int size;

    private final int IS_EMPTY = 0;
    private final int TEMP_NULL = 1;
    private final int TEMP_HAVE_NEXT_AND_PREVIOUS = 2;
    private final int TEMP_NEXT_NULL = 3;
    private final int TEMP_PREVIOUS_NULL = 4;


    @Override
    public void add(T object) {
        add(object, size);
    }

    @Override
    public void add(T object, int index) {
        validateAdd(index);
        Node<T> newNode = new Node<>(object);
        nodeOf(index);
        switch (rule()) {
            case IS_EMPTY:
                first = newNode;
                last = newNode;
                break;

            case TEMP_NULL:
                last.setNextNode(newNode);
                newNode.setPreviousNode(last);
                last = newNode;
                break;

            case TEMP_HAVE_NEXT_AND_PREVIOUS:
                newNode.setNextNode(temp);
                temp.getPreviousNode().setNextNode(newNode);
                temp.setPreviousNode(newNode);
                break;

            case TEMP_PREVIOUS_NULL:
                first.setPreviousNode(newNode);
                newNode.setNextNode(first);
                first = newNode;
                break;

        }
        clearNode(temp);
        size++;
    }

    @Override
    public void remove(T object) {
        if (indexOf(object) != -1) {
            remove();
            clearNode(temp);
        } else {
            throw new IllegalArgumentException("Object is not found");
        }
    }

    @Override
    public T remove(int index) {
        validate(index);
        remove();
        return temp.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        validate(index);
        return temp.getValue();
    }

    @Override
    public void set(T object, int index) {
        validate(index);
        temp.setValue(object);
        clearNode(temp);
    }

    @Override
    public boolean contains(T object) {
        return (indexOf(object) != -1);
    }

    @Override
    public void clear() {
        int length = size;
        for (int i = 0; i < length; i++) {
            temp = first;
            remove();
            clearNode(temp);
        }
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int indexOf(T object) {
        temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.getValue().equals(object)) {
                return i;
            }
            temp = temp.getNextNode();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        temp = last;
        for (int i = 0; i < size; i++) {
            if (temp.getValue().equals(object)) {
                return size - i - 1;
            }
            temp = temp.getPreviousNode();
        }
        return -1;
    }

    private void remove() {
        switch (rule()) {
            case TEMP_HAVE_NEXT_AND_PREVIOUS:
                temp.getNextNode().setPreviousNode(temp.getPreviousNode());
                temp.getPreviousNode().setNextNode(temp.getNextNode());
                break;

            case TEMP_NEXT_NULL:
                if (last == first) {
                    clearNode(last);
                    clearNode(first);
                    break;
                }
                last = temp.getPreviousNode();
                last.setNextNode(null);
                break;

            case TEMP_PREVIOUS_NULL:
                first = first.getNextNode();
                first.setPreviousNode(null);
                break;
        }
        size--;
    }

    private void validateAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be between 0.." + size);
        }
    }

    private void validate(int index) {
        validateAdd(index);
        if (index == size) {
            throw new IndexOutOfBoundsException("LinkedList have only " + size + " elements");
        }
        nodeOf(index);
    }

    private void nodeOf(int index) {
        temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNextNode();
        }
    }

    private void clearNode(Node<T> node) {
        node = null;
    }

    private int rule() {
        int forCase;
        return forCase = (isEmpty()) ? IS_EMPTY :
                ((temp == null) ? TEMP_NULL :
                        (((temp.getNextNode() != null) && (temp.getPreviousNode() != null)) ? TEMP_HAVE_NEXT_AND_PREVIOUS :
                                ((temp.getNextNode() == null) ? TEMP_NEXT_NULL : TEMP_PREVIOUS_NULL)));
    }
}