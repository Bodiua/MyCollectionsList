package linkedlist;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements MyList<E> {

    private Node head;
    private Node iterableNode = null;
    private int cursor = 0;

    public void add(E element){
        if(head == null){
            head = new Node(element);
        }else {
            Node current = head;
            while(current != null){
                if(current.next == null){
                    current.next = new Node(current,null,element);
                    return;
                }
                current = current.next;
            }
        }
    }

    public boolean contains(int index){
        int i = 0;
        for(Node current = head;current != null; i++){
            if(i == index ){
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public boolean contains(E element){
        for(Node current = head;current != null;){
            if(element.equals(current.value) ){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index){
        int i = 0;
        for(Node current = head;current != null; i++){
            if(i == index ){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        for(Node current = head;current != null; i++){
            if(current.value.equals(element)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    @Override
    public void remove(int index) {
        int i = 0;
        Node current = head;
        while(current != null){
            if(index == i){
                if(current.previous == null && current.next == null){
                    head = null;
                    break;
                }
                if(current.previous == null){
                    head = head.next;
                    head.previous = null;
                } else {
                    if(current.next != null){
                        current.next.previous = current.previous;
                    }
                    current.previous.next = current.next;
                }
                break;
            }
            current = current.next;
            i++;
        }
    }

    @Override
    public void remove(E element) {
        Node current = head;
        while(current != null){
            if(current.value == element){
                if(current.previous == null && current.next == null){
                    head = null;
                    break;
                }
                if(current.previous == null){
                    head = head.next;
                    head.previous = null;
                } else {
                    if(current.next != null){
                        current.next.previous = current.previous;
                    }
                    current.previous.next = current.next;
                }
                break;
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        int i = 0;
        for(Node current = head;current != null; i++){
            current = current.next;
        }
        return i;
    }

    @Override
    public void clear() {
        head = null;
        System.gc();
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

    @Override
    public E next() {
        if(size() < cursor)
            return null;
        cursor++;
        if(iterableNode == null){
            iterableNode = head;
            return iterableNode.value;
        }
        iterableNode = iterableNode.next;
        return  iterableNode.value;
    }
    public void addAll(MyList<E> mylist){
        for(E element : mylist){
            add(element);
        }
    }

    private class Node{
        E value;
        Node previous;
        Node next;
        public Node(E value){
            this.value = value;
        }
        public Node(Node previus,Node next,E value){
            this.previous = previus;
            this.next = next;
            this.value = value;
        }
    }
}
