package com.udemy.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        shellSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * Variation of insertion sort. Insertion sort uses gap of 1 shell sort starts using larger gap value.
     * As the algorithm runs the gap is reduced in turn reduces amount of shifting required
     * @param array unsorted array
     */
    private static void shellSort(int[] array){
        for (int gap = array.length /2; gap > 0; gap /=2){

            for (int i = gap; i < array.length; i++){
                int newElement = array[i];
                int j = i;
                while(j >= gap && array[j-gap] > newElement){
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }
}
