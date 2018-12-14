package com.csx;

import java.util.TreeMap;

public class Trie {
    private  class Node {
        public boolean isWord;
        //next的定义是character到node的映射

        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();

        }
        public Node() {
            this(false);

        }
        }
        public  Node  root;
        public  int   size;
        //添加一个字符
        public void add(String word){
            Node cur=root;
            for (int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if (cur.next.get(c)==null){
                    cur.next.put(c,new Node());
                }
                cur=cur.next.get(c);

            }
            if (!cur.isWord){
                cur.isWord=true;
                size++;
            }
        }
        //查询单词
       public  boolean query(String word){
            Node cur=root;
            for (int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if (cur.next.get(c)==null){
                    return  false;
                }
                TreeMap treeMap=cur.next;
                Node nextNode= (Node) treeMap.get(c);
            }
            return  cur.isWord;
       }

}
