import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1252. 奇数值单元格的数目
public class Cells_with_Odd_Values_in_a_Matrix_1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] values = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
                //遍历某一行的所有列

            for (int j = 0; j <values[indices[i][0]].length; j++) {
                 values[indices[i][0]][j]+=1;
            }
            //
            for (int j = 0; j < values.length; j++) {
                //遍历某一列的所有行
                values[j][indices[i][1]]+=1;
            }
        }
        int count=0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if(values[i][j]%2!=0){
                    count++;
                }
            }
        }
        return count;
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
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[][] indices = stringToInt2dArray(line);

            int ret = new Cells_with_Odd_Values_in_a_Matrix_1252().oddCells(m, n, indices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }


}
