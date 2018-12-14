package com.paixu;

/**
 * 递归不需要考虑中间的状态
 */
public class guibingsort {
    public  static  void main(String[] args){
        int arr[]=new int[50];
        int r=arr.length;
        int l=0;
        int mid=l+r-l/2;
        guibingsort(arr,l,r);
    }
    public static void guibingsort(int[] arr, int l, int r){
       //
        if (l>r){
            return;
        }
        int mid=l+r-l/2;//控制状态
        guibingsort(arr,l,mid);//每次缩进
        guibingsort(arr,mid+1,r);//每次缩进
        meragesort(arr,l,mid,r);
    }
    public  static  void  meragesort(int[] arr,int l,int mid,int r){
        int[] newarr=new int[arr.length];//需要一个辅助空间
        for (int i=0;i<arr.length;i++){
            newarr[i]=arr[i];
        }
        int i=l;//左边归并的开始点
        int j=mid+1;//右边归并的开始点
        for (int k=l;k<r;k++){
            //判断索引的合法性
            if (i>mid){
                newarr[k]=arr[j-l];
                j++;
            }
            else if(j>r){
                newarr[k]=arr[i-l];
                i++;
            }
            else if (arr[i-l]<arr[j-l]){
                newarr[k]=arr[i-l];
                i++;
            }
            else //右边归并的大移动右边
            {newarr[k]=arr[j-l];
              j++;
            }
        }

    }
}
