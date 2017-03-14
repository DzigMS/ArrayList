package ua.dzms.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size;

    public ArrayList() {
        array = (T[]) new Object[5];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T object) {
        add(object, size);
    }

    public void add(T object, int index) {
        validateAdd(index);
        resizeUp();
        if (index == size) {
            array[size] = object;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = object;
        }
        size++;
    }

    @Override
    public T get(int index) {
        validate(index);
        return array[index];
    }

    @Override
    public T remove(int index) {
        validate(index);
        T remove = array[index];
        removeIndex(index);
        return remove;
    }

    @Override
    public void remove(T object) {
        int index = indexOf(object);
        if (index != -1) {
            removeIndex(index);
        } else {
            throw new IllegalArgumentException("Object is not found");
        }
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(T object) {
        return (indexOf(object) != -1);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public void set(T object, int index) {
        validate(index);
        array[index] = object;
    }

    @Override
    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    private void validate(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("Index must be between 0.." + size);
        }
    }

    private void validateAdd(int index) {
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("LinkedList have only " + size + " elements");
        }
    }

    private void resizeUp() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void resizeDown() {
        if (array.length > 2 * size && array.length > 5) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    private void removeIndex(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        resizeDown();
    }
}
