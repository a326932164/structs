package com.csx;

/**
 * 链表实现队列
 */
public class LinkedListQueue<E>  implements  Queue<E>{
    private  class  Node{
        public  Node next;
        public  E e;
        public  Node(Node next,E e){
            this.next=next;
            this.e=e;
        }
        public Node(){
            this(null,null);
        }
        public  Node(E e){
            this(null,e);
        }
    }
    private  Node head,tail;
    private  int size;
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head==tail;
    }

    public void enqueue(E e) {
        if (tail==null){
            tail=new Node(e);
            head=tail;

        }
         Node cur=new Node(e);
         tail.next=cur;
         tail=cur;
    }

    public E dequeue() {
        if (isEmpty()){
            throw  new IllegalArgumentException("队列为空");
        }
         Node retNode=head;
         head=head.next;
         retNode.next=null;
        return retNode.e ;
    }

    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
    }


}
