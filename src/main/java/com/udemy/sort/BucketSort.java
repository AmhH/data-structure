package com.udemy.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Uses hashing. Distributes the items into buckets (Scattering) -> sort items in each bucket -> merge bucket (Gathering)
 * Values in bucket X should be greater than values in X-1 and less than values in X+1
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] intArray = {54, 46, 83, 66,95, 92, 43};
        bucketSort(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    private static void bucketSort(int[] intArray) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < intArray.length; i++) {
            buckets[hash(intArray[i])].add(intArray[i]);
        }

        for (List list : buckets) {
            Collections.sort(list);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]){
                intArray[j++] = value;
            }
        }


    }

    private static int hash(int value){
        return value / 10;
    }
}
