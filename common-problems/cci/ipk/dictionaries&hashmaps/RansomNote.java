package algorithms.cci1;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        String magazine = "two times three is not four";
        String note = "two times two is four";


        checkMagazine(magazine.split(" "), note.split(" "));
    }

    private static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : magazine) {
            if (map.containsKey(word)) {
                Integer total = map.get(word);
                map.put(word, total + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String word : note) {
            if (map.containsKey(word) && map.get(word) > 0) {
                Integer total = map.get(word);
                map.put(word, total - 1);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }


}
