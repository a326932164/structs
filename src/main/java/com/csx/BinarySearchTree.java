package com.csx;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BinarySearchTree<E extends  Comparable<E>> {
    private  class  Node{
        private   E e;
        private  Node left;
        private  Node right;
        public   Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }
    }
    public Node root;
    public int size;
    public  BinarySearchTree(){
        this.size=0;
        this.root=null;
    }

    /**
     * size
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 添加元素e
     */
    public  void add(E e){
        if (isEmpty()){
            root=new Node(e);
        }
        Node cur=root;
        while (cur!=null) {
            if (e.compareTo(cur.e) < 0) {
                cur = cur.left;
            } else if (e.compareTo(cur.e) > 0) {
                cur = cur.right;
            }
        }
        cur.e=e;
        size++;
    }
    /**
     * /向以node为根的二分搜索树中插入元素e，递归算法
     */
    private   void adddigui(Node node,E e) {
        if (e.equals(node.e)){
              return;
        }
        if (e.compareTo(node.left.e)<0&&node.left==null){
               node.left=new Node(e);
        }
        else if (e.compareTo(node.left.e)>0&&node.right==null){
              node.right=new Node(e);
        }
        if (e.compareTo(node.left.e)<0){
            adddigui(node.left,e);
        }
        else {
            adddigui(node.right,e);
        }
        size++;

    }
    private  Node adddigui2(Node node,E e){
        if (node==null){
            return new Node(e);
        }
        if (e.compareTo(node.left.e)<0){
            node.left=adddigui2(node.left,e);
        }
        else {
            node.right=adddigui2(node.right,e);
        }
        size++;
        return node;
    }
    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node,E e){
        if (node==null){
            return false;
        }
        if (node.e.compareTo(e)==0){
            return  true;
        }
        if (e.compareTo(node.left.e)<0){
            contains(node.left,e);
        }
        else {
            contains(node.right.e);

        }

        return  false;
    }
    /**
     * 二叉树前序遍历
     */
    public  void preOrder(){
       preOrder(root);
    }

    /**
     * 前序遍历
     * @param root
     */
    private  void preOrder(Node root){
        if (root==null){
            return;
        }
        System.out.println(root.e);//前序
        preOrder(root.left);
       // System.out.println(root.e); 中序 按重小到大排序
        preOrder(root.right);
     //  System.out.println(root.e); 后序
    }
    /**
     * （前序）深度遍历非递归
     */
    private void depthOrder(Node root){
        if (root==null){
            return;
        }
        Stack<Node> stack=new Stack();
        stack.push(root);
        while (!stack.empty()){
           Node cur=stack.pop();
           System.out.println(cur);
           if (cur.right!=null) {
               stack.push(cur.right);
           }
           if (cur.left!=null) {
               stack.push(cur.left);
           }
        }

    }

    /**
     * 广度遍历 层级遍历
     */
    private void lenthOrder(){
        if (root==null){
            return;
        }
       Queue<Node> queue= new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur=queue.remove();
            System.out.println(cur);
            if (root.left!=null){
                queue.add(root.left);
            }
            if (root.right!=null){
                queue.add(root.right);
            }
        }


    }
    /**
     * 寻找二分搜索树的最小值
     */
    public  E minium(){

       return  minium(root).e;
    }
    private   Node  minium(Node node){
        if (node==null){
            return  node;
        }
        return  minium(node.left);
    }

    /**
     * 寻找二分搜索树的最大值
     * @return
     */

    public  E maxium(){

        return  maxium(root).e;
    }
    private   Node  maxium(Node node){
        if (node==null){
            return  node;
        }
        return  minium(node.right);
    }

    /**
     * 删除二分搜索书最小值
     * @return
     */
    public  E removeMin(){
        E ret=minium();
        removeMin(root);
        return ret;

    }

    /**
     * 删除以二分搜索书的跟
     * @param root
     * @return
     */
    private Node removeMin(Node node){
        if (node.left==null){
            Node retright=node.right;
            node.right=null;
            return retright;
        }
        node.left=removeMin(node.left);//返回删除后的二叉树
        return  node;
    }
    /**
     * 删除的二分搜索树的最大值
     */
    public  E removeMax(){
        E ret=maxium();
        removeMax(root);
        return  ret;
    }
     private  Node removeMax(Node node){
        if (node.right==null){
            Node retLeft=node.left;
            node.left=null;
            return  retLeft;
        }
        node.right=removeMin(node.right);
        return  node;
     }
    /**
     * 删除掉以node为根的二分搜索树支为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     */
    private  Node remove(Node node,E e){
        if (node==null){
            return  null;
        }
         if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return  node;//返回删除后的二叉树
         }
         else  if (e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return  node;
         }
         else {//相等的时候
           if (node.left==null){
               Node nodeRight=node.right;
               node.right=null;
               return  nodeRight;
           }
           if (node.right==null){
               Node nodeLeft=node.left;
               node.left=null;
               return  nodeLeft;
           }
           //左右子树都不为空的情况。
             // 找到比待删除节点大的最小的节点
             //使这个节点放到删除节点的位置
           Node minNode=minium(node.right);//找到当前节点的下一个比这个节点大的最小值
           minNode.right=removeMin(node.right);
           minNode.left=node.left;
            node.left=node.right=null;
            return  minNode;


           }
         }


}
