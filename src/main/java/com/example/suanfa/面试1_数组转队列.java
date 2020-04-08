package com.example.suanfa;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName 面试1_数组转队列.java
 * @Description TODO
 * @createTime 2020年04月08日 17:00:00
 */
public class 面试1_数组转队列 {
    private static int[] array=new int[12];
    private static int head =0;
    private static int tail = 0;
    private static int count = 0;

    public static void main(String[] args) {
        for (int i=1;i<=12;i++){
            append1(i);
        }
        append1(13);
        System.out.println(get1(0));
        System.out.println(get1(11));
    }

    public static void append(int data){
        if(array.length<12 && head ==0){
            array[array.length] = data;
            tail++;
        }
        if(array.length==12){
            array[head]=data;
            if(head<11){
                head++;
                tail = head-1;
            }else {
                head = 0;
            }
        }
    }

    public static int get(int index){
        if(index>11){
            return -1;
        }
        if(index>head && index<tail){
            return array[index];
        }
        if(tail<head){
            return array[(head-tail+index%12)%12];
        }
        return -1;
    }

    /**
     * 第二种方式
     * @param data
     */
    public static void append1(int data){
       array[count++] = data;
       if(count>11){
           count = 0;
       }
    }
    public static int get1(int index){
        if(index > 11){
            return -1;
        }
        int num = index%12;
        return array[(count+num)%12];
    }

}
