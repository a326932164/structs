package com.csx;

public class ArrayStack<E> implements stack<E> {
    private  Array<E> array ;
    public  ArrayStack(){
        array=new Array<E>();
    }
    public int getSize() {
        return array.size;
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
      array.addLast(e);
    }

    public E pop() {
        return array.deleteEnd();
    }

    public E peek() {
        return array.getLast();
    }
}
