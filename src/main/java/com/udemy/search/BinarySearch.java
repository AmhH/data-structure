package com.udemy.search;

/**
 * Data must be sorted.
 * Compare the middle value against the search value. If equal we are done.
 * If element is greater than the value search to the left of array
 * If element is less than the value search to the right of array
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 35));
        System.out.println(iterativeBinarySearch(intArray, 888));
        System.out.println(iterativeBinarySearch(intArray, 1));

        System.out.println("----------------------------------");

        System.out.println(recursiveBinarySearch(intArray, -15));
        System.out.println(recursiveBinarySearch(intArray, 35));
        System.out.println(recursiveBinarySearch(intArray, 888));
        System.out.println(recursiveBinarySearch(intArray, 1));
    }



    public static int iterativeBinarySearch(int[] input, int value){

        int start = 0;
        int end = input.length; //one grater than the last index

        while(start < end){
            int mid = (start + end) / 2;
            System.out.println("midpoint = " + mid);
            if(input[mid] == value){
                return mid;
            } else if (input[mid] < value){
                start = mid +1;
            }else {
                end = mid;
            }
        }
        return -1;
    }

    private static int recursiveBinarySearch(int[] intArray, int value) {

        return recursiveBinarySearch(intArray, 0, intArray.length, value);
    }

    private static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if(start >= end){
            return -1;
        }
        int mid = (start + end) / 2;
        System.out.println("midpoint = " + mid);
        if(input[mid] == value)
            return mid;
        else if(input[mid] < value)
            return recursiveBinarySearch(input, mid + 1, end, value);
        else
            return recursiveBinarySearch(input, start, mid, value);
    }
}
