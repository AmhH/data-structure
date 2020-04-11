package com.udemy.sort.challenge;


import java.util.Arrays;

public class RadixSortString {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(stringArray, 26, 5);
        System.out.println(Arrays.toString(stringArray));
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
    public static void radixSort(String[] array, int radix, int width){
        for (int i = width-1; i >= 0; i--) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(String[] array, int position, int radix) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (String value : array){
            countArray[getIndex(position, value)]++;
        }

        //Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j-1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, array[tempIndex])]] = array[tempIndex];
        }

        for (int i = 0; i < numItems; i++) {
            array[i] = temp[i];
        }
    }

   public static int getIndex(int position, String value){
        return value.charAt(position) - 'a';
   }
}
