import java.util.*;

public class IsUnique {
	public static void main(String[] args) {

		String s = "Teste 1";

		System.out.println("Is All Unique (" + s + "): " + isAllUnique(s));

		s = "Tesi 2";

		System.out.println("Is All Unique (" + s + "): " + isAllUnique(s));

		// Is Unique Without other Data Structure

		s = "Teste 3";

		System.out.println("Is All Unique (" + s + "): " + isAllUniqueWithoutDataStructure(s));

		s = "Tesa 4";

		System.out.println("Is All Unique (" + s + "): " + isAllUniqueWithoutDataStructure(s));
	}


	private static boolean isAllUnique(String s) {
		char[] charArray = s.toCharArray();

		Set<Character> set = new HashSet<Character>();

		for(int i = 0; i < charArray.length; i++) {
			if(set.contains(charArray[i])) {
				return false;
			} else {
				set.add(charArray[i]);
			}
		}

		return true;
	}

	private static boolean isAllUniqueWithoutDataStructure(String s) {
		char[] charArray = s.toCharArray();

		for(int i = 0; i < charArray.length; i++) {
			for(int j = (i+1); j < charArray.length; j++) {
				if(charArray[i] == charArray[j]) {
					return false;
				}
			}			
		}

		return true;
	}

	private static boolean goodSolution(String s) {
		if(s.length() > 128) {
			return false;
		}

		boolean[] charset = new boolean[128];
		for(int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if(charset[val]) {
				return false;
			} else {
				charset[val] = 	true;
			}
		}
		return true;
	}

	private static boolean goodSolutionWithoutDataStructure(String s) {
		int checker = 0;

		for(int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				return false;
			}	
			checker |= (1 << val);
		}
		return true;
	}

}









