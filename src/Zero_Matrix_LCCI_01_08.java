import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 零矩阵
public class Zero_Matrix_LCCI_01_08 {

    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue=new LinkedList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    int[] a={i,j};
                    queue.offer(a);
                }
            }
        }
        while (!queue.isEmpty()){
            int[] remove = queue.remove();
            for (int i = 0; i < m; i++) {
                matrix[i][remove[1]]=0;
            }
            for (int i = 0; i < n; i++) {
                matrix[remove[0]][i]=0;
            }
        }
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

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            for (int it:item) {
                sb.append(Integer.toString(it));
                sb.append(",");
            }
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            new Zero_Matrix_LCCI_01_08().setZeroes(matrix);
            String out = int2dArrayToString(matrix);

            System.out.print(out);
        }
    }
}
