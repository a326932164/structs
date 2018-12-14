package com.paixu;

public class kuaisupaixu {
    public  static  void main(String[] args){
        int arr[]=new int[50];
        quicksort(arr,0,arr.length-1);
    }
    public  static  void quicksort(int[] arr,int l,int r){
        if (l>r){
            return;
        }
        //返回p使得 p的左边全部小于 右边全部大于
       int p=partion(arr,l,r);
        //进行递归 左右两部分进行递归
        quicksort(arr,l,p-1);
        quicksort(arr,l,p+1);


    }
    public  static  int partion(int[] arr,int l,int r){
        int v=arr[l];
        //l......j <v     j+1......r >v
        int j=l;
           for (int i=l+1;i<=r;i++){
               if (arr[i]<v){
                   swap(++j,i);
               }
           }
           return  j;
        }
        1000 7515 1262 3907 0537
}
