package algorithms.classic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HeapArray implements Heap {

    private static final int INITIAL_CAPACITY = 10;
    private int[] array;
    private int size;
    private int totalElements;

    public HeapArray() {
        totalElements = 0;
        size = INITIAL_CAPACITY;
        array = new int[INITIAL_CAPACITY];
        insureCapacity();
    }

    public Integer find() {
        if(size <= 0 || totalElements == 0) return null;
        return array[0];
    }

    public void add(int e) {
        insureCapacity();

        array[totalElements] = e;

        heapfyUp(totalElements++);
    }

    public Integer extract() {
        if(size <= 0 || totalElements == 0) return null;
        int min = array[0];
        array[0] = array[--totalElements];
        array[totalElements] = 0;

        heapfyDown(0);

        insureCapacity();

        return min;
    }

    public void delete() {
        extract();
    }

    public void replace(int oldValue, int newValue) {
        for(int i = 0; i < totalElements; i++) {
            if(array[i] == oldValue) {
                array[i] = newValue;

                int parent = (i - 1)/2;
                if(parent < 0) return;

                if(array[i] < array[parent]) heapfyUp(i);
                else heapfyDown(i);
            }
        }
    }

    // Heap Support
    private void heapfyUp(int position) {
        int parent = (position - 1)/2;

        if(parent < 0) return;

        if(array[parent] > array[position]) {
            swap(parent, position);
            heapfyUp(parent);
        }
    }

    private void heapfyDown(int position) {
        int leftNode = (position * 2) + 1;
        int rightNode = (position * 2) + 2;
        int nextNode = position;

        if(leftNode < totalElements && array[leftNode] < array[nextNode]) {
            nextNode = leftNode;
        }

        if(rightNode < totalElements && array[rightNode] < array[nextNode]) {
            nextNode = rightNode;
        }

        if(nextNode != position) {
            swap(nextNode, position);
            heapfyDown(nextNode);
        }

    }

    private void insureCapacity() {
        if(size <= 0) {
            array = new int[INITIAL_CAPACITY];
        } else if(totalElements == size - 1) {
            size += INITIAL_CAPACITY;
            array = Arrays.copyOf(array, size);
        } else if(totalElements < size - INITIAL_CAPACITY) {
            size -= INITIAL_CAPACITY;
            array = Arrays.copyOf(array, size);
        }
    }

    private void swap(int newIndex, int oldIndex) {
        int t = array[newIndex];
        array[newIndex] = array[oldIndex];
        array[oldIndex] = t;
    }
    // Heap Support


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        List<String> list = new LinkedList<>();
        for(int i = 0; i < totalElements; i++) {
            list.add(String.valueOf(array[i]));
        }

        sb.append(String.join(", ", list));

        sb.append("]");

        return sb.toString();
    }
}
