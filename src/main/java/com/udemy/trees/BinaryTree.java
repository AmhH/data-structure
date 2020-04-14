package com.udemy.trees;

public class BinaryTree {

    public static void main(String[] args) {
        int[] array = new int[]{25, 20, 15, 27, 30, 29, 26, 22, 32, 17};

        Tree tree = new Tree();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.traverseInOrder();
        System.out.println();
        System.out.println(tree.get(27));
        System.out.println(tree.get(17));
        System.out.println(tree.get(227));

        System.out.println("-------------------------");

        System.out.println(tree.min());
        System.out.println(tree.max());

        System.out.println("-------------------------");
        tree.delete(15);
        tree.traverseInOrder();
        System.out.println("");
        tree.delete(17);
        tree.traverseInOrder();
        System.out.println("");
        tree.delete(25);
        tree.traverseInOrder();
        System.out.println();
        System.out.println("-------------------------");

        tree.traversePreOrder();
        System.out.println();
        System.out.println("-------------------------");

        tree.traversePostOrder();
        System.out.println();
    }
}
