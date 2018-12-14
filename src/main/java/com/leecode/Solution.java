package com.leecode;

import com.csx.ArrayStack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号匹配问题
 *
 *
 */
public class Solution {
    public boolean isvaild(String s){
        ArrayStack<Character>  arrayStack=new ArrayStack<Character>();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch=='('|| ch=='[' || ch=='{'){
                arrayStack.push(ch);
            }
            else {
                if (arrayStack.isEmpty()){
                    return  false;
                }
                char toChar=arrayStack.pop();
                if (ch==')'&&toChar!='('){
                    return  false;
                }
                if (ch==']'&&toChar!='['){
                    return  false;
                }
                if (ch=='}'&&toChar!='{'){
                    return  t;
                }
            }
        }
       
       return  arrayStack.isEmpty();

    }
    public  static  void  main(String[] args){
        System.out.println(new Solution().isvaild("{()}))))"));
    }
}
