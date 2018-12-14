package com.csx;

public class ArrayQueue<E> implements  Queue<E> {
    private  Array<E> queue;
    public  ArrayQueue(){
        queue=new Array<E>();
    }
    public int getSize() {
        return  queue.size;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(E e) {
        queue.addFirst(e);
    }

    public E dequeue() {
        return queue.deleteFirst();
    }

    public E getFront() {
        return queue.getFirst();
    }
}
