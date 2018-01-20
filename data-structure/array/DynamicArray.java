import java.util.Arrays;

class DynamicArray<T> {

    private transient Object[] data;
    
    private int size;

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.data = new Object[initialCapacity];
    }

    public DynamicArray() {
        this(10);
    }

    public boolean add(T element) {
        ensureCapacity();
        data[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkRange(index);
        return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        checkRange(index);

        T oldValue = (T) data[index];
        data[index] = element;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        // Evaluate if the range is valide
        checkRange(index);

        T removedElement = (T) data[index];

        // If the index is not the last element: shift to the left
        if(index < (size - 1)) {
            for(int i = index; i < (size - 1); i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
        }
        // Subtract from the total of elements
        size--;

        // Reduce Capacity
        ensureCapacity();

        return removedElement;
    }

    private void ensureCapacity() {
        if ((size + 1) > data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity * 2;
            data = Arrays.copyOf(data, newCapacity);
        } else if ((data.length / 2) > size) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity / 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkRange(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<> ();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(null);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }

        //list.get(10); ERROR!

        list = new DynamicArray<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        int index = 4;
        list.remove(index);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

}