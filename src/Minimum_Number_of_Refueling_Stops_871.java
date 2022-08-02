import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//871. 最低加油次数
public class Minimum_Number_of_Refueling_Stops_871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n=stations.length;
        int[] dp=new int[n+1];
        dp[0]=startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j>=0 ; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
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
            int target = Integer.parseInt(line);
            line = in.readLine();
            int startFuel = Integer.parseInt(line);
            line = in.readLine();
            int[][] stations = stringToInt2dArray(line);

            int ret = new Minimum_Number_of_Refueling_Stops_871().minRefuelStops(target, startFuel, stations);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
