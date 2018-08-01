package algorithms;

public class Array2D {

    public static void main(String[] args) {
        int[][] matrix = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println("MAX_HOURGLASS: " + maxHourglassSum(matrix));
    }

    private static Integer maxHourglassSum(int[][] matrix) {
        if (matrix.length < 3 || matrix.length != matrix[0].length) return null;

        int currentLine = 0;
        Integer maxHourglass = null;

        int maxIndex = matrix.length - 3;
        while (currentLine <= maxIndex) {
            int currentColumn = 0;
            while (currentColumn <= maxIndex) {
                int sum = 0;

                sum += matrix[currentLine][currentColumn];
                sum += matrix[currentLine][currentColumn + 1];
                sum += matrix[currentLine][currentColumn + 2];

                sum += matrix[currentLine + 1][currentColumn + 1];

                sum += matrix[currentLine + 2][currentColumn];
                sum += matrix[currentLine + 2][currentColumn + 1];
                sum += matrix[currentLine + 2][currentColumn + 2];

                if (maxHourglass == null || sum > maxHourglass) maxHourglass = sum;

                currentColumn++;
            }

            currentLine++;
        }

        return maxHourglass;
    }

}