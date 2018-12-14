package com.csx;


import java.util.LinkedList;

public class JavaLinkedList<E> {
    private class Node{
        private   Node preNode;
        private   Node nextNode;
        private   E e;
        public Node(Node preNode,Node nextNode,E e){
            this.preNode=preNode;
            this.nextNode=nextNode;
            this.e=e;
        }
        public Node(){
            this(null,null,null);
        }
        public Node(E e){
            this(null,null,e);
        }
        public Node(Node nextNode,E e){
            this(null,nextNode,e);
        }

    }
    private  int size;
    private  Node head;
    private  Node tail;
    public  JavaLinkedList(){
        this.size=0;
        this.head=null;
        this.tail=null;
    }
    public  int getSize(){
        return  size;
    }
    public  boolean isEmpty(){
        return  size==0;
    }
    /**
     * 添加元素
     */
    public void addFirst(E e){
        Node newNode=new Node(head,e);
       if (isEmpty()){
           head=newNode;
           tail=newNode;
       }
        Node ret=head;
        head=newNode;
        ret.preNode=newNode;
        size++;
    }
    public  void addLast(E e){
        Node newNode=new Node(tail,null,e);
        if (isEmpty()){
            head=newNode;
            tail=newNode;
        }
        Node ret=tail;
        tail=newNode;
        ret.nextNode=newNode;
        size++;
    }
    private void add(int index,E e){
        Node preNode=head;
        if (isEmpty()){
            addFirst(e);
        }
        for (int i=0;i<index-1;i++){
            preNode=head.nextNode;//插入元素的前一个节点
        }
        preNode.nextNode=new Node(preNode.nextNode,e);
        Node cur=preNode.nextNode;
        Node curLast=cur.nextNode;
        curLast.preNode=curLast;
        preNode.nextNode=cur;
        cur.preNode=preNode;
        size++;
    }

    /**
     * 第一步：找到即将被删除的节点 p
     * 第二步：将 p 的前驱的后继指向 p 的后继，即 p->prior->next = p->next;
     * 第三步：将 p 的后继的前驱指向 p 的前驱，即 p->next->prior = p->prior;
     * 第四步：删除节点 p 即 delete p;
     * @param e
     */
    public  void  remove(E e){
        Node preNode=head;
        while (preNode.nextNode.e.equals(e)){
            preNode=head.nextNode;
        }
        Node cur=preNode.nextNode;
        preNode.nextNode=cur.nextNode;
        cur.preNode=null;
        cur.nextNode.preNode=preNode;
        cur.nextNode=null;
        size--;
    }

}
