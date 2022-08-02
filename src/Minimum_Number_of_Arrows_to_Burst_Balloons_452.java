import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

//452. 用最少数量的箭引爆气球
public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {
    public int findMinArrowShots(int[][] points) {
        List<int[]> ints = Arrays.stream(points).sorted((o1, o2) -> o1[0] - o2[0]).toList();
        int[] temp=new int[2];
        if(ints.size()>0){
            temp=ints.get(0);
        }

//        这个是二维数组排序的最佳写法
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] e1, int[] e2) {
//                if (e1[0]==e2[0]) return e1[1]-e2[1];   // e1[1]-e2[1]表示对于第二列元素进行升序排序
//                return e1[0]-e2[0];
//            }
//        });
        int count=0;
        for (int i = 1; i < ints.size(); i++) {
            int x=0;
            int y=0;
            int[] ints1 = ints.get(i);
            if(ints1[0]<=temp[1] && ints1[0]>=temp[0]) {
                x = ints1[0];
                if(temp[1]<ints1[1])
                    y=temp[1];
                else
                    y=ints1[1];
            }else {
                x = ints1[0];
                y = ints1[1];
                count++;
            }


            temp[0]=x;
            temp[1]=y;

        }
        count++;
        //ints.size();
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
            int[][] points = stringToInt2dArray(line);

            int ret = new Minimum_Number_of_Arrows_to_Burst_Balloons_452().findMinArrowShots(points);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
