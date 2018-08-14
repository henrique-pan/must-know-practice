package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CounterProblem {

    public static void main(String[] args) {
        int[] array = {3, 4, 4, 6, 1, 4, 4};
        int n = 5;

        System.out.println(Arrays.toString(solution(n, array)));
    }

    private static int[] solution(int n, int[] a) {
        int[] counters = new int[n];

        // boolean changed = false;
        int maxToUpdate = 0;
        int currentMax = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int v = a[i];

            if (v == n + 1) { // UPDATE MAX
                maxToUpdate = currentMax;
            } else {
                int newValue;
                if (map.containsKey(v)) {
                    int actualValue = map.get(v);

                    if (actualValue >= maxToUpdate) {
                        newValue = actualValue + 1;
                    } else {
                        newValue = maxToUpdate + 1;
                    }
                } else {
                    newValue = maxToUpdate + 1;
                }

                map.put(v, newValue);
                if (currentMax < newValue) currentMax = newValue;
            }

        }

        for (int i = 0; i < n; i++) {
            if(map.containsKey(i+1)) {
                int actualValue = map.get(i + 1);
                if(actualValue < maxToUpdate) {
                    counters[i] = maxToUpdate;
                } else {
                    counters[i] = actualValue;
                }
            } else {
                counters[i] = maxToUpdate;
            }
        }

        return counters;
    }
}
