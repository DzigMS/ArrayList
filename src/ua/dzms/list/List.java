package ua.dzms.list;


public interface List<T> {
    void add(T object);
    void add(T object, int index);
    T get(int index);
    void set(T object, int index);
    void remove(T object);
    T remove(int index);
    int size();
    boolean contains(T object);
    void clear();
    boolean isEmpty();
    int indexOf(T object);
    int lastIndexOf(T object);
}
