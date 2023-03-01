import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * Pascal's Triangle
 */

// @lc code=start
class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        list.add(result);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> temp=list.get(i-1);
            for (int j = 0; j < temp.size()-1; j++) {
                row.add(temp.get(j)+temp.get(j+1));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numRows = Integer.parseInt(line);

            List<List<Integer>> ret = new PascalTriangle_118().generate(numRows);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
// @lc code=end

