public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        
        for (int i = 0; i < n; i++) {
            int height = heights[i];

            
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }

            
            int right = i;
            while (right < n - 1 && heights[right + 1] >= height) {
                right++;
            }

            
            int width = right - left + 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}

