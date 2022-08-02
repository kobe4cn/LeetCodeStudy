import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1184. 公交站间的距离
public class Distance_Between_Bus_Stops_1184 {
    public int distanceBetweenBusStops(int[] distance, int start1, int destination1) {
        //int len=destination-start;
        int forowrd=0;
        int start=start1;
        int destination=destination1;
        //如果开始的站点大于结束站点，那就变换下，保证数组的正向循环
        if(start1>destination1){
            start=destination1;
            destination=start1;
        }
        for (int i = start; i < destination; i++) {
            forowrd+=distance[i];
        }
        int backword=0;
        int len=distance.length;
        //遍历下整个路径的总长。
        for (int i = 0; i <distance.length; i++) {
            backword+=distance[i];
        }
        //减去正向循环的获得的长度那就是逆向的长度
        backword=backword-forowrd;
        int min = Math.min(forowrd, Math.abs(backword));
        return min;

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] distance = stringToIntegerArray(line);
            line = in.readLine();
            int start = Integer.parseInt(line);
            line = in.readLine();
            int destination = Integer.parseInt(line);

            int ret = new Distance_Between_Bus_Stops_1184().distanceBetweenBusStops(distance, start, destination);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
