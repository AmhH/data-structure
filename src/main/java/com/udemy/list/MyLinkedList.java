package com.udemy.list;

public class MyLinkedList {

    private Node head;
    private int size;

    public void add(String data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int getSize(){
        return size;
    }

    public Node remove(){
        if(isEmpty())
            return null;
        Node removed = head;
        head = head.next;
        removed.next = null;
        size--;
        return removed;

    }

    public boolean isEmpty(){
        return head == null;
    }


    class Node{
        String value;
        Node next;
        Node(String value){
            this.value = value;
        }
    }

}
