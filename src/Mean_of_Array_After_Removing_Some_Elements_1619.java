import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

//1619. 删除某些元素后的数组均值
public class Mean_of_Array_After_Removing_Some_Elements_1619 {
    public double trimMean(int[] arr) {
        int size= (int)Math.round(arr.length*0.05);

        Arrays.sort(arr);
        int[] copy = Arrays.copyOfRange(arr, size, arr.length - size);
        double asDouble = Arrays.stream(copy).average().getAsDouble();
        return asDouble;

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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] arr = stringToIntegerArray(line);

            double ret = new Mean_of_Array_After_Removing_Some_Elements_1619().trimMean(arr);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}
