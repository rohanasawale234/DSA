package Medium;

class PeakIn2D {
    private static int max(int[][] nums, int n, int m, int col) {
        int maxVal = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][col] > maxVal) {
                maxVal = nums[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIndex = max(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;

            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[] { maxRowIndex, mid };
            } else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 4},
            {3, 2}
        };

        int[] ans = findPeakGrid(mat);
        System.out.println("Peak position: [" + ans[0] + ", " + ans[1] + "]");
    }
}