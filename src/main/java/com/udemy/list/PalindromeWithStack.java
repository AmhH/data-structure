package com.udemy.list;

import java.util.LinkedList;

public class PalindromeWithStack {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                stack.push(c);
                builder.append(c);
            }
        }

        StringBuilder reversed = new StringBuilder(stack.size());

        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        return reversed.toString().equals(builder.toString());
    }
}
