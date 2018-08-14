package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public int solution(int[] a) {
        if(a.length <= 0) return -1;
        int maxReps = 0;
        int maxRepsIndex = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < a.length; i++) {
            int v = a[i];

            int newValue;
            if(map.containsKey(v)) {
                int totalReps = map.get(v);
                newValue = totalReps + 1;
            } else {
                newValue = 1;
            }

            map.put(v, newValue);

            if(maxReps < newValue) {
                maxReps = newValue;
                maxRepsIndex = i;
            }
        }

        return (maxReps > a.length / 2) ? maxRepsIndex : -1;
    }

}
