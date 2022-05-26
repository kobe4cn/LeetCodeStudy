import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1136. 平行课程
public class ParallelCourses_1136 {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer,List<Integer>> map=new TreeMap<>(Integer::compareTo);
        for (int[] relation : relations) {
            if(map.containsKey(relation[1])){
                map.get(relation[1]).add(relation[0]);

            }else{
                List<Integer> list=new ArrayList<>();
                list.add(relation[0]);
                map.put(relation[1],list);
            }
        }

        int[] res=new int[n];
        for (int i = 1; i <=n; i++) {
            //如果有该门课程的前序课程存在
            if(map.containsKey(i)){
                Queue<Integer> queue=new LinkedList<>();
                List<Integer> maplist=map.get(i);
                maplist.forEach(integer -> queue.add(integer));
                int count=1;
                while(!queue.isEmpty()){
                    int qsize=queue.size();
                    count++;
                    //一个学期一次循环
                    for (int j = 0; j < qsize; j++) {
                        Integer key=queue.remove();
                        if(key==i) return -1;
                        res[i-1]=count;
                        //如果存在key
                        if(map.containsKey(key)){
                            List<Integer> templist=map.get(key);

                            templist.forEach(integer -> {
                                queue.add(integer);
                            });
                        }
                    }
                }
            }
        }
        return Arrays.stream(res).max().getAsInt();
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
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[][] relations = stringToInt2dArray(line);

            int ret = new ParallelCourses_1136().minimumSemesters(n, relations);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
