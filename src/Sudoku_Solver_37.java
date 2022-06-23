//37. 解数独
public class Sudoku_Solver_37 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
//        return;
    }

    public boolean backtracking(char[][] board) {
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                if (board[k][i] == '.') {
                    for (char j = '1'; j <= '9'; j++) {
                        if (checkvalid(board, k, i, j)) {
                            board[k][i] = j;
                            if (backtracking(board)) return true;
                            board[k][i] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkvalid(char[][] board, int row, int col, char value) {
        // 检查列
        for (int i = 0; i < 9; ++i) { // 相当于剪枝
            if (board[i][col] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; ++i) { // 相当于剪枝
            if (board[row][i] == value) {
                return false;
            }
        }

        //判断3*3宫内是否满足

        int rowx = 0;
        int rowy = 0;
        int colx = 0;
        int coly = 0;
        if (row >= 0 && row < 3) {
            rowx = 0;
            rowy = 3;
        }
        if (row >= 3 && row < 6) {
            rowx = 3;
            rowy = 6;
        }
        if (row >= 6 && row < 9) {
            rowx = 6;
            rowy = 9;
        }

        if (col >= 0 && col < 3) {
            colx = 0;
            coly = 3;
        }
        if (col >= 3 && col < 6) {
            colx = 3;
            coly = 6;
        }
        if (col >= 6 && col < 9) {
            colx = 6;
            coly = 9;
        }

        if (!checksamll(board, rowx, rowy, colx, coly, value)) {
            return false;
        }

        return true;

    }

    public boolean checksamll(char[][] board, int rowx, int rowy, int colx, int coly, char value) {
        for (int i = rowx; i < rowy; i++) {
            for (int j = colx; j < coly; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        new Sudoku_Solver_37().solveSudoku(board);
    }


}
