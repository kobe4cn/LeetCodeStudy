import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//565. 数组嵌套
public class Array_Nesting_565 {
    public int arrayNesting(int[] nums) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //如果已经是负值了，肯定已经被其他的使用过了，肯定比这个开始的多了

            if(nums[i]<0){
                continue;
            }
            int n=i;
            int count=0;
            while(nums[n]>=0){
                count++;
                int temp=nums[n];
                //设置负值一个为了判断已经使用过跳出while，一个是为最上面的判断是否已经是过continue剪支
                nums[n]=-1;

                n=temp;
            }
            max=Math.max(count,max);
        }
        return max;
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

            int ret = new Array_Nesting_565().arrayNesting(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
