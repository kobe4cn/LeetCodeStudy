import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//51. N 皇后
public class N_Queens_51 {
    //LinkedList<String> list = new LinkedList<>();
    List<List<String>> result = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] c : chars
        ) {
            Arrays.fill(c, '.');
        }
        backtracking(n, 0,  chars);
        return result;
    }

    public void backtracking(int n, int startindex, char[][] nums) {
        if (startindex == n) {
            List<String> list=new ArrayList<>();
            for (char[] c:nums
                 ) {
                list.add(String.copyValueOf(c));
            }
            result.add(list);
            return;

        }

        for (int j = 0; j < n; j++) {
            if (isValid(startindex, j, n, nums)) {

                nums[startindex][j] = 'Q';
                backtracking(n, startindex + 1, nums);
                nums[startindex][j] = '.';

            }

        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[row][i] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
