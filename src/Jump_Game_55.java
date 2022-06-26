import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//55. 跳跃游戏
public class Jump_Game_55 {
    public boolean canJump(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums.length==1){
            return true;
        }
        //覆盖范围
        int coverRange = nums[0];
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

//    public boolean jump(int[] nums,int num){
//        for(int i=nums[num];i>0;i--){
//
//            if(nums[i]+i>=nums.length){
//                return true;
//            }else if(num==nums.length-2 && nums[num]==0){
//                return false;
//            }else{
//
//            }
//
//        }
//    }

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
            int[] nums = stringToIntegerArray(line);

            boolean ret = new Jump_Game_55().canJump(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
