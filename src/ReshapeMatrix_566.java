import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class ReshapeMatrix_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x=mat.length;
        int y=mat[0].length;
        List<Integer> xs = new ArrayList<Integer>();
        if(x*y==r*c){
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    xs.add(mat[i][j]);
                }
            }
            int[][] rc=new int[r][c];
            int count=0;
            for (int i = 0; i < rc.length; i++) {
                for (int j = 0; j < rc[i].length; j++) {
                    rc[i][j]=xs.get(count++);
                }
            }
            return rc;
        }else{
            return mat;
        }
    }
}
// @lc code=end

