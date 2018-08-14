package algorithms;

import java.util.Arrays;

public class CyclicRotation {


    public static void main(String[] args) {
        int[] array = { -1, -2, -3, -4, -5, -6, - 7};
        int k = 50;

        System.out.println(Arrays.toString(rightRotation(array, k)));
    }


    private static int[] rightRotation(int[] array, int k) {
        int size = array.length;

        if(size <= 1 || size == k || k % size == 0) return array;
        if(size < k) k %= size;

        int[] result = new int[size];

        int currentIndex = 0;
        for(int i = size - k; i < size; i++) {
            result[currentIndex++] = array[i];
        }

        for(int i = 0; i < size - k; i++) {
            result[currentIndex++] = array[i];
        }

        return result;
    }

}
