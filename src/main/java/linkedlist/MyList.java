package linkedlist;

import java.util.Iterator;

public interface MyList<E> extends Iterator<E>, Iterable<E> {
    void add(E element);
    boolean contains(int index);
    void remove(int index);
    void remove(E element);
    boolean contains(E element);
    E get(int index);
    int indexOf(E element);
    void addAll(MyList<E> mylist);
    int size();
    void clear();
}
