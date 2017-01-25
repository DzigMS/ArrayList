package ua.dp.DzMS;

import java.util.Arrays;

public class ArrayList {
    public Object[] array;
    public int size;

    public ArrayList() {
        size = 0;
        array = new Object[5];
    }

    private void lengthArray(){
        if (size >= array.length){
            array = Arrays.copyOf(array,array.length*2);
        }else if (array.length > 2*size && array.length > 5){
            array = Arrays.copyOf(array, array.length/2);
        }
    }

    public void add(Object object) {
        lengthArray();
        array[size] = object;
        size++;
    }

    public void add(Object object, int index) {
        if (index == size){
            add(object);
        }else if (index < size){
            lengthArray();
            for (int i = size; i > 0; i--){
                if (i == index){
                    break;
                }
                array[i] = array[i - 1];
            }
            array[index] = object;
            size++;
        }
    }

    public Object get(int index) {
        if (index < size) {
            return array[index];
        }
        return null;
    }

    public Object remove(int index) {
        if (index < size) {
            Object remove = array[index];
            for (int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            size--;
            array[size] = null;
            lengthArray();
            return remove;
        }
        return null;
    }

    public void remove(Object object) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(object)){
                remove(i);
                break;
            }
        }
    }

    public void set(Object object, int index) {
        if (index < size){
            array[index] = object;
        }
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
        for (int i = 0; i < size; i ++) {
            if (array[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    public void clear() {
        array = new Object[5];
        size = 0;
    }
}
