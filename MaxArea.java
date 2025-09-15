public class MaxArea {
    public static int maximalRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (matrix[i][j] == 1) {
                   
                    for (int x = i; x < rows; x++) {
                        for (int y = j; y < cols; y++) {
                            if (isAllOnes(matrix, i, j, x, y)) {
                                int area = (x - i + 1) * (y - j + 1);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }
        }
        return maxArea;
    }

    
    private static boolean isAllOnes(int[][] matrix, int i1, int j1, int i2, int j2) {
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (matrix[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        System.out.println("Maximum Rectangle Area = " + maximalRectangle(matrix)); 
    }
}
