package ua.dzms.list;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T object) {
        add(object, size);
    }

    @Override
    public void add(T object, int index) {
        validateAdd(index);
        Node<T> newNode = new Node<>(object);

        if (size == 0) {
            first = newNode;
            last = newNode;
        } else if (index == size) {
            last.setNextNode(newNode);
            newNode.setPreviousNode(last);
            last = newNode;
        } else if (index == 0) {
            newNode.setNextNode(first);
            first.setPreviousNode(newNode);
            first = newNode;
        } else {
            Node<T> temp = getNode(index);
            newNode.setNextNode(temp);
            newNode.setPreviousNode(temp.getPreviousNode());
            temp.getPreviousNode().setNextNode(newNode);
            temp.setPreviousNode(newNode);
        }
        size++;
    }

    @Override
    public void remove(T object) {
        int tempIndex = indexOf(object);
        if (tempIndex != -1) {
            removeNode(tempIndex);
        } else {
            throw new IllegalArgumentException("Object is not found");
        }
    }

    @Override
    public T remove(int index) {
        validate(index);
        Node<T> temp = getNode(index);
        removeNode(index);
        return temp.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        validate(index);
        return getNode(index).getValue();
    }

    @Override
    public void set(T object, int index) {
        validate(index);
        getNode(index).setValue(object);
    }

    @Override
    public boolean contains(T object) {
        return (indexOf(object) != -1);
    }

    @Override
    public void clear() {
        Node<T> temp;
        while (size != 0) {
            temp = first;
            first = first.getNextNode();
            temp.setNextNode(null);
            temp.setPreviousNode(null);
            temp.setValue(null);
            size--;
        }
        last = null;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int indexOf(T object) {
        Node<T> temp = first;
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
        Node<T> temp = last;
        for (int i = 0; i < size; i++) {
            if (temp.getValue().equals(object)) {
                return size - i - 1;
            }
            temp = temp.getPreviousNode();
        }
        return -1;
    }

    private void removeNode(int index) {
        Node<T> temp = getNode(index);
        if (index == 0) {
            first = temp.getNextNode();
            first.setPreviousNode(null);
        } else if (index == size - 1) {
            last = temp.getPreviousNode();
            last.setNextNode(null);
        } else {
            temp.getPreviousNode().setNextNode(temp.getNextNode());
            temp.getNextNode().setPreviousNode(temp.getPreviousNode());
        }
        size--;
    }

    private void validateAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be between 0.." + size);
        }
    }

    private void validate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("LinkedList have only " + size + " elements");
        }
    }

    private Node<T> getNode(int index) {
        Node<T> temp;
        int count;
        if (index < size / 2) {
            count = 0;
            temp = first;
            while (count != index) {
                temp = temp.getNextNode();
                count++;
            }
        } else {
            count = size - 1;
            temp = last;
            while (count != index) {
                temp = temp.getPreviousNode();
                count--;
            }
        }
        return temp;
    }
}