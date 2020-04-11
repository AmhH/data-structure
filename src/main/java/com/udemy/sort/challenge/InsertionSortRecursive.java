package com.udemy.sort.challenge;

import java.util.Arrays;

public class InsertionSortRecursive {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(intArray, intArray.length);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * Start from the left side of the array and increase the sorted size by sorting and adding the left element from
     * the unsorted partition by finding the insertion position. When traversing in the sorted section if we found
     * element greater than that element all elements right side are grater  because it is already sorted
     *
     * increase sorted partition from 1 to array length
     * @param array array containing the elements to be sorted
     */

    public static void insertionSort(int[] array, int numItems){
        if(numItems < 2)
            return;

        insertionSort(array, numItems -1);

        int newElement = array[numItems -1];
        int i;

        for (i = numItems -1; i > 0 && array[i-1] > newElement; i--){
            array[i] = array[i-1];
        }
        array[i] = newElement;
        System.out.println("Result of call when numItems = " + numItems);
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------");
    }
}
