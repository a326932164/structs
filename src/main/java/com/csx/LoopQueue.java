package com.csx;

public class LoopQueue<E> implements Queue<E>  {
    E[] data;
    int front,tail;
    int size;
    public  LoopQueue(int capacity){
        data=(E[])new Object[capacity];
        front=0;
        tail=0;
        size=0;
    }
    public  LoopQueue(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return tail==front;
    }

    /**
     * 循环队列入队操作
     * @param e
     */
    public void enqueue(E e) {
        if ((tail+1)%data.length==front){
            resize(2*data.length);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
          size++;
    }

    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空异常");
        }
        E  ret=  data[front];
        data[front]=null;
        size--;
        //把front移动
        front=(front+1)%data.length;
        if (data.length/4==size&&size/2!=0)
        {
            resize(data.length/2);
        }
        return ret;
    }

    public E getFront() {
        if (isEmpty()){
            throw  new IllegalArgumentException("异常");
        }
        return data[front];
    }
    /**
     * 数据的扩容
     */
    private void resize(int capacity){
       E [] newDate=(E[])new Object[capacity];
         for (int i=0;i<size;i++){
             newDate[i]=data[(front+i)%data.length];
         }
         data=newDate;
         front=0;
         tail=size;
    }

}
