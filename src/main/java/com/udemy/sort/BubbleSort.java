package com.udemy.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        bubbleSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * O(n2) n square
     * This algorithm is one implementation of bubble sort
     * Bubbling te larger element to end of the index
     * @param array
     */
    public static void bubbleSort(int[] array){
        for (int lastUnsorted = array.length-1; lastUnsorted > 0 ; lastUnsorted--) {
            for (int i = 0; i < lastUnsorted; i++) {
                if(array[i] > array[i+1]){
                    swapElement(array, i, i+1);
                }
            }

        }

    }

    public static void swapElement(int[] array, int index1, int index2){
        if(index1 == index2)
            return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
}
