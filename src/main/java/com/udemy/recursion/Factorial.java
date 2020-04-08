package com.udemy.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(iterativeFactorial(3));
        System.out.println(iterativeFactorial(6));
        System.out.println(iterativeFactorial(18));

        System.out.println("***********************");

        System.out.println(recursiveFactorial(3));
        System.out.println(recursiveFactorial(6));
        System.out.println(recursiveFactorial(18));
    }

    public static long iterativeFactorial(int num){
        if(num == 0){
            return 1;
        }

        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static long recursiveFactorial(int num){
        if(num == 0){
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }
}
