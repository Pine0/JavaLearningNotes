package javase;

import java.util.*;

public class BinarySearch{
    static int search(int[] array, int n){
        if (array.length == 0)
            return -1;
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;
        while (left < right){
            if (array[mid] > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
    public static void main(String[] args){
        int[] array = new int[10000];
        for(int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 100000000; i++){
            int n = ((int) (new Random().nextFloat() * 10000));

            assert (n == search(array, n));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}