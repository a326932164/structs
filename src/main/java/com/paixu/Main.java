package com.paixu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
        public static void main(String[] args){

            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int len=arr.length;

            quickSort(arr,0,len-1);
            for (int x=0;x<arr.length;x++){
                System.out.print(arr[x]+" ");
            }

            //  System.out.println(Arrays.toString(arr));
        }
        public static  void quickSort(int[] arr,int low,int high){

            int i,j,temp;
            i=low;
            j=high;
            temp=arr[i];

            while(i<j){

                while(i<j&&temp<=arr[j])
                    j--;
                if(i<j){
                    arr[i]=arr[j];
                    i++;
                }

                while(i<j&&arr[i]<temp)
                    i++;
                if(i<j){
                    arr[j]=arr[i];
                    j--;
                }

            }
            arr[i]=temp;

            if(low<i)
                quickSort(arr,low,i-1);
            if(i<high)
                quickSort(arr,j+1,high);


        }
    }


