package com.paixu;

public class charusort {
    public  static  void main(String[] args){
        int[] arr=new int[50];
        charupaixu(arr);
    }
    public  static  void charupaixu(int[] arr){
        int n=arr.length;
        int x;//要排序的那个位置
        int[] newarr=new int[50];
        for (int i=1;i<n;i++){
            int a=arr[i];//存当前的元素
            for (x=i;x>0;x--){

            if (arr[x]<arr[x -1]){
                arr[x]=arr[x-1];
            }

        }
             arr[x]=a;
        }
    }
}
