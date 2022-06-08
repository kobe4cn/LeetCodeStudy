import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//239. 滑动窗口最大值
public class Sliding_Window_Maximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();

        List<Integer> max = new ArrayList<>();
        //保证队列的大小，只有留大很，次大，以及最新加入进来的一个数字，如果新进入的数组比队列最后的大，那就把队列最后的抛弃掉，因为队列最后的应该是之前加入进来的，肯定不如最后加入进来的参与后面的计算的时间长
        //所以需要保留
        for (int i = 0; i < k; i++) {
            while(!list.isEmpty() && nums[i]>list.getLast()){
                list.removeLast();
            }
            list.offer(nums[i]);

        }
       // int maxvalue = list.stream().max(Integer::compareTo).get();
        max.add(list.peek());

        for (int i = k; i < nums.length; i++) {
            //如果窗口移动导致需要抛弃的数等于最大的数，那就将该最大数抛弃，由于队列已经经过排序，次大的会自动顶替进来。
            if(nums[i-k]==list.peek()){
                list.poll();
            }
            //判断新加入的是否大于队列最末尾的数据，直到找到比最新加入的小的数据之后存放，也有可能整个队列都被清空了。

            while(!list.isEmpty() && nums[i]>list.getLast()){
                list.removeLast();
            }
            list.offer(nums[i]);
            max.add(list.peek());

        }
        return max.stream().mapToInt(Integer::intValue).toArray();
    }




    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
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
        for (int index = 0; index < length; index++) {
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
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Sliding_Window_Maximum_239().maxSlidingWindow(nums, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
