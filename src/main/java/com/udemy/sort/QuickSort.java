package com.udemy.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        quickSort(intArray, 0, intArray.length);

        System.out.println(Arrays.toString(intArray));

    }

    /**
     * Quick sort uses divide and conquer approach
     * Chooses pivot and put elements less than pivot the left and greater than pivot on the right side.
     * This choosing continues until we get size one. It is in place sorting unlike Merge sort
     * @param array array to be sorted
     * @param start start index for the partition
     * @param end end index for the partition
     */
    public static void quickSort(int[] array, int start, int end){
        if(end - start < 2)
            return;

        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);

    }

    /**
     * Uses the first element as a pivot
     * @param array array to be sorted
     * @param start start of partition and the pivot
     * @param end length =  end + start, end is last index + 1
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];

        int i = start;
        int j = end;

        while (i < j){
            //Empty loop body
            while(i < j && array[--j] >= pivot);

            if(i < j)
                array[i] = array[j];

            while (i < j && array[++i] <= pivot);

            if (i < j)
                array[j] = array[i];
        }
        array[j] = pivot;
        return j;
    }
}
