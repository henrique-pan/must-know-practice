import java.util.*;

public class CheckPermutation {

	public static void main(String[] args) {

		String s1 = "teste";
		String s2 = "etset";

		System.out.println("Is Permutation (" + s1 + ", " + s2 + "): " + isPermutation(s1, s2));
		System.out.println("Good Solution (" + s1 + ", " + s2 + "): " + goodSolution(s1, s2));

		s1 = "teste";
		s2 = "etsee";

		System.out.println("Is Permutation (" + s1 + ", " + s2 + "): " + isPermutation(s1, s2));
		System.out.println("Good Solution (" + s1 + ", " + s2 + "): " + goodSolution(s1, s2));

	}

	private static boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false; 
		} else {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();

			Arrays.sort(c1);
			Arrays.sort(c2);

			s1 = new String(c1);
			s2 = new String(c2);

			if(s1.equals(s2)) {
				return true;
			} else {
				return false;
			}
		}
	}

	private static boolean goodSolution(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false; 
		} else {
			int[] counter = new int[128];

			char[] c1 = s1.toCharArray();
			for(int c : c1) {
				counter[c]++;
			}
			
			char[] c2 = s2.toCharArray();
			for(int c : c2) {
				counter[c]--;
				if(counter[c] < 0) {
					return false;
				}
			}

			return true;
		}
	}

}









