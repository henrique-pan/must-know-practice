import java.util.*;

public class OneAway {

	public static void main(String[] args) {

		String s1 = "pale";
		String s2 = "bale";

		System.out.println("One Away (" + s1 + ", " + s2 + "): " + isOneAway(s1, s2));

	}

	private static boolean isOneAway(String s1, String s2) {
		if(s1.equals(s2)) {
			return true;
		}

		int s1Length = s1.length();
		int s2Length = s2.length();

		boolean s1Bigger = s1Length > s2Length ? true : false;
		int longest = s1Length > s2Length ? s1Length : s2Length;		

		if(Math.abs(s1Length - s2Length) > 1) {
				return false;
		}

		boolean foundDifference = false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		for(int i = 0, j = 0; i < longest; i++, j++) {
			if(c1[i] != c2[j]) {
				if(foundDifference) {
					return false;
				} else {
					foundDifference = true;
				}

				if(s1Length != s2Length) {
					if(s1Bigger) {
						j--;
					} else {
						i--;
					}
				}
			}
		}
		
		return true;
	}

	private static boolean goodSolution(String s1, String s2) {
		return true;
	}

}









