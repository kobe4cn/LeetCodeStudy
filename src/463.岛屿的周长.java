/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// @lc code=start
class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int total=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    int incount=0;
                    //上
                    if(i>0 && grid[i-1][j]!=1){
                        incount++;
                    }else if(i==0){
                        incount++;
                    }
                    //下
                    if((i+1)<grid.length && grid[i+1][j]!=1){
                        incount++;
                    }else if(i== grid.length-1){
                        incount++;
                    }
                    //左
                    if(j>0 && grid[i][j-1]!=1){
                        incount++;
                    }else if(j==0){
                        incount++;
                    }
                    //右
                    if((j+1)<grid[i].length && grid[i][j+1]!=1){
                        incount++;
                    }else if(j==grid[i].length-1){
                        incount++;
                    }
                    total+=incount;
                }
            }
        }
        return total;
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new IslandPerimeter_463().islandPerimeter(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
// @lc code=end

