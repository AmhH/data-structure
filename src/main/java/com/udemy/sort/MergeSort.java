package com.udemy.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

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
        //merge(array, start, mid, end);
    }
}
