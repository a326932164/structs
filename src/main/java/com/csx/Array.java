package com.csx;

public class Array<E> {
     E[] data;//数组
     int   size;//数组大小永远指向最后一个节点的后一个 为空。
     public  Array  (){
         this(10);
     }
     public  Array (int capacity){
         this.data=(E[]) new Object[capacity];//使用泛型
         size=0;//与size对应  size是指向当前数据的
     }
 public  Array(E[] arr){
         data=arr;
         size=arr.length-1;
 }
    /**
     * 判断array实际容量
     * @return
     */
     public int getSize(){
         return  size;
     }
     /**
      * 判断是array否为空
      */
     public boolean isEmpty(){
         return size==0;
     }

    /**
     * 向所有元素后添加一个元素
     */
    public void  addLast(E e){
        addIndex(size,e);//size处没有 开始写成size-1注意
    }

    /**
     * 向所有元素前添加一个元素
     * @param e
     */
    public void  addFirst(E e){
        addIndex(0,e);
    }
    /**
     * 向素指定位置添加一个元素
     */
    public   void addIndex(int index,E e){
        if (data.length==size){
            throw  new IllegalArgumentException("数组已满");
        }

        if (index<0||index>size){
            throw new IllegalArgumentException("插入位置不合理");
        }
        if (size==data.length){
            resize(2*data.length);
        }
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 获取第i个索引的元素
     * @param index
     * @return
     */
    public  E get(int index){
        return  data[index];
    }
    /**
     * 看最后一个元素
     */
    public  E getLast(){
        return  get(size-1);
    }
    public  E getFirst(){
        return  get(0);
    }

    /**
     * 设置新的元素
     * @param index
     * @param e
     * @return
     */
    public E  set(int index,E e){
        return data[index]=e;
    }

    /**
     * 删除最后一个节元素
     */
    public void deleteLast(){
//        data[size-1]=null;
//        size--;
        remove(size-1);
    }

    /**
     * 删除第一个元素
     */
    public  E deleteFirst(){
       return remove(0);
    }
    /**
     * 删除最后一个
     */
    public  E deleteEnd(){
        return  remove(size-1);
    }
    /**
     * 查找某个元素的索引
     */
    public  int find(E e){
        for (int i=0;i<size;i++){
               if (data[i]==e){
                   return i;
               }
        }
        return  -1;
    }
    /**
     * 删除某位置的元素
     */
    public  E remove(int index){
        if (index<0||index>=size){
             throw  new IllegalArgumentException("删除的index越界");
        }
        //懒惰缩容
        if (size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        for (int i=index+1;i<size;i++){
            //data[i]=data[i+1];//会有问题越界
            data[i-1]=data[i];
        }
        size--;
            return  data[index];
    }


    /**
     * 数组扩容
     * 将数组的容量变成capacity类型
     * @param capacaity
     */
    private void resize(int capacaity){
        E[] newDate=(E[]) new Object[capacaity*2];
        for (int i=0;i<size;i++){
              newDate[i]=data[i];
        }
        data=newDate;

    }
    /**
     * 交换
     */
    public   void swap(int i,int j){
        E temp =data[i];
        data[i]=data[j];
        data[j]=temp;
    }




}
