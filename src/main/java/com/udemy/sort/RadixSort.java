package com.udemy.sort;


import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] intArray = new int[]{4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(intArray, 10, 4);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     *
     * Assumes data must have same radix and width
     * starts from the rightmost position. Must use stable sort algorithm at each stage
     *
     * @param array array to be sorted
     * @param radix the radix of element data type
     * @param width with of the elements
     */
    public static void radixSort(int[] array, int radix, int width){
        for (int i = 0; i < width; i++) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(int[] array, int position, int radix) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (int value : array){
            countArray[getDigit(position, value, radix)]++;
        }

        //Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        for (int i = 0; i < numItems; i++) {
            array[i] = temp[i];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }
}
