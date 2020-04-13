package com.udemy.trees;

public  class Tree{
    TreeNode root;

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else {
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if(root != null)
            root.traverseInOrder();
    }

    public void traversePreOrder(){
        if(root != null)
            root.traversePreOrder();
    }

    public void traversePostOrder(){
        if(root != null)
            root.traversePostOrder();
    }

    public TreeNode get(int value){
        if(root != null)
            return root.get(value);

        return null;
    }

    public void delete(int value){
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if(subTreeRoot == null)
            return subTreeRoot;

        if(value < subTreeRoot.data)
            subTreeRoot.leftNode = delete(subTreeRoot.leftNode, value);
        else if(value > subTreeRoot.data)
            subTreeRoot.rightNode = delete(subTreeRoot.rightNode, value);
        else {
            // case 1 and 2: node to delete has 0 or 1 children
            if(subTreeRoot.leftNode == null){
                return subTreeRoot.rightNode;
            }else  if(subTreeRoot.rightNode == null)
                return subTreeRoot.leftNode;
            /**case 3: node ro delete has 2 children
             * Replace the value in the subtreeRoot node with the smallest value from the right subtree
             */
            subTreeRoot.data = subTreeRoot.rightNode.min();
            //delete the node that has the smallest value in the subtree
            subTreeRoot.rightNode = delete(subTreeRoot.rightNode, subTreeRoot.data);
        }
        return subTreeRoot;
    }

    public int min(){
        if(root == null)
            return Integer.MIN_VALUE;
        else
            return root.min();
    }

    public int max(){
        if(root == null)
            return Integer.MAX_VALUE;
        else
            return root.max();
    }
}