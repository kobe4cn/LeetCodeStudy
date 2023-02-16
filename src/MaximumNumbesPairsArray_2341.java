import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//2341. 数组能形成多少数对
public class MaximumNumbesPairsArray_2341 {
    public int[] numberOfPairs(int[] nums) {
        boolean check=true;
        int total=0;
        while(check){
            int count=0;
            for (int i = 1; i < nums.length; i++) {
                if(nums[0]==nums[i]){
                    nums=removeElement(nums, i);
                    nums=removeElement(nums, 0);
                    count++;
                    total++;
                    break;
                }
            }
            if(count==0){
                check=false;
            }
        }
        int[] result=new int[2];
        result[0]=total;
        result[1]=nums.length;

        return result;
    }

    public static int[] removeElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
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
            int[] nums = stringToIntegerArray(line);
            
            int[] ret = new MaximumNumbesPairsArray_2341().numberOfPairs(nums);
            
            String out = integerArrayToString(ret);
            
            //System.out.print(out);
        }
    }
}
