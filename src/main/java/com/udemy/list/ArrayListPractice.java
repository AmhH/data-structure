package com.udemy.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListPractice {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("1");
        Object[] objects1 = objects.toArray();
        String[] objects2 = objects.toArray(new String[3]);
        List<String> vector = new Vector<>();
    }
}
