import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1460. 通过翻转子数组使两个数组相等
public class Make_Two_Arrays_Equal_by_Reversing_1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
                if(target[i]!=arr[i]){
                    return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] target = stringToIntegerArray(line);
            line = in.readLine();
            int[] arr = stringToIntegerArray(line);

            boolean ret = new Make_Two_Arrays_Equal_by_Reversing_1460().canBeEqual(target, arr);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

}
