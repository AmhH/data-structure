package com.udemy.trees;

public class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (data == value)
            return;

        if (value < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(value);
            } else {
                leftNode.insert(value);
            }
        } else {
            if (rightNode == null) {
                rightNode = new TreeNode(value);
            } else {
                rightNode.insert(value);
            }
        }
    }

    public void traverseInOrder(){
        if(leftNode != null)
            leftNode.traverseInOrder();

        System.out.print(data + ", ");

        if(rightNode != null)
            rightNode.traverseInOrder();
    }

    public void traversePreOrder(){
        System.out.print(data + ", ");
        if(leftNode != null) {
            leftNode.traversePreOrder();
        }

        if(rightNode != null)
            rightNode.traversePreOrder();
    }

    public void traversePostOrder(){
        if(leftNode != null) {
            leftNode.traversePostOrder();
        }

        if(rightNode != null)
            rightNode.traversePostOrder();
        System.out.print(data + ", ");
    }

    public TreeNode get(int value){
        if(value == data)
            return this;
        if(value < data){
            if(leftNode != null)
                return leftNode.get(value);
        }else{
            if(rightNode != null)
                return rightNode.get(value);
        }

        return null;
    }

    public int min(){
        if(leftNode == null)
            return data;
        else
            return leftNode.min();
    }

    public int max(){
        if(rightNode == null)
            return data;
        else
            return rightNode.max();
    }

    public String toString() {
        return "Data = " + data;
    }
}
