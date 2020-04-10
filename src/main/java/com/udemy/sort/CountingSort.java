package com.udemy.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        countingSort(intArray, 1, 10);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * Makes assumptions about data, non-negative discrete values only
     * two phases phase one: traverse and count how many off each value we have
     * phase two: write values back to input array
     * @param array array to be sorted
     * @param min minimum value in the array
     * @param max maximum value in the array
     */
    public static void countingSort(int[] array, int min, int max){

        int[] countArray = new int[(max-min)+1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0){
                array[j++] = i;
                countArray[i - min]--;
            }
        }

    }
}
