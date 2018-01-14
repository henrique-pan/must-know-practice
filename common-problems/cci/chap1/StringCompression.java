import java.util.*;

public class StringCompression {

	public static void main(String[] args) {

		String s = "aabcccccaaa";

		System.out.println("String Compression (" + s + "): " + stringCompression(s));

		System.out.println("String Compression (" + s + "): " + goodSolution(s));

		System.out.println("String Compression (" + s + "): " + compress(s));
	}

	// My Solution
	private static String stringCompression(String s) {
		StringBuilder result = new StringBuilder();

		char[] c = s.toCharArray();

		int currentIndex = 0;
		while(currentIndex < s.length()) {
			int nextChar = currentIndex + 1;
			int counter = 1;
			while(nextChar < s.length() && c[currentIndex] == c[nextChar]) {
				counter++;
				nextChar++;
			}

			result.append(c[currentIndex]).append(Character.forDigit(counter, 10));

			currentIndex = nextChar;
		}

		return new String(result);
	}

	//Suggested Improvement
	private static String goodSolution(String s) {
		StringBuilder sb = new StringBuilder();

		int countConsecutive = 0;
		for(int i = 0; i < s.length(); i++) {
			countConsecutive++;

			if((i + 1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));
				sb.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return sb.length() < s.length() ? sb.toString() : s;
	}

	// Best Solution
	private static String compress(String s) {
		int finalLength = countCompression(s);
		if(finalLength >= s.length()) {
			return s;
		}


		StringBuilder sb = new StringBuilder(finalLength);

		int countConsecutive = 0;
		for(int i = 0; i < s.length(); i++) {
			countConsecutive++;

			if((i + 1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));
				sb.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return sb.toString();
	}

	private static int countCompression(String s) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for(int i = 0; i < s.length(); i++) {
			countConsecutive++;

			if((i + 1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedLength += 1 + (String.valueOf(countConsecutive).length());
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

}









