import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//134. 加油站
public class Gas_Station_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gass=0;
        int start=0;
        //初始化数组的长度，先将数组的长度负值给这个变量，因为是循环，所以之后会将新的长度负值。
        int length=gas.length;
        for (int i = 0; i < length; i++) {
            //将获得油负值给总油量这个变量
            gass+=gas[i];
            //如果总油量大于大下一个加油站的损耗，那就可以往下走。
            if(gass>=cost[i]){
                gass=gass-cost[i];
            }else{
                //如果没有办法往下走，那就要从下一个索引开始，同时将总油量清空，开始索引+1，
                gass=0;
                start=i+1;
                continue;
            }
            //如果不是从0开始的，i+1已经等于数组的长度了，并且开始的索引小于这个数组的长度。
            //将i重置，因为之后有i++，所以初始化成-1，同时将数组的长度初始化成start，因为从0开始循环到start索引就可以了
            if(i+1==length && start<length){
                i=-1;
                length=start;
            }
            //如果已经循环了一次，i+1又等于start证明可以循环
            if(i+1==start){
                return start;
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
            int[] gas = stringToIntegerArray(line);
            line = in.readLine();
            int[] cost = stringToIntegerArray(line);

            int ret = new Gas_Station_134().canCompleteCircuit(gas, cost);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
