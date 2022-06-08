import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1037. 有效的回旋镖
public class Valid_Boomerang_1037 {
    public boolean isBoomerang(int[][] points) {
        Arrays.stream(points).sorted((o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });
        int ax=points[0][0];
        int ay=points[0][1];
        int bx=points[1][0];
        int by=points[1][1];
        int cx=points[2][0];
        int cy=points[2][1];
        //a到c之间的直线
        //double ac = Math.sqrt(Math.pow(cy - ay, 2) + Math.pow(cx - ax, 2));
        int acx=cx - ax;
        int acy=cy - ay;

        //b到a的直接长度
        int abx=bx-ax;
        int aby=by-ay;
        //b到c的直线长度
       // double bc=Math.sqrt(Math.pow(cy-by,2)+Math.pow(cx-bx,2));
        int bcx=cx-bx;
        int bcy=cy-by;
//        if(ac==0 || ab==0||bc==0){
//            return false;
//        }
        //斜率比较，因为是两个点之间的连线可以看成是三角形的一条边，如果要判断三个点是否在一条之间，那就看这三个点之间的连线就三角的一条边，的角度是否是一致的
        //因为之前已经做了点的排序，所以已经有了abc三点，每个点的x和y轴都是递增的，所以只要计算最远的两个之间的斜率，与其中任意两点的斜率是否一致就表示这三个点是否在同一直线上。
        //如果斜率一致就说明在同一直线上

        return acy*abx!=acx*aby;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] points = stringToInt2dArray(line);

            boolean ret = new Valid_Boomerang_1037().isBoomerang(points);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
