//11. 盛最多水的容器

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        int max=0;
        int min=Integer.MIN_VALUE;
        //因为求面积，所有肯定是长*高，长度肯定是越长越好，所以是从第0为与最后一位为最长，向内计算，
        // 所以一个从0开始，一个从length-1开始，但是为了控制执行时间和复杂度，所以需要跳过一些不必要的计算
        for (int i = 0; i < height.length; i++) {
            //如果比目前最小的高度还小的那就没有必要算了
                if(height[i]<min){
                    continue;
                }
            for (int j = height.length-1; j >i ; j--) {
                //如果比目前最小的高度还小的那就没有必要算了
                if(height[j]<min)
                    continue;
                min=Math.min(height[i],height[j]);
                int len=j-i;
                int total=min*len;
                max=total>max?total:max;
            }
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
            int[] height = stringToIntegerArray(line);

            int ret = new ContainerWithMostWater_11().maxArea(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
