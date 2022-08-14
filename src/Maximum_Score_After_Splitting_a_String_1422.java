//1422. 分割字符串的最大得分

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Maximum_Score_After_Splitting_a_String_1422 {

    public int maxScore(String s) {

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        int max=Integer.MIN_VALUE;
        //因为需要至少保留一位1，所以只能到list size-1位
        for (int i = 0; i < list.size()-1; i++) {
            List<Integer> left = list.subList(0, i + 1);
            List<Integer> right = list.subList(i + 1, list.size());
            int leftcount =(int) left.stream().filter(integer -> integer == 0).count();
            int rightcount = (int)right.stream().filter(integer -> integer == 1).count();
            max=Math.max(max,(leftcount+rightcount));
        }
        return max;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Maximum_Score_After_Splitting_a_String_1422().maxScore(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
