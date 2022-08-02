import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//860. 柠檬水找零
public class Lemonade_Change_860 {
    public boolean lemonadeChange(int[] bills) {
        //Arrays.sort(bills);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    if (!map.containsKey(bills[i])) {
                        map.put(bills[i], 1);
                    } else {
                        map.computeIfPresent(bills[i], (integer, integer2) -> ++integer2);
                    }
                    break;
                case 10:
                    if (!map.containsKey(bills[i])) {
                        map.put(bills[i], 1);
                    } else {
                        map.computeIfPresent(bills[i], (integer, integer2) -> ++integer2);
                    }
                    Integer integer1 = map.computeIfPresent(5, (integer, integer2) -> --integer2);
                    if (integer1 == null || integer1 < 0) {
                        return false;
                    }
                    break;
                case 20:
                    if (!map.containsKey(bills[i])) {
                        map.put(bills[i], 1);
                    } else {
                        map.computeIfPresent(bills[i], (integer, integer2) -> ++integer2);
                    }
                    //退10+5，如果10没有，则是尝试3个5，如果5没有，直接返回失败
                    Integer integer = map.get(5);
                    Integer integer2 = map.get(10);
                    if (integer == null || integer <= 0) {
                        return false;
                    }
                    if (integer2 == null || integer2 <= 0) {
                        if (integer < 3) {
                            return false;
                        }
                        map.computeIfPresent(5,(integer3, integer21) -> integer21-3);
                    }else {
                        map.computeIfPresent(10, (integer3, integer21) -> --integer21);
                        map.computeIfPresent(5, (integer3, integer21) -> --integer21);
                    }
                    break;
            }
        }
        return true;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] bills = stringToIntegerArray(line);

            boolean ret = new Lemonade_Change_860().lemonadeChange(bills);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
