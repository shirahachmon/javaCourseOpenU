public class Extreme {
   
    /** Main function of exercise 4.  */
    public static int extreme(int[][] mat) {
        // Start the recursion- initial parameters
        return extreme(mat, 0, 0, mat[0][0], new boolean[mat.length][mat.length]);
    }

    // Overloaded extreme method
    private static int extreme(int[][] mat, int i, int j, int currentMax, boolean[][] visited) {
        int length = mat.length;

        if (i == length - 1 && j == length - 1) return currentMax; // If last cell, return curr max
        currentMax = Math.max(currentMax, mat[i][j]); // Update the curr max value
        visited[i][j] = true; // Mark the curr cell as visited

        // Initialize the min extreme value
        int minExtreme = Integer.MAX_VALUE;

        // Recursively check all valid neighbors
        if (isValid(mat, visited, i + 1, j)) { // Down
            minExtreme = Math.min(minExtreme, extreme(mat, i + 1, j, currentMax, visited));
        }
        if (isValid(mat, visited, i - 1, j)) { // Up
            minExtreme = Math.min(minExtreme, extreme(mat, i - 1, j, currentMax, visited));
        }
        if (isValid(mat, visited, i, j + 1)) { // Right
            minExtreme = Math.min(minExtreme, extreme(mat, i, j + 1, currentMax, visited));
        }
        if (isValid(mat, visited, i, j - 1)) { // Left
            minExtreme = Math.min(minExtreme, extreme(mat, i, j - 1, currentMax, visited));
        }

        // Reset the current cell to unvisited for other paths
        visited[i][j] = false;
        return minExtreme;
    }

    // Checks if a cell is valid
    private static boolean isValid(int[][] mat, boolean[][] visited, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat.length && !visited[i][j];
    }
}
