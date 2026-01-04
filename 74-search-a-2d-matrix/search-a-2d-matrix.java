class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows / 2;
        int top = 0;
        int bottom = rows - 1;

        // Binary search over rows
        while (top <= bottom) {
            row = top + (bottom - top) / 2;

            int leftVal = matrix[row][0];
            int rightVal = matrix[row][cols - 1];

            if (target < leftVal) {
                bottom = row - 1;

            } else if (target > rightVal) {
                top = row + 1;

            } else {
                // Found correct row
                // Standard binary search within row
                int left = 0;
                int right = cols - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (matrix[row][mid] == target) {
                        return true;
                    } else if (matrix[row][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                return false;
            }
        }

        return false;        
    }
}

// Notes

// Binary Search for correct Row via range
// Then standard binary search for target