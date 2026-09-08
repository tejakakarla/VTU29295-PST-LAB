import java.util.*;

class Result {

    public static void matrixRotation(
            List<List<Integer>> matrix,
            int r) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> values = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = rows - layer - 1;
            int right = cols - layer - 1;

            // Top row
            for (int j = left; j <= right; j++) {
                values.add(arr[top][j]);
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                values.add(arr[i][right]);
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                values.add(arr[bottom][j]);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                values.add(arr[i][left]);
            }

            // Rotate
            int size = values.size();
            int shift = r % size;

            List<Integer> rotated = new ArrayList<>();

            for (int i = shift; i < size; i++) {
                rotated.add(values.get(i));
            }

            for (int i = 0; i < shift; i++) {
                rotated.add(values.get(i));
            }

            int index = 0;

            // Put values back

            // Top row
            for (int j = left; j <= right; j++) {
                arr[top][j] = rotated.get(index++);
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                arr[i][right] = rotated.get(index++);
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                arr[bottom][j] = rotated.get(index++);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                arr[i][left] = rotated.get(index++);
            }
        }

        // Print result
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(arr[i][j]);

                if (j < cols - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
