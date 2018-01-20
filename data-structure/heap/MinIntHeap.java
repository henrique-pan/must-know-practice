import java.util.Arrays;
 
public class MinIntHeap {
    
    private int[] heap;

    private int size;

    public MinIntHeap() {
        heap = new int[10];
        size = 0;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }
     
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }
     
    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
     
    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (parentIndex * 2) + 2;
    }

    private int getParentIndex(int index) {
        return (childIndex - 1) / 2;
    }
     
    private boolean hasLeftChild (int index) {
        return (getLeftChildIndex(index) < size);
    }

    private boolean hasRightChild (int index) {
        return (getRightChildIndex(index) < size);
    }

    private boolean hasParent(int index) {
        return (getParentIndex(index) >= 0);
    }
     
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    private int parent(int index) {
        return items[getParentIndex(index)];
    }
     
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = items[indexOne];
    }
    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            this.capacity *= 2;
        }
    }
     
    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
     
    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
             
            if(items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
         
        }
    }
}