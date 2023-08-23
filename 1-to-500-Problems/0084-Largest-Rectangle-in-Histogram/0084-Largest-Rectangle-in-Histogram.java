class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // (index, height)

        for (int i = 0; i < heights.length; i++) {
            int startInd = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] temp = stack.pop();
                startInd = temp[0];
                int h = temp[1];
                maxArea = Math.max(maxArea, h * (i - startInd));
            }
            stack.push(new int[] { startInd, heights[i]});
        }

        int end = heights.length;
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            int start = temp[0];
            int h = temp[1];
            maxArea = Math.max(maxArea, h * (end - start));
        }

        return maxArea;
    }
}