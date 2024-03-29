import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Defuse_the_Bomb_1652 {
    public int[] decrypt(int[] code, int k) {
        int[] copy = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            int temp=i;
            int ii=i;
            if(k>0){
                for (int j = 1; j <=k; j++) {
                    if(ii+j==code.length){
                        ii=0-j;
                    }
                    copy[temp]+=code[ii+j];
                }
            }else if(k<0){
                //int kk= Math.abs(k);
                for (int j = -1; j >=k; j--) {
                    if(ii+j==-1){
                        ii=code.length-1+Math.abs(j);
                    }
                    copy[temp]+=code[ii+j];
                }
            }else if(k==0){
            }
        }
        return copy;
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] code = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Defuse_the_Bomb_1652().decrypt(code, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
