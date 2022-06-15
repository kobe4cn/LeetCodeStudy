import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//719. 找出第 K 小的数对距离
public class Find_K_th_Smallest_Pair_Distance_719 {
    public int smallestDistancePair(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Arrays.sort(nums);
        //int value=nums.length*(nums.length-1)/2;
        int temp=nums[nums.length-1]-nums[0]+1;
        //申请的数组内存空间是关键，最大数-最小数据+1
        int[] arr=new int[temp];
        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                arr[abs]++;
            }
        }
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            count+=arr[i];
            if(count>=k){
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Find_K_th_Smallest_Pair_Distance_719().smallestDistancePair(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
