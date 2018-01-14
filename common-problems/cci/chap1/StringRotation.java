import java.util.*;

public class StringRotation {

	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + rotation);
		}
	}

	private static boolean isRotation(String s1, String s2) {
		if(s1.length() == s2.length() && s1.length() > 0) {
			String doubleString = s1 + s1;
			return isSubstring(doubleString, s2);
		}
		return false;
	}

	private static boolean isSubstring(String s1, String s2) {
		if(s1.indexOf(s2) >= 0) {
			return true;
		}
		return false;
	}

}









