import java.util.*;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] m = new int[3][3];
		m[0][0] = 1;
		m[0][1] = 1;
		m[0][2] = 1;

		m[1][0] = 1;
		m[1][1] = 0;
		m[1][2] = 1;

		m[2][0] = 1;
		m[2][1] = 1;
		m[2][2] = 1;

		System.out.println("Matrix Before Rotation: ");
		printMatrix(m);

		zeroMatrix(m);

		System.out.println("Matrix After Rotation: ");
		printMatrix(m);
	}

	private static void zeroMatrix(int[][] m) {
		boolean[][] zeros = new boolean[m.length][m[0].length];

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 0) {
					zeros[i][j] = true;
				}
			}
		}

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if(zeros[i][j]) {
					nullifyLines(m, i);
					nullifyColumns(m, j);
				}
			}
		}
	}

	private static void nullifyColumns(int[][] m, int column) {
		for(int i = 0; i < m[0].length; i++) {
			m[i][column] = 0;
		}
	}

	private static void nullifyLines(int[][] m, int lines) {
		for(int i = 0; i < m.length; i++) {
			m[lines][i] = 0;
		}
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









