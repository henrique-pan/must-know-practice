import java.util.*;

class MaxIntHeap {
    
    private int[] heap;

    private int size;

    public Heap() {
        heap = new int[10];
        size = 0;
    }

    public int find() {
        if(size > 0) {
            return heap[0];    
        } else {
            return -1;
        }
        
    }

    public void add(int element) {
        ensureCapacity();
        int nextSpotIndex = getNextSpot();

        heap[nextSpotIndex] = element;
        size++;

        // Move Up
        moveUp(nextSpotIndex);

    }

    public int pop() {
        if(size > 0) {
            int value = heap[0];
            int lastSpot = getLastSpot();
            heap[0] = heap[lastSpot];

            size--;

            heapifyUp();

            ensureCapacity();
            return value;
        } else {
            return -1;
        }
    }

    public void remove() {
        if(size > 0) {
            int lastSpot = getLastSpot();
            heap[0] = heap[lastSpot];

            size--;

            heapifyDown();

            ensureCapacity();
        } 
    }

    // GET SPOT INDEX
    private int getNextSpot() {
        return size;
    }

    private int getLastSpot() {
        return size - 1;
    }


    // UTILS
    private void ensureCapacity() {
        if(size + 1 > heap.length) {
            int oldCapacity = heap.length;
            int newCapacity = oldCapacity * 2;
            heap = Arrays.copyOf(heap, newCapacity);
        } else if(heap.length / 2 > size) {
            int oldCapacity = heap.length;
            int newCapacity = oldCapacity / 2;
            heap = Arrays.copyOf(heap, newCapacity);
        }
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;    
        while(parentIndex >= 0 && heap[index] > heap[parentIndex]) {
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;

            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;

        while(index < size && (heap[index] < heap[leftChild] || heap[index] < heap[rightChild])) {
            int largestValueIndex;

            if(heap[leftChild] > heap[rightChild]) {
                largestValueIndex = leftChild;
            } else {
                largestValueIndex = rightChild;
            }

            int temp = heap[index];
            heap[index] = heap[largestValueIndex];
            heap[largestValueIndex] = temp;

            index = largestValueIndex;
            leftChild = (index * 2) + 1;
            rightChild = (index * 2) + 2;
        }
    }

    public static void main(String[] args) {
        MaxIntHeap heap = new MaxIntHeap();

        heap.add(4);    
        heap.printHeap();

        heap.add(10);    
        heap.printHeap();

        heap.add(5);    
        heap.printHeap();

        heap.add(2);    
        heap.printHeap();

        heap.add(11);    
        heap.printHeap();

        heap.remove();    
        heap.printHeap();
    }

    public void printHeap() {
        for(int i = 0; i < size; i++) {
            System.out.println(i + " : " + heap[i]);
        }
        System.out.println("");
    }


}