import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//45. 跳跃游戏 II
public class Jump_Game_II_45 {

        public int jump(int[] nums) {
            if (nums == null || nums.length == 0 || nums.length == 1) {
                return 0;
            }
            //记录跳跃的次数
            int count=0;
            //当前的覆盖最大区域
            int curDistance = 0;
            //最大的覆盖区域
            int maxDistance = 0;
            for (int i = 0; i < nums.length; i++) {
                //在可覆盖区域内更新最大的覆盖区域
                maxDistance = Math.max(maxDistance,i+nums[i]);
                //说明当前一步，再跳一步就到达了末尾
                if (maxDistance>=nums.length-1){
                    count++;
                    break;
                }
                //走到当前覆盖的最大区域时，更新下一步可达的最大区域
                if (i==curDistance){
                    curDistance = maxDistance;
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
            int[] nums = stringToIntegerArray(line);

            int ret = new Jump_Game_II_45().jump(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
