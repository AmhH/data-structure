package com.udemy.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        mergeSort(intArray, 0, intArray.length);
        System.out.println(Arrays.toString(intArray));

    }
    /**
     * Merge sort is a divide and conquer approach. Has two phases splitting and then merging, sorting happens while
     * merging. Split array into two until you get array with one element that is sorted array and then merge back
     * While merging back sort and merge sibling arrays
     * @param array unsorted array
     * @param start start index for the partition
     * @param end end index for the partition it is always one greater than the last index of the partition
     */
    public static void mergeSort(int[] array, int start, int end){
        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        if(array[mid-1] <= array[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];

        while (i < mid && j < end){
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        /**
         * if there are elements left in teh right array no need to copy if do it will be overriding.
         *         We are always copying the smallest elements
         *         {32, 34} {33, 36}
         *         {32, 33, 34}
         */
        System.arraycopy(array, i, array, start + tempIndex, mid -i);
        System.arraycopy(temp, 0, array, start, tempIndex);

    }
}
