/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class PascalTriangleII_119 {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        list.add(result);
        for (int i = 1; i <=numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> temp=list.get(i-1);
            for (int j = 0; j < temp.size()-1; j++) {
                row.add(temp.get(j)+temp.get(j+1));
            }
            row.add(1);
            list.add(row);
        }
        return list.get(numRows);
    }
}
// @lc code=end

