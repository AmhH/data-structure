package com.udemy.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * Start from the left side of the array and increase the sorted size by sorting and adding the left element from
     * the unsorted partition by finding the insertion position. When traversing in the sorted section if we found
     * element greater than that element all elements right side are grater  because it is already sorted
     *
     * increase sorted partion from 1 to array length
     * @param array array containing the elements to be sorted
     */
    private static void insertionSort(int[] array){
        for (int firstUnsorted = 1; firstUnsorted < array.length; firstUnsorted++){
            int newElement = array[firstUnsorted];
            int i;

            for (i = firstUnsorted; i > 0 && array[i-1] > newElement; i--){
                array[i] = array[i-1];
            }
            array[i] = newElement;
        }
    }
}
