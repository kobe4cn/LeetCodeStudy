import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

//57. 插入区间
public class InsertInterval_57 {
    TreeMap<Integer,Integer> map;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        map=new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0],intervals[i][1]);
        }
        addRange(newInterval[0],newInterval[1] );
        int[][] returns=new int[map.size()][2];
        Iterator<Integer> iterator = map.keySet().iterator();
        int i=0;
        while (iterator.hasNext()){
            int key=iterator.next();
            int values=map.get(key);
            returns[i][0]=key;
            returns[i][1]=values;
            i++;
        }
        return returns;
    }
    public void addRange(int left, int right) {
        if(left>right){ return;}
        Integer start=map.floorKey(left);
        if(start==null)
            start=map.ceilingKey(left);
        while(start!=null && start<=right){
            int end=map.get(start);

            if(end>=left){
                map.remove(start);

                if(start<left){
                    left=start;
                }
                if(end>right)
                    right=end;
            }

            start=map.ceilingKey(end);

            if(start!=null && start==end){
                start=map.higherKey(end);
            }
        }
        map.put(left,right);
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
            sb.append("[");
            for (int i:item
                 ) {
                sb.append(i);
                sb.append(",");
            }

            sb.append("],");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] intervals = stringToInt2dArray(line);
            line = in.readLine();
            int[] newInterval = stringToIntegerArray(line);

            int[][] ret = new InsertInterval_57().insert(intervals, newInterval);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}
