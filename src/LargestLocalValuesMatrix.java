/*
 * @lc app=leetcode.cn id=2373 lang=java
 *
 * [2373] 矩阵中的局部最大值
 */

// @lc code=start
public class  LargestLocalValuesMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int[][] maxLocal=new int[n-2][n-2];
        
        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal.length; j++) {
                // get local max value
                int max=0;
                int x=i+1;
                int y=j+1;
                max=getMaxLocal(x,y,grid);
                maxLocal[i][j]=max;
            }

        }
        return maxLocal;

    }

    public int getMaxLocal(int x,int y,int[][] grid){
        int max=0;
        max=Math.max(max, grid[x-1][y-1]);
        max=Math.max(max, grid[x-1][y]);
        max=Math.max(max, grid[x-1][y+1]);
        max=Math.max(max, grid[x][y-1]);
        max=Math.max(max, grid[x][y]);
        max=Math.max(max, grid[x][y+1]);
        max=Math.max(max, grid[x+1][y-1]);
        max=Math.max(max, grid[x+1][y]);
        max=Math.max(max, grid[x+1][y+1]);
        return max;
    }
}
// @lc code=end

