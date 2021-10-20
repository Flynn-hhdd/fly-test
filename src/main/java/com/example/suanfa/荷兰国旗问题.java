package com.example.suanfa;

public class 荷兰国旗问题 {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,19,7,6,1,4,5};
        System.out.println(partition(array,0,7,4));

    }

    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L - 1;
        int more = R + 1;
        while(L < more) {
            if(arr[L] < p) {
                swap(arr, ++less, L++);
            } else if (arr[L] > p) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
