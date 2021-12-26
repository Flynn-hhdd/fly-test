package com.example.suanfa.sort;

public class Select {
    public static void selectSort( int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        int N = arr.length;
        for(int i = 0;i<N;i++){
            int minValueIndex = i;
            for(int j = i+1;j<N;j++){
                minValueIndex =arr[j]<arr[minValueIndex]?j:minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr ={7,1,3,6,8,9,3,4,10};
        selectSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr){
        for (int i = 0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
