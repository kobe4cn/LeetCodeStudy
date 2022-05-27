import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//994. 腐烂的橘子
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        //必须遍历第0分钟开始，已经存在多少坏苹果，所有的坏苹果都需要一起放进Q中进行遍历和循环，每次增加一分钟看有多少苹果变坏，直到所有的变坏或者有些永远不会变坏
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] point = {i, j};
                    list.add(point);
                }
            }
        }

        int minutes=0;
        Queue<int[]> queue = new LinkedList<>(list);
        while (!queue.isEmpty()) {
            int count = queue.size();
            //判断虽然找到坏橘子，但是不一定感染的。
            int check=0;
            for (int k = 0; k < count; k++) {
                int[] orange = queue.remove();
                int y=orange[0];
                int x=orange[1];
                //已经扫描过的橘子设置成3
                grid[y][x]=3;
                //判断这个四周是否有好的橙子
                //左
                if(x-1>=0 && grid[y][x-1]==1){
                    check++;
                    int[] neworange={y,x-1};
                    queue.add(neworange);
                    grid[y][x-1]=3;
                }
                //上
                if(y-1>=0 && grid[y-1][x]==1){
                    check++;
                    int[] neworange={y-1,x};
                    queue.add(neworange);
                    grid[y-1][x]=3;
                }
                //右
                if(x+1<grid[0].length && grid[y][x+1]==1){
                    check++;
                    int[] neworange={y,x+1};
                    queue.add(neworange);
                    grid[y][x+1]=3;
                }
                //下
                if(y+1<grid.length && grid[y+1][x]==1){
                    check++;
                    int[] neworange={y+1,x};
                    queue.add(neworange);
                    grid[y+1][x]=3;
                }
            }
            if(check>0){
                minutes++;
            }

        }
        boolean b = Arrays.stream(grid).anyMatch(ints -> Arrays.stream(ints).anyMatch(value -> value == 1));
        if(b){return -1;}else{
            return minutes;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new RottingOranges_994().orangesRotting(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
