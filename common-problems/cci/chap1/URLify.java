import java.util.*;

public class URLify {

	public static void main(String[] args) {

		String s = "Mr John Smith    ";
		int length = s.length();
		System.out.println("URLify (" + s + "): " + urlify(s, length));

	}

	private static String urlify(String s, int length) {
		char[] c = s.toCharArray();
		char[] result = new char[length];

		int outputIndex = 0;
		for(int i = 0; (i < length && outputIndex != length); i++) {
			if(c[i] == ' ') {
				result[outputIndex++] = '%';
				result[outputIndex++] = '2';
				result[outputIndex++] = '0';
			} else {
				result[outputIndex++] = c[i];
			}
		}

		return new String(result);
	}

	private static String goodSolution(String s, int length) {
		return "";
	}

}









