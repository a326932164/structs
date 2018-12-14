package com.csx;

public class MaxHeap<E extends  Comparable<E>> {
    private Array<E> date;
    //将任意数组整理成堆
    public  MaxHeap(E[] arr){
        //最后一个叶子节点的父节点开始下沉操作
        date=new Array<E>(arr);
        //找到最后一个节点
        for (int i=parent(date.size-1);i<0;i--){
            siftDown(i);
        }

    }
    public  MaxHeap(int capacity){
        date=new Array<E>(capacity);
    }
    public  MaxHeap(){
        date=new Array<E>();
    }
    public int size(){
        return  date.getSize();
    }
    //父亲节点
    public int parent(int index){
        return  (index-1)/2;
    }
    //左孩子节点
    public int leftChild(int index){
        return  2*index+1;
    }
    //右孩子节点
    public  int rightChiled(int index){
        return  2*index+2;
    }
    /**
     * 向堆中添加元素
     */
    public void add(E e){
     date.addLast(e);
     siftUp(date.getSize()-1);
    }
    private  void siftUp(int k){
        while (date.get(k).compareTo(date.get(parent(k)))>0){
                   date.swap(k,parent(k));
                   k=parent(k);
        }
    }
    // 看堆中的最大元素
    public E findMax(){
        if(date.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return date.get(0);
    }
    //取出堆中最大元素
    public E extractTake(){
        E ret=findMax();
        date.swap(0,date.getSize()-1);
        date.remove(date.size-1);
        siftDown(0);
        return ret;
    }
    //下沉的时候每次 和他的抗个子节点较大的比较
    public  void siftDown(int k){
        while (leftChild(k)<date.size-1){
            int j=leftChild(k);
            if (date.get(j).compareTo(date.get(j+1))<0){
                j++;//此时较大的值为右孩子
            }
            if (date.get(j).compareTo(date.get(k))<0){
                break;
            }
            date.swap(k,j);
            k=j;//继续比较。
        }
    }


}
