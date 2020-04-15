package com.udemy.trees;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity){
        this.heap = new int[capacity];
    }

    /**
     * Max heap
     * First insert left most position
     * then heapify by swapping with the parent until u get the right position
     * @param value value to be inserted
     */
    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        fixHeapAbove(size);

        size++;
    }

    /**
     * Take the right most value to makes the tree complete and replace it with deleted part
     * Heapify: If replacement is greater thatn the parent fix above otherwise fix below (replace the parent with
     * larger value from the children)
     * @param index index of the element to be deleted
     * @return value that is removed
     */
    public int delete(int index){
        if(isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size - 1];
        //heap[size - 1] = 0;//might not be needed
        if(index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size - 1);
        }else {
            fixHeapAbove((index));
        }

        size--;
        return deletedValue;
    }


    public int peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        return heap[0];
    }

    private void fixHeapAbove(int index){
        int newValue = heap[index];

        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;
        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild;
                }else{
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if(heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }else {
                    break;
                }

                index = childToSwap;
            }
        }
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(0);

        heap.printHeap();

        System.out.println(heap.peek());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.offer(-22);

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
    }
}
