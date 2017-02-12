package ua.dp.arraylist;

import java.util.Arrays;

public class ArrayList {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[5];
    }

    public int size(){
        return size;
    }

    private void validate(int index){
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void resize(){
        if (size == array.length){
            array = Arrays.copyOf(array, array.length*2);
        }else if (array.length > 2*size && array.length > 5){
            array = Arrays.copyOf(array, array.length/2);
        }
    }

    public void add(Object object) {
        add(object, size());
    }

    public void add(Object object, int index) {
        resize();
        if (index == size){
            array[size] = object;
        }else{
            validate(index);
            System.arraycopy(array, index, array, index+1, size - index);
            array[index] = object;
        }
        size++;
    }

    public Object get(int index) {
        validate(index);
        return array[index];
    }

    public Object remove(int index) {
        validate(index);
        Object remove = array[index];
        System.arraycopy(array, index+1, array, index, size - index - 1);
        size--;
        array[size] = null;
        resize();
        return remove;
    }

    public void remove(Object object) {
        remove(indexOf(object));
    }

    public void set(Object object, int index) {
        validate(index);
        array[index] = object;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean contains(Object object) {
        return (indexOf(object) == -1) ? false : true;
    }

    public void clear() {
        for (int i = 0; i < size(); i++){
            array[i] = null;
        }
        size = 0;
    }
}
