import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1260. 二维网格迁移
public class Shift_2D_Grid_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] gridfinal=grid;
        for (int i = 1; i <= k; i++) {
            grid=gridfinal;
            gridfinal=new int[grid.length][grid[0].length];
            for (int j = 0; j < grid.length; j++) {
                for (int l = 0; l < grid[j].length-1; l++) {
                    gridfinal[j][l+1]=grid[j][l];
                }

                if(j<grid.length-1){
                    gridfinal[j+1][0]=grid[j][grid[j].length-1];
                }
            }
            gridfinal[0][0]=grid[grid.length-1][grid[0].length-1];
        }
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < gridfinal.length; i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < gridfinal[i].length; j++) {
                temp.add(gridfinal[i][j]);
            }
            list.add(temp);
        }
        return list;
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
            int[][] grid = stringToInt2dArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            List<List<Integer>> ret = new Shift_2D_Grid_1260().shiftGrid(grid, k);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
