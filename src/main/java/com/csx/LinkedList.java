package com.csx;

public class LinkedList<E>{
    private  class  Node {
        public Node next;
        public E e;
        public  Node(){
            this(null,null);
        }
        public Node(E e){
            this.e=e;
            this.next=null;
        }
        public Node(E e,Node node){
            this.e=e;
            this.next=next;
        }
    }
      private  Node dummyHead;
      private  int  size;
      public  LinkedList(){
          this.dummyHead=null;
          this.size=0;
    }
    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在链表头添加元素
    public  void addFirst(E e){
//          Node cur=new Node(e);
//          cur.next=head;
//          //维持头节点
//          head=cur;
        add(0,e);
          size++;
    }
    public  void addLast(E e){
        add(size,e);
    }

    public  void add(int index,E e){
          Node pre=dummyHead;
          for (int i=0;i<index;i++) {
              pre = pre.next;
          }
//          Node cur=new Node(e);
//          cur.next=pre.next;
//          pre.next=cur;

        pre.next=new Node(e,pre.next);
          size++;


    }
    public  E get(){
         return get(0);
    }
    public  E  get(int index){
          Node cur=dummyHead.next;
          for (int i=0;i<index;i++){
              cur=cur.next;
          }
          return  cur.e;
    }
    public  boolean contains(E e){
          Node cur=dummyHead;
          while (cur.next!=null){
               cur=cur.next;
               if (cur.e.equals(e)){
                   return  true;
               }
          }
          return  false;
    }
    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }


    public E remove(int index){
          Node pre=dummyHead;
          for (int i=0;i<index;i++){
              pre=pre.next;
          }
          Node cur=pre.next;
          pre.next=cur.next;
          cur.next=null;
          size--;
          return cur.e;
    }



}
