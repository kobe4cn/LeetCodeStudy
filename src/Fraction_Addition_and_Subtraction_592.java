import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//592. 分数加减运算
public class Fraction_Addition_and_Subtraction_592 {
    public String fractionAddition(String expression) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        List<String> exp = new ArrayList<>();
        //先找到+ or -
        String[] split = expression.split("/");
        for (int i = 0; i < split.length; i++) {
            int index1 = split[i].indexOf("+");
            int index2 = split[i].indexOf("-");
            //+
            if (index1 > 0) {
                String[] strings = split[i].split("\\+");
                down.add(Integer.parseInt(strings[0]));
                up.add(Integer.parseInt(strings[1]));
                exp.add("+");
            }
            //-
            if (index2 > 0) {
                String[] strings = split[i].split("-");
                down.add(Integer.parseInt(strings[0]));
                up.add(Integer.parseInt(strings[1]));
                exp.add("-");
            }
            if (i == 0) {
                up.add(Integer.parseInt(split[i]));
            } else if (i == split.length - 1) {
                down.add(Integer.parseInt(split[i]));
            }
        }
        //获得分母的值
        Integer integer1 = down.stream().distinct().reduce((integer, integer2) -> integer * integer2).get();
        int count = 0;
        for (int i = 0; i < up.size(); i++) {
            int value = integer1 / down.get(i);
            int temp = up.get(i) * value;
            if (i == 0) {
                count += temp;
            } else {
                String sexp = exp.get(i - 1);
                if (sexp.equals("+")) {
                    count += temp;
                } else if (sexp.equals("-")) {
                    count -= temp;
                }
            }
        }
        if (count == 0) {
            return "0/1";
        } else if (count == 1 || count == -1) {
            return count + "/" + integer1;
        } else if (count == integer1) {
            return "1/1";
        } else if (integer1 == 1) {
            return count + "/1";
        } else {

            //网上找一个方法求最大公约数
            int m = integer1;
            int n = count;
            int z = 0;
            while (m % n != 0) {
                z = m % n;
                m = n;
                n = z;
            }

            return count/Math.abs(n)+"/"+integer1/Math.abs(n);

        }
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String expression = stringToString(line);

            String ret = new Fraction_Addition_and_Subtraction_592().fractionAddition(expression);

            String out = (ret);

            System.out.print(out);
        }
    }
}
