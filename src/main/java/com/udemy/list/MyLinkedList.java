package com.udemy.list;

import java.util.Iterator;
import java.util.LinkedList;

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

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("");
        Iterator<String> iterator = list.iterator();
    }

    class Node{
        String value;
        Node next;
        Node(String value){
            this.value = value;
        }
    }

}
