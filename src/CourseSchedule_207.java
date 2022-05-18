import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//207. 课程表
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int[] course:prerequisites
             ) {

            //判断是否有错误的课程
            if(course[0]==course[1]){
                return false;
            }
            if(map.containsKey(course[0])){
                List<Integer> nextcourse=new ArrayList<>();
                nextcourse=map.get(course[0]);
                Queue<Integer> queue=new LinkedList<>(nextcourse);
                while(!queue.isEmpty()){
                    int temp=queue.remove();
                    if(map.containsKey(temp)){
                        queue.addAll(map.get(temp));
                    }
                    if(temp==course[1]){
                        return false;
                    }
                }
            }
            //加入进去
            if(map.containsKey(course[1])){
                map.get(course[1]).add(course[0]);

            }else {
                //从来都不存在这个课程安排就直接新增
                List<Integer> nextcourse=new ArrayList<>();
                nextcourse.add(course[0]);
                map.put(course[1], nextcourse);
            }
        }

        return true;
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
            int numCourses = Integer.parseInt(line);
            line = in.readLine();
            int[][] prerequisites = stringToInt2dArray(line);

            boolean ret = new CourseSchedule_207().canFinish(numCourses, prerequisites);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
