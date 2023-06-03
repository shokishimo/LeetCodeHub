class Solution {
    int row;
    int col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        row = heights.length;
        col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, pac, heights[0][i]);
            dfs(heights, row-1, i, atl, heights[row-1][i]);
        }
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, col-1, atl, heights[i][col-1]);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] set, int prevHeight) {
       if (r < 0 || r >= row || c < 0 || c >= col || set[r][c] || prevHeight > heights[r][c]) return;

       set[r][c] = true;
       dfs(heights, r+1, c, set, heights[r][c]);
       dfs(heights, r-1, c, set, heights[r][c]);
       dfs(heights, r, c+1, set, heights[r][c]);
       dfs(heights, r, c-1, set, heights[r][c]);
    }
}