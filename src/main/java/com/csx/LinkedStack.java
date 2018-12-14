package com.csx;

import java.util.Stack;

/**
 * 头作为栈顶
 * @param <E>
 */
public class LinkedStack<E>  implements  stack<E> {
     private  LinkedList<E> linkedList;
     public  LinkedStack(){
         linkedList=new LinkedList<E>();
     }
    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void push(E e) {
         linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.get();
    }
}
