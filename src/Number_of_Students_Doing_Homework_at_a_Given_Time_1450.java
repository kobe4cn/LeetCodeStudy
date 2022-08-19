import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1450. 在既定时间做作业的学生人数
public class Number_of_Students_Doing_Homework_at_a_Given_Time_1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i]<=queryTime && endTime[i]>=queryTime){
                count++;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] startTime = stringToIntegerArray(line);
            line = in.readLine();
            int[] endTime = stringToIntegerArray(line);
            line = in.readLine();
            int queryTime = Integer.parseInt(line);

            int ret = new Number_of_Students_Doing_Homework_at_a_Given_Time_1450().busyStudent(startTime, endTime, queryTime);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
