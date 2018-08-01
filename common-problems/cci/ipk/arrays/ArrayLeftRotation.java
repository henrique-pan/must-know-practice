package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayLeftRotation {

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            int[] result = rotLeft(a, d);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }
    }

    // NAIVE
    private static int[] rotLeftNaive(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                int t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
            }
        }
        return a;
    }

    private static int[] rotLeft(int[] a, int d) {
        if(a.length <= 1) return a;

        int[] resultArray = new int[a.length];
        int resultIndex = 0;

        for(int i = d; i < a.length; i++) {
            resultArray[resultIndex++] = a[i];
        }

        for(int i = 0; i < d; i++) {
            resultArray[resultIndex++] = a[i];
        }

        return resultArray;
    }

}
