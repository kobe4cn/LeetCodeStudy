import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1413. 逐步求和得到正数的最小值
public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum_1413 {
    public int minStartValue(int[] nums) {
        int start=1;
        if(nums[0]<0){
            start=Math.abs(nums[0])+1;
        }
//        else{
//            start=nums[0];
//        }
        //int count=0;
        boolean check=true;
        while(check) {
            int count =start;
            int less=1;
            for (int i = 0; i < nums.length; i++) {
                count+=nums[i];
                if (count < 1) {
                    start++;
                    less=0;
                    break;
                }
            }
            if(less==1){
                check=false;
            }
        }
        return start;
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
            int[] nums = stringToIntegerArray(line);

            int ret = new Minimum_Value_to_Get_Positive_Step_by_Step_Sum_1413().minStartValue(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
