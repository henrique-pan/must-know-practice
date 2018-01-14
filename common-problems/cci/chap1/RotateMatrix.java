import java.util.*;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] m = new int[3][3];
		m[0][0] = 1;
		m[0][1] = 1;
		m[0][2] = 1;

		m[1][0] = 2;
		m[1][1] = 2;
		m[1][2] = 2;

		m[2][0] = 3;
		m[2][1] = 3;
		m[2][2] = 3;

		System.out.println("Matrix Before Rotation: ");
		printMatrix(m);

		//m = rotateMatrix(m);
		goodSolution(m);

		System.out.println("Matrix After Rotation: ");
		printMatrix(m);
	}

	private static int[][] rotateMatrix(int[][] m) {
		int[][] result = new int[m.length][m[0].length];

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				int line = j;
				int column = (m[i].length - 1) - i;

				result[line][column] = m[i][j];
			}
		}

		return result;
	}

	private static boolean goodSolution(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}

		int n = matrix.length;
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];

				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return true;
	}

	private static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");	
		}
	}

}









