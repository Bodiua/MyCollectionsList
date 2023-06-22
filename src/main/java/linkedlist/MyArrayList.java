package linkedlist;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>{
    private Object[] array;
    private int arraySize = 10;
    private int count = 0;
    private int resizeCoef = 2;
    private int cursor = 0;

    public MyArrayList(){
        array = new Object[arraySize];
    }
    public MyArrayList(int arraySize){
        array = new Object[arraySize];
    }

    @Override
    public void add(E element){
        if(count > array.length) throw new RuntimeException("LOH");
        if(array.length == count) resize();
        array[count] = element;
        count++;
    }

    @Override
    public boolean contains(int index) {
        if(index < array.length && index >= 0) return true;
        return false;
    }

    public void resize(){
        int newArraySize = (int) (array.length * resizeCoef);
        Object[] newArray = new Object[newArraySize];
        System.arraycopy(array,0,newArray,0,count);
        array = newArray;
    }
    @Override
    public void remove(int index){
        int i = index;
        while (array[i] != null){
            array[i] = array[i+1];
            i++;
        }
    }
    @Override
    public void remove(E element){
        Object[] newArray = new Object[array.length-1];
        int i = 0;
        while(array[i] != null){
            if(array[i].equals(element)){
                newArray[i] = array[i+1];
                i++;
            }else {
                newArray[i] = array[i];
            }
            i++;
        }
        array = newArray;
    }

    @Override
    public boolean contains(E element){
        for(int i=0;array[i] != null;i++){
            if(array[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E element){
        for(int i=0;array[i] != null;i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public E get(int index){
        for(int i=0;array[i] != null ;i++){
            if(i == index){
                return (E) array[i];
            }
        }
        return null;
    }
    @Override
    public int size(){
        int i = 0;
        while (array[i] != null){
            i++;
        }
        return i;
    }

    @Override
    public void clear(){
        array = new Object[arraySize];
    }

    @Override
    public Iterator<E> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if(size() > cursor)
            return true;
        return false;
    }
    public void addAll(MyList<E> mylist){
        for(E element : mylist){
            add(element);
        }
    }
    @Override
    public E next() {
        if (size() < cursor)
            return null;
        return (E) array[cursor++];
    }
}