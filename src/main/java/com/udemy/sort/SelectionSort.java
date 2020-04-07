package com.udemy.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        selectionSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * This method implements selection sort algorithm.
     * Selects the largest element from the unsorted portion and move it to the last index of unsorted portion
     * (i.e start of sorted portion)
     * @param array array containing the elements to be sorted
     */
    private static void selectionSort(int[] array){
        for (int lastUnsorted = array.length - 1; lastUnsorted > 0; lastUnsorted--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsorted; i++) {
                if(array[i] > array[largest])
                    largest = i;
            }
            swapElement(array, largest, lastUnsorted);
        }
    }

    private static void swapElement(int[] array, int index1, int index2){
        if(index1 == index2)
            return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
}
